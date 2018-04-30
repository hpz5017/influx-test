package edu.pitt.medschool.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImportLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table import_log
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table import_log
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table import_log
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public ImportLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table import_log
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("batch_id like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("batch_id not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andAllPercentIsNull() {
            addCriterion("all_percent is null");
            return (Criteria) this;
        }

        public Criteria andAllPercentIsNotNull() {
            addCriterion("all_percent is not null");
            return (Criteria) this;
        }

        public Criteria andAllPercentEqualTo(Double value) {
            addCriterion("all_percent =", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentNotEqualTo(Double value) {
            addCriterion("all_percent <>", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentGreaterThan(Double value) {
            addCriterion("all_percent >", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentGreaterThanOrEqualTo(Double value) {
            addCriterion("all_percent >=", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentLessThan(Double value) {
            addCriterion("all_percent <", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentLessThanOrEqualTo(Double value) {
            addCriterion("all_percent <=", value, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentIn(List<Double> values) {
            addCriterion("all_percent in", values, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentNotIn(List<Double> values) {
            addCriterion("all_percent not in", values, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentBetween(Double value1, Double value2) {
            addCriterion("all_percent between", value1, value2, "allPercent");
            return (Criteria) this;
        }

        public Criteria andAllPercentNotBetween(Double value1, Double value2) {
            addCriterion("all_percent not between", value1, value2, "allPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentIsNull() {
            addCriterion("this_percent is null");
            return (Criteria) this;
        }

        public Criteria andThisPercentIsNotNull() {
            addCriterion("this_percent is not null");
            return (Criteria) this;
        }

        public Criteria andThisPercentEqualTo(Double value) {
            addCriterion("this_percent =", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentNotEqualTo(Double value) {
            addCriterion("this_percent <>", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentGreaterThan(Double value) {
            addCriterion("this_percent >", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentGreaterThanOrEqualTo(Double value) {
            addCriterion("this_percent >=", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentLessThan(Double value) {
            addCriterion("this_percent <", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentLessThanOrEqualTo(Double value) {
            addCriterion("this_percent <=", value, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentIn(List<Double> values) {
            addCriterion("this_percent in", values, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentNotIn(List<Double> values) {
            addCriterion("this_percent not in", values, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentBetween(Double value1, Double value2) {
            addCriterion("this_percent between", value1, value2, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andThisPercentNotBetween(Double value1, Double value2) {
            addCriterion("this_percent not between", value1, value2, "thisPercent");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeIsNull() {
            addCriterion("all_file_size is null");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeIsNotNull() {
            addCriterion("all_file_size is not null");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeEqualTo(Long value) {
            addCriterion("all_file_size =", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeNotEqualTo(Long value) {
            addCriterion("all_file_size <>", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeGreaterThan(Long value) {
            addCriterion("all_file_size >", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("all_file_size >=", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeLessThan(Long value) {
            addCriterion("all_file_size <", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("all_file_size <=", value, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeIn(List<Long> values) {
            addCriterion("all_file_size in", values, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeNotIn(List<Long> values) {
            addCriterion("all_file_size not in", values, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeBetween(Long value1, Long value2) {
            addCriterion("all_file_size between", value1, value2, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andAllFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("all_file_size not between", value1, value2, "allFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeIsNull() {
            addCriterion("this_file_size is null");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeIsNotNull() {
            addCriterion("this_file_size is not null");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeEqualTo(Long value) {
            addCriterion("this_file_size =", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeNotEqualTo(Long value) {
            addCriterion("this_file_size <>", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeGreaterThan(Long value) {
            addCriterion("this_file_size >", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("this_file_size >=", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeLessThan(Long value) {
            addCriterion("this_file_size <", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("this_file_size <=", value, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeIn(List<Long> values) {
            addCriterion("this_file_size in", values, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeNotIn(List<Long> values) {
            addCriterion("this_file_size not in", values, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeBetween(Long value1, Long value2) {
            addCriterion("this_file_size between", value1, value2, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andThisFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("this_file_size not between", value1, value2, "thisFileSize");
            return (Criteria) this;
        }

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andBatchIdLikeInsensitive(String value) {
            addCriterion("upper(batch_id) like", value.toUpperCase(), "batchId");
            return (Criteria) this;
        }

        public Criteria andFilenameLikeInsensitive(String value) {
            addCriterion("upper(filename) like", value.toUpperCase(), "filename");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table import_log
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table import_log
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}