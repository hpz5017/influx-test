package edu.pitt.medschool.algorithm;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.pitt.medschool.controller.analysis.vo.DownsampleGroupVO;
import edu.pitt.medschool.model.DataTimeSpanBean;
import edu.pitt.medschool.model.dto.DownsampleGroup;

/**
 * Queries for doing the downsample-aggregation query
 * Refactor from AnalysisService.exportToFile
 */
public class ExportQuery {

    private static class Template {
        static final String defaultDownsampleColName = "ds_label_";
        static final String defaultAggregationColName = "ag_label_";

        static final String basicSelectInner = "SELECT %s FROM \"%s\" WHERE %s";
        static final String basicSelectOuter = "SELECT %s FROM %s";
        static final String timeAddDelta = "('%s' + %ds)";
        static final String timeCondition = "(time >= %s AND time <= %s)";
        static final String locatorCondition = "(fileUUID='%s' AND arType='%s')";
        static final String downsampleGroupBy = "GROUP BY time(%ds) fill(none)";
    }

    // Downsample configs
    private DownsampleGroup[] dsGroup;
    private boolean isDownSampleFirst;
    private boolean needAr;
    private List<List<String>> columnNames;
    private int startDelta; // In 's'
    private String globalEndTime; // In 's'
    private int downsampleInterval; // In 's'

    // Metadata for patients
    private String pid;
    private int numDataSegments;
    private List<DataTimeSpanBean> timeseriesMetadata;
    private Instant firstAvailData;

    // Final query string
    private String[] queriesString;
    private String queryString;

    // Meta for downsamples
    private List<Integer> badTimeDataId;
    private List<Integer> goodTimeDataId;

    /**
     * Initialize this class (Expection if dts null or no length)
     *
     * @param d               Data
     * @param v               List of DownsampleGroupVO
     * @param columns         Columns (e.g. I10_4,I11_4)
     * @param downSampleFirst Is Downsample first or aggregation first
     * @param needAr          Export on Ar or Noar
     * @param dsPeriod        Downsample period
     * @param startDelta      Start time (in s)
     * @param duration        Duration (in s)
     */
    public ExportQuery(List<DataTimeSpanBean> d,
                       List<DownsampleGroupVO> v, List<List<String>> columns,
                       boolean downSampleFirst, boolean needAr,
                       int dsPeriod, int startDelta, int duration) throws IllegalArgumentException {
        initData(d, v);
        this.isDownSampleFirst = downSampleFirst;
        this.columnNames = columns;
        this.startDelta = startDelta;
        this.downsampleInterval = dsPeriod;
        this.needAr = needAr;
        this.badTimeDataId = new ArrayList<>(this.numDataSegments);
        this.goodTimeDataId = new ArrayList<>(this.numDataSegments);
        findFirstData(duration);

        buildQuery();
    }

    /**
     * Get the final assembled queries
     * Each unique file uuid would have one query
     */
    public String[] toQueries() {
        if (this.queriesString == null) {
            throw new RuntimeException("Failed to build query string");
        } else {
            return this.queriesString;
        }
    }

    /**
     * Get the final assembled queries in one query
     */
    public String toQuery() {
        if (this.queriesString == null) {
            throw new RuntimeException("Failed to build query string");
        } else {
            if (this.queryString == null) {
                StringBuilder sb = new StringBuilder();
                for (String q : this.queriesString) {
                    if (q == null || q.isEmpty()) continue;
                    sb.append(q);
                    sb.append(';');
                }
                this.queryString = sb.toString();
            }
            return this.queryString;
        }
    }

    /**
     * Get list for bad IDs for `DataTimeSpanBean`
     */
    public List<Integer> getBadDataTimeId() {
        return this.badTimeDataId;
    }

    public List<Integer> getGoodDataTimeId() {
        return this.goodTimeDataId;
    }

    private void buildQuery() {
        this.queriesString = new String[this.numDataSegments];
        // A query for each unique file uuid
        for (int i = 0; i < this.numDataSegments; i++) {
            DataTimeSpanBean d = this.timeseriesMetadata.get(i);
            if (!isDataArTypeGood(d)) {
                this.badTimeDataId.add(i);
                continue;
            }
            this.goodTimeDataId.add(i);
            String whereClause = String.format(Template.locatorCondition,
                    d.getFileUuid(), needAr ? "ar" : "noar");
            // Start operations
            if (!this.isDownSampleFirst) {
                // Downsample then Aggr
                this.queriesString[i] = aggrFirst(whereClause);
            } else {
                // Aggr then Downsample
                throw new RuntimeException("Not implemented");
                // dsFirst(whereClause);
            }
        }
    }

    private String aggrFirst(String locator) {
        String aggrQ = wrapByBracket(aggrDs_Aggr(locator));
        return aggrDs_Ds(aggrQ);
    }

    /**
     * Aggr first, Aggr part
     */
    private String aggrDs_Aggr(String locator) {
        String[] cols = new String[this.dsGroup.length];
        for (int i = 0; i < this.dsGroup.length; i++) {
            DownsampleGroup dg = this.dsGroup[i];
            String colAlias = Template.defaultAggregationColName + String.valueOf(dg.getId());
            switch (dg.getAggregation().toLowerCase()) {
                case "mean":
                    cols[i] = aggregationColumnsMeanQuery(i, colAlias);
                    break;
                case "sum":
                    cols[i] = aggregationColumnsSumQuery(i, colAlias);
                    break;
                default:
                    throw new RuntimeException("Unsupported aggr type: " + dg.getAggregation());
            }
        }

        String basic = String.format(Template.basicSelectInner,
                String.join(", ", cols), this.pid, locator);
        String startTimeFormat = String.format(Template.timeAddDelta,
                this.firstAvailData.toString(), this.startDelta);

        if (this.globalEndTime == null) {
            // Time >= startDelta
            return basic + " AND time >=" + startTimeFormat;
        } else {
            // Time >= startDelta AND Time <= globalEndTime
            String endTime = String.format(Template.timeCondition,
                    startTimeFormat, wrapByBracket(this.globalEndTime));
            return basic + " AND " + endTime;
        }
    }

    /**
     * Aggr first, Ds part
     */
    private String aggrDs_Ds(String aggrQuery) {
        String[] cols = new String[this.dsGroup.length + 1];
        for (int i = 0; i < this.dsGroup.length; i++) {
            DownsampleGroup dg = this.dsGroup[i];
            String finalColAlias = "label_" + String.valueOf(i);
            String oper = formAggrFunction(dg,
                    Template.defaultAggregationColName + String.valueOf(dg.getId()));
            cols[i] = selectQueryWithAlias(oper, finalColAlias);
        }
        // A count column
        cols[this.dsGroup.length] = String.format("COUNT(%s) AS COUNT",
                Template.defaultAggregationColName + this.dsGroup[0].getId());

        String basic = String.format(Template.basicSelectOuter,
                String.join(", ", cols),
                wrapByBracket(aggrQuery));
        return basic + " " +
                String.format(Template.downsampleGroupBy, this.downsampleInterval);
    }

    private void dsFirst(String locator) {

    }

    /**
     * Ds first, Ds part
     */
    private String dsAggr_Ds(String locator) {
        String[] cols = new String[this.dsGroup.length];
        for (int i = 0; i < cols.length; i++) {
            DownsampleGroup dg = this.dsGroup[i];
        }
        return "";
    }

    /**
     * Ds first, Aggr part
     */
    private String dsAggr_Aggr() {

        return "";
    }


    /**
     * MEAN(some_column)
     */
    private String formAggrFunction(DownsampleGroup dg, String originalColAlias) {
        String oper;
        switch (dg.getDownsample().toLowerCase()) {
            case "mean":
                oper = String.format("MEAN(%s)", originalColAlias);
                break;
            case "median":
                oper = String.format("MEDIAN(%s)", originalColAlias);
                break;
            case "sum":
                oper = String.format("SUM(%s)", originalColAlias);
                break;
            case "stddev":
                oper = String.format("STDDEV(%s)", originalColAlias);
                break;
            case "min":
                oper = String.format("MIN(%s)", originalColAlias);
                break;
            case "max":
                oper = String.format("MAX(%s)", originalColAlias);
                break;
            case "25":
                oper = String.format("PERCENTILE(%s,25)", originalColAlias);
                break;
            case "75":
                oper = String.format("PERCENTILE(%s,75)", originalColAlias);
                break;
            default:
                throw new RuntimeException("Unsupported ds type: " + dg.getDownsample());
        }
        return oper;
    }

    /**
     * Extract from `DataTimeSpanBean` to set some basic info for this class
     */
    private void initData(List<DataTimeSpanBean> dts, List<DownsampleGroupVO> v) {
        if (dts == null || dts.isEmpty()) throw new IllegalArgumentException("DataTimeSpanBean empty");
        this.pid = dts.get(0).getPid();
        this.numDataSegments = dts.size();
        this.timeseriesMetadata = dts;
        this.dsGroup = v.stream().map(DownsampleGroupVO::getGroup).toArray(DownsampleGroup[]::new);
    }

    // Find the first data, all internals are available
    private void findFirstData(int duration) {
        // A 'large' data acts as maxi
        this.firstAvailData = Instant.now();
        for (DataTimeSpanBean d : this.timeseriesMetadata) {
            if (!isDataArTypeGood(d)) continue;
            Instant tmpS = d.getStart();
            if (tmpS.compareTo(this.firstAvailData) < 0)
                this.firstAvailData = tmpS;
        }

        if (duration > 1) {
            this.globalEndTime = String.format("'%s' + %ds",
                    this.firstAvailData.toString(), duration);
        } else {
            this.globalEndTime = null;
        }
    }

    /**
     * GROUP BY time(10s) fill(none)
     */
    private String downsampleGroupBy(int sec) {
        return String.format(Template.downsampleGroupBy, sec);
    }

    /**
     * (arType='ar' and fileUUID='xxxx')
     */
    private String whereFileUuidAndarType(String uuid, boolean isAr) {
        return String.format(Template.locatorCondition,
                uuid, isAr ? "ar" : "noar");
    }

    /**
     * Concat the column name list into an add string: ("f1"+"f2")
     * For aggregation
     *
     * @param alias Alias for this list, null for not using
     */
    private String aggregationColumnsSumQuery(int i, String alias) {
        return selectQueryWithAlias(
                wrapByBracket(this.columnNames.get(i).stream()
                        .map(s -> "\"" + s + "\"")
                        .collect(Collectors.joining(" + "))
                ), alias);
    }

    /**
     * Concat the column name list into an mean string": (("f1"+"f2")/2)
     * For aggregation
     *
     * @param alias Alias for this list, null for not using
     */
    private String aggregationColumnsMeanQuery(int i, String alias) {
        return selectQueryWithAlias(
                String.format("(%s/%d)",
                        aggregationColumnsSumQuery(i, null),
                        this.columnNames.get(i).size()),
                alias);
    }

    /**
     * If already wrapped then do nothing
     * "f1"+"f2" -> ("f1"+"f2")
     */
    private String wrapByBracket(String toWrap) {
        if (toWrap.startsWith("(") && toWrap.endsWith(")"))
            return toWrap;
        return String.format("(%s)", toWrap);
    }

    /**
     * Give alias for select statements
     * (I10_1,I10_2) -> (I10_1,I10_2) AS A
     *
     * @param origin Original select obj
     * @param alias  Alias, null for not using
     */
    private String selectQueryWithAlias(String origin, String alias) {
        if (alias == null) return origin;
        else return String.format("%s AS %s", wrapByBracket(origin), alias);
    }

    /**
     * This DataTimeSpanBean of our interest?
     */
    private boolean isDataArTypeGood(DataTimeSpanBean d) {
        DataTimeSpanBean.ArStatus as = d.getArStat();
        if (needAr) {
            // Need Ar but this UUID only has NoAr
            return !as.equals(DataTimeSpanBean.ArStatus.NoArOnly);
        } else {
            // Need NoAr but this UUID only has Ar
            return !as.equals(DataTimeSpanBean.ArStatus.ArOnly);
        }
    }

}
