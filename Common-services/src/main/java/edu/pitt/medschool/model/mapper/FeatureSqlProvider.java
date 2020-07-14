package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.Feature;
import edu.pitt.medschool.model.dto.FeatureExample.Criteria;
import edu.pitt.medschool.model.dto.FeatureExample.Criterion;
import edu.pitt.medschool.model.dto.FeatureExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FeatureSqlProvider {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String countByExample(FeatureExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("feature");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String deleteByExample(FeatureExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("feature");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String insertSelective(Feature record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("feature");
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        if (record.getSid() != null) {
            sql.VALUES("SID", "#{sid,jdbcType=VARCHAR}");
        }
        if (record.getSidCount() != null) {
            sql.VALUES("SID_Count", "#{sidCount,jdbcType=INTEGER}");
        }
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        if (record.getElectrode() != null) {
            sql.VALUES("electrode", "#{electrode,jdbcType=VARCHAR}");
        }
        if (record.getFreqLow() != null) {
            sql.VALUES("freq_low", "#{freqLow,jdbcType=DOUBLE}");
        }
        if (record.getFreqHigh() != null) {
            sql.VALUES("freq_high", "#{freqHigh,jdbcType=DOUBLE}");
        }
        if (record.getBrainLocation() != null) {
            sql.VALUES("brain_location", "#{brainLocation,jdbcType=VARCHAR}");
        }
        if (record.getNotes() != null) {
            sql.VALUES("notes", "#{notes,jdbcType=VARCHAR}");
        }
        if (record.getCsvName() != null) {
            sql.VALUES("csv_name", "#{csvName,jdbcType=VARCHAR}");
        }
        if (record.getCsvId() != null) {
            sql.VALUES("csv_id", "#{csvId,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String selectByExample(FeatureExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("SID");
        sql.SELECT("SID_Count");
        sql.SELECT("type");
        sql.SELECT("electrode");
        sql.SELECT("freq_low");
        sql.SELECT("freq_high");
        sql.SELECT("brain_location");
        sql.SELECT("notes");
        sql.SELECT("csv_name");
        sql.SELECT("csv_id");
        sql.FROM("feature");
        applyWhere(sql, example, false);
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Feature record = (Feature) parameter.get("record");
        FeatureExample example = (FeatureExample) parameter.get("example");
        SQL sql = new SQL();
        sql.UPDATE("feature");
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        if (record.getSid() != null) {
            sql.SET("SID = #{record.sid,jdbcType=VARCHAR}");
        }
        if (record.getSidCount() != null) {
            sql.SET("SID_Count = #{record.sidCount,jdbcType=INTEGER}");
        }
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        if (record.getElectrode() != null) {
            sql.SET("electrode = #{record.electrode,jdbcType=VARCHAR}");
        }
        if (record.getFreqLow() != null) {
            sql.SET("freq_low = #{record.freqLow,jdbcType=DOUBLE}");
        }
        if (record.getFreqHigh() != null) {
            sql.SET("freq_high = #{record.freqHigh,jdbcType=DOUBLE}");
        }
        if (record.getBrainLocation() != null) {
            sql.SET("brain_location = #{record.brainLocation,jdbcType=VARCHAR}");
        }
        if (record.getNotes() != null) {
            sql.SET("notes = #{record.notes,jdbcType=VARCHAR}");
        }
        if (record.getCsvName() != null) {
            sql.SET("csv_name = #{record.csvName,jdbcType=VARCHAR}");
        }
        if (record.getCsvId() != null) {
            sql.SET("csv_id = #{record.csvId,jdbcType=INTEGER}");
        }
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("feature");
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("SID = #{record.sid,jdbcType=VARCHAR}");
        sql.SET("SID_Count = #{record.sidCount,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("electrode = #{record.electrode,jdbcType=VARCHAR}");
        sql.SET("freq_low = #{record.freqLow,jdbcType=DOUBLE}");
        sql.SET("freq_high = #{record.freqHigh,jdbcType=DOUBLE}");
        sql.SET("brain_location = #{record.brainLocation,jdbcType=VARCHAR}");
        sql.SET("notes = #{record.notes,jdbcType=VARCHAR}");
        sql.SET("csv_name = #{record.csvName,jdbcType=VARCHAR}");
        sql.SET("csv_id = #{record.csvId,jdbcType=INTEGER}");
        FeatureExample example = (FeatureExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(Feature record) {
        SQL sql = new SQL();
        sql.UPDATE("feature");
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        if (record.getElectrode() != null) {
            sql.SET("electrode = #{electrode,jdbcType=VARCHAR}");
        }
        if (record.getFreqLow() != null) {
            sql.SET("freq_low = #{freqLow,jdbcType=DOUBLE}");
        }
        if (record.getFreqHigh() != null) {
            sql.SET("freq_high = #{freqHigh,jdbcType=DOUBLE}");
        }
        if (record.getBrainLocation() != null) {
            sql.SET("brain_location = #{brainLocation,jdbcType=VARCHAR}");
        }
        if (record.getNotes() != null) {
            sql.SET("notes = #{notes,jdbcType=VARCHAR}");
        }
        if (record.getCsvName() != null) {
            sql.SET("csv_name = #{csvName,jdbcType=VARCHAR}");
        }
        if (record.getCsvId() != null) {
            sql.SET("csv_id = #{csvId,jdbcType=INTEGER}");
        }
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        sql.WHERE("SID = #{sid,jdbcType=VARCHAR}");
        sql.WHERE("SID_Count = #{sidCount,jdbcType=INTEGER}");
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..feature
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, FeatureExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(
                                    String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(),
                                    i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}