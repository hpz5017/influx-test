package edu.pitt.medschool.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AggregationDatabaseExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public AggregationDatabaseExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table aggregation_database
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table aggregation_database
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

		public Criteria andDbNameIsNull() {
			addCriterion("db_name is null");
			return (Criteria) this;
		}

		public Criteria andDbNameIsNotNull() {
			addCriterion("db_name is not null");
			return (Criteria) this;
		}

		public Criteria andDbNameEqualTo(String value) {
			addCriterion("db_name =", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameNotEqualTo(String value) {
			addCriterion("db_name <>", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameGreaterThan(String value) {
			addCriterion("db_name >", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameGreaterThanOrEqualTo(String value) {
			addCriterion("db_name >=", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameLessThan(String value) {
			addCriterion("db_name <", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameLessThanOrEqualTo(String value) {
			addCriterion("db_name <=", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameLike(String value) {
			addCriterion("db_name like", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameNotLike(String value) {
			addCriterion("db_name not like", value, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameIn(List<String> values) {
			addCriterion("db_name in", values, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameNotIn(List<String> values) {
			addCriterion("db_name not in", values, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameBetween(String value1, String value2) {
			addCriterion("db_name between", value1, value2, "dbName");
			return (Criteria) this;
		}

		public Criteria andDbNameNotBetween(String value1, String value2) {
			addCriterion("db_name not between", value1, value2, "dbName");
			return (Criteria) this;
		}

		public Criteria andVersionIsNull() {
			addCriterion("version is null");
			return (Criteria) this;
		}

		public Criteria andVersionIsNotNull() {
			addCriterion("version is not null");
			return (Criteria) this;
		}

		public Criteria andVersionEqualTo(Integer value) {
			addCriterion("version =", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotEqualTo(Integer value) {
			addCriterion("version <>", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThan(Integer value) {
			addCriterion("version >", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("version >=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThan(Integer value) {
			addCriterion("version <", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThanOrEqualTo(Integer value) {
			addCriterion("version <=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionIn(List<Integer> values) {
			addCriterion("version in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotIn(List<Integer> values) {
			addCriterion("version not in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionBetween(Integer value1, Integer value2) {
			addCriterion("version between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("version not between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeIsNull() {
			addCriterion("aggregate_time is null");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeIsNotNull() {
			addCriterion("aggregate_time is not null");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeEqualTo(Integer value) {
			addCriterion("aggregate_time =", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeNotEqualTo(Integer value) {
			addCriterion("aggregate_time <>", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeGreaterThan(Integer value) {
			addCriterion("aggregate_time >", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("aggregate_time >=", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeLessThan(Integer value) {
			addCriterion("aggregate_time <", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeLessThanOrEqualTo(Integer value) {
			addCriterion("aggregate_time <=", value, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeIn(List<Integer> values) {
			addCriterion("aggregate_time in", values, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeNotIn(List<Integer> values) {
			addCriterion("aggregate_time not in", values, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeBetween(Integer value1, Integer value2) {
			addCriterion("aggregate_time between", value1, value2, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andAggregateTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("aggregate_time not between", value1, value2, "aggregateTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(LocalDateTime value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(LocalDateTime value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<LocalDateTime> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andMeanIsNull() {
			addCriterion("mean is null");
			return (Criteria) this;
		}

		public Criteria andMeanIsNotNull() {
			addCriterion("mean is not null");
			return (Criteria) this;
		}

		public Criteria andMeanEqualTo(Byte value) {
			addCriterion("mean =", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanNotEqualTo(Byte value) {
			addCriterion("mean <>", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanGreaterThan(Byte value) {
			addCriterion("mean >", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanGreaterThanOrEqualTo(Byte value) {
			addCriterion("mean >=", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanLessThan(Byte value) {
			addCriterion("mean <", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanLessThanOrEqualTo(Byte value) {
			addCriterion("mean <=", value, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanIn(List<Byte> values) {
			addCriterion("mean in", values, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanNotIn(List<Byte> values) {
			addCriterion("mean not in", values, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanBetween(Byte value1, Byte value2) {
			addCriterion("mean between", value1, value2, "mean");
			return (Criteria) this;
		}

		public Criteria andMeanNotBetween(Byte value1, Byte value2) {
			addCriterion("mean not between", value1, value2, "mean");
			return (Criteria) this;
		}

		public Criteria andMaxIsNull() {
			addCriterion("max is null");
			return (Criteria) this;
		}

		public Criteria andMaxIsNotNull() {
			addCriterion("max is not null");
			return (Criteria) this;
		}

		public Criteria andMaxEqualTo(Byte value) {
			addCriterion("max =", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotEqualTo(Byte value) {
			addCriterion("max <>", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxGreaterThan(Byte value) {
			addCriterion("max >", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxGreaterThanOrEqualTo(Byte value) {
			addCriterion("max >=", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxLessThan(Byte value) {
			addCriterion("max <", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxLessThanOrEqualTo(Byte value) {
			addCriterion("max <=", value, "max");
			return (Criteria) this;
		}

		public Criteria andMaxIn(List<Byte> values) {
			addCriterion("max in", values, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotIn(List<Byte> values) {
			addCriterion("max not in", values, "max");
			return (Criteria) this;
		}

		public Criteria andMaxBetween(Byte value1, Byte value2) {
			addCriterion("max between", value1, value2, "max");
			return (Criteria) this;
		}

		public Criteria andMaxNotBetween(Byte value1, Byte value2) {
			addCriterion("max not between", value1, value2, "max");
			return (Criteria) this;
		}

		public Criteria andMinIsNull() {
			addCriterion("min is null");
			return (Criteria) this;
		}

		public Criteria andMinIsNotNull() {
			addCriterion("min is not null");
			return (Criteria) this;
		}

		public Criteria andMinEqualTo(Byte value) {
			addCriterion("min =", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinNotEqualTo(Byte value) {
			addCriterion("min <>", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinGreaterThan(Byte value) {
			addCriterion("min >", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinGreaterThanOrEqualTo(Byte value) {
			addCriterion("min >=", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinLessThan(Byte value) {
			addCriterion("min <", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinLessThanOrEqualTo(Byte value) {
			addCriterion("min <=", value, "min");
			return (Criteria) this;
		}

		public Criteria andMinIn(List<Byte> values) {
			addCriterion("min in", values, "min");
			return (Criteria) this;
		}

		public Criteria andMinNotIn(List<Byte> values) {
			addCriterion("min not in", values, "min");
			return (Criteria) this;
		}

		public Criteria andMinBetween(Byte value1, Byte value2) {
			addCriterion("min between", value1, value2, "min");
			return (Criteria) this;
		}

		public Criteria andMinNotBetween(Byte value1, Byte value2) {
			addCriterion("min not between", value1, value2, "min");
			return (Criteria) this;
		}

		public Criteria andSdIsNull() {
			addCriterion("sd is null");
			return (Criteria) this;
		}

		public Criteria andSdIsNotNull() {
			addCriterion("sd is not null");
			return (Criteria) this;
		}

		public Criteria andSdEqualTo(Byte value) {
			addCriterion("sd =", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdNotEqualTo(Byte value) {
			addCriterion("sd <>", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdGreaterThan(Byte value) {
			addCriterion("sd >", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdGreaterThanOrEqualTo(Byte value) {
			addCriterion("sd >=", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdLessThan(Byte value) {
			addCriterion("sd <", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdLessThanOrEqualTo(Byte value) {
			addCriterion("sd <=", value, "sd");
			return (Criteria) this;
		}

		public Criteria andSdIn(List<Byte> values) {
			addCriterion("sd in", values, "sd");
			return (Criteria) this;
		}

		public Criteria andSdNotIn(List<Byte> values) {
			addCriterion("sd not in", values, "sd");
			return (Criteria) this;
		}

		public Criteria andSdBetween(Byte value1, Byte value2) {
			addCriterion("sd between", value1, value2, "sd");
			return (Criteria) this;
		}

		public Criteria andSdNotBetween(Byte value1, Byte value2) {
			addCriterion("sd not between", value1, value2, "sd");
			return (Criteria) this;
		}

		public Criteria andMedianIsNull() {
			addCriterion("median is null");
			return (Criteria) this;
		}

		public Criteria andMedianIsNotNull() {
			addCriterion("median is not null");
			return (Criteria) this;
		}

		public Criteria andMedianEqualTo(Byte value) {
			addCriterion("median =", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianNotEqualTo(Byte value) {
			addCriterion("median <>", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianGreaterThan(Byte value) {
			addCriterion("median >", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianGreaterThanOrEqualTo(Byte value) {
			addCriterion("median >=", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianLessThan(Byte value) {
			addCriterion("median <", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianLessThanOrEqualTo(Byte value) {
			addCriterion("median <=", value, "median");
			return (Criteria) this;
		}

		public Criteria andMedianIn(List<Byte> values) {
			addCriterion("median in", values, "median");
			return (Criteria) this;
		}

		public Criteria andMedianNotIn(List<Byte> values) {
			addCriterion("median not in", values, "median");
			return (Criteria) this;
		}

		public Criteria andMedianBetween(Byte value1, Byte value2) {
			addCriterion("median between", value1, value2, "median");
			return (Criteria) this;
		}

		public Criteria andMedianNotBetween(Byte value1, Byte value2) {
			addCriterion("median not between", value1, value2, "median");
			return (Criteria) this;
		}

		public Criteria andQ1IsNull() {
			addCriterion("q1 is null");
			return (Criteria) this;
		}

		public Criteria andQ1IsNotNull() {
			addCriterion("q1 is not null");
			return (Criteria) this;
		}

		public Criteria andQ1EqualTo(Byte value) {
			addCriterion("q1 =", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1NotEqualTo(Byte value) {
			addCriterion("q1 <>", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1GreaterThan(Byte value) {
			addCriterion("q1 >", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1GreaterThanOrEqualTo(Byte value) {
			addCriterion("q1 >=", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1LessThan(Byte value) {
			addCriterion("q1 <", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1LessThanOrEqualTo(Byte value) {
			addCriterion("q1 <=", value, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1In(List<Byte> values) {
			addCriterion("q1 in", values, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1NotIn(List<Byte> values) {
			addCriterion("q1 not in", values, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1Between(Byte value1, Byte value2) {
			addCriterion("q1 between", value1, value2, "q1");
			return (Criteria) this;
		}

		public Criteria andQ1NotBetween(Byte value1, Byte value2) {
			addCriterion("q1 not between", value1, value2, "q1");
			return (Criteria) this;
		}

		public Criteria andQ3IsNull() {
			addCriterion("q3 is null");
			return (Criteria) this;
		}

		public Criteria andQ3IsNotNull() {
			addCriterion("q3 is not null");
			return (Criteria) this;
		}

		public Criteria andQ3EqualTo(Byte value) {
			addCriterion("q3 =", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3NotEqualTo(Byte value) {
			addCriterion("q3 <>", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3GreaterThan(Byte value) {
			addCriterion("q3 >", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3GreaterThanOrEqualTo(Byte value) {
			addCriterion("q3 >=", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3LessThan(Byte value) {
			addCriterion("q3 <", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3LessThanOrEqualTo(Byte value) {
			addCriterion("q3 <=", value, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3In(List<Byte> values) {
			addCriterion("q3 in", values, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3NotIn(List<Byte> values) {
			addCriterion("q3 not in", values, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3Between(Byte value1, Byte value2) {
			addCriterion("q3 between", value1, value2, "q3");
			return (Criteria) this;
		}

		public Criteria andQ3NotBetween(Byte value1, Byte value2) {
			addCriterion("q3 not between", value1, value2, "q3");
			return (Criteria) this;
		}

		public Criteria andSumIsNull() {
			addCriterion("sum is null");
			return (Criteria) this;
		}

		public Criteria andSumIsNotNull() {
			addCriterion("sum is not null");
			return (Criteria) this;
		}

		public Criteria andSumEqualTo(Byte value) {
			addCriterion("sum =", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumNotEqualTo(Byte value) {
			addCriterion("sum <>", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumGreaterThan(Byte value) {
			addCriterion("sum >", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumGreaterThanOrEqualTo(Byte value) {
			addCriterion("sum >=", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumLessThan(Byte value) {
			addCriterion("sum <", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumLessThanOrEqualTo(Byte value) {
			addCriterion("sum <=", value, "sum");
			return (Criteria) this;
		}

		public Criteria andSumIn(List<Byte> values) {
			addCriterion("sum in", values, "sum");
			return (Criteria) this;
		}

		public Criteria andSumNotIn(List<Byte> values) {
			addCriterion("sum not in", values, "sum");
			return (Criteria) this;
		}

		public Criteria andSumBetween(Byte value1, Byte value2) {
			addCriterion("sum between", value1, value2, "sum");
			return (Criteria) this;
		}

		public Criteria andSumNotBetween(Byte value1, Byte value2) {
			addCriterion("sum not between", value1, value2, "sum");
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

		public Criteria andTotalIsNull() {
			addCriterion("total is null");
			return (Criteria) this;
		}

		public Criteria andTotalIsNotNull() {
			addCriterion("total is not null");
			return (Criteria) this;
		}

		public Criteria andTotalEqualTo(Integer value) {
			addCriterion("total =", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotEqualTo(Integer value) {
			addCriterion("total <>", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThan(Integer value) {
			addCriterion("total >", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
			addCriterion("total >=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThan(Integer value) {
			addCriterion("total <", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThanOrEqualTo(Integer value) {
			addCriterion("total <=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalIn(List<Integer> values) {
			addCriterion("total in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotIn(List<Integer> values) {
			addCriterion("total not in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalBetween(Integer value1, Integer value2) {
			addCriterion("total between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotBetween(Integer value1, Integer value2) {
			addCriterion("total not between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andFinishedIsNull() {
			addCriterion("finished is null");
			return (Criteria) this;
		}

		public Criteria andFinishedIsNotNull() {
			addCriterion("finished is not null");
			return (Criteria) this;
		}

		public Criteria andFinishedEqualTo(Integer value) {
			addCriterion("finished =", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedNotEqualTo(Integer value) {
			addCriterion("finished <>", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedGreaterThan(Integer value) {
			addCriterion("finished >", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedGreaterThanOrEqualTo(Integer value) {
			addCriterion("finished >=", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedLessThan(Integer value) {
			addCriterion("finished <", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedLessThanOrEqualTo(Integer value) {
			addCriterion("finished <=", value, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedIn(List<Integer> values) {
			addCriterion("finished in", values, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedNotIn(List<Integer> values) {
			addCriterion("finished not in", values, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedBetween(Integer value1, Integer value2) {
			addCriterion("finished between", value1, value2, "finished");
			return (Criteria) this;
		}

		public Criteria andFinishedNotBetween(Integer value1, Integer value2) {
			addCriterion("finished not between", value1, value2, "finished");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateIsNull() {
			addCriterion("auto_update is null");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateIsNotNull() {
			addCriterion("auto_update is not null");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateEqualTo(Byte value) {
			addCriterion("auto_update =", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateNotEqualTo(Byte value) {
			addCriterion("auto_update <>", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateGreaterThan(Byte value) {
			addCriterion("auto_update >", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateGreaterThanOrEqualTo(Byte value) {
			addCriterion("auto_update >=", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateLessThan(Byte value) {
			addCriterion("auto_update <", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateLessThanOrEqualTo(Byte value) {
			addCriterion("auto_update <=", value, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateIn(List<Byte> values) {
			addCriterion("auto_update in", values, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateNotIn(List<Byte> values) {
			addCriterion("auto_update not in", values, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateBetween(Byte value1, Byte value2) {
			addCriterion("auto_update between", value1, value2, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andAutoUpdateNotBetween(Byte value1, Byte value2) {
			addCriterion("auto_update not between", value1, value2, "autoUpdate");
			return (Criteria) this;
		}

		public Criteria andArtypeIsNull() {
			addCriterion("arType is null");
			return (Criteria) this;
		}

		public Criteria andArtypeIsNotNull() {
			addCriterion("arType is not null");
			return (Criteria) this;
		}

		public Criteria andArtypeEqualTo(Byte value) {
			addCriterion("arType =", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeNotEqualTo(Byte value) {
			addCriterion("arType <>", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeGreaterThan(Byte value) {
			addCriterion("arType >", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("arType >=", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeLessThan(Byte value) {
			addCriterion("arType <", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeLessThanOrEqualTo(Byte value) {
			addCriterion("arType <=", value, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeIn(List<Byte> values) {
			addCriterion("arType in", values, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeNotIn(List<Byte> values) {
			addCriterion("arType not in", values, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeBetween(Byte value1, Byte value2) {
			addCriterion("arType between", value1, value2, "artype");
			return (Criteria) this;
		}

		public Criteria andArtypeNotBetween(Byte value1, Byte value2) {
			addCriterion("arType not between", value1, value2, "artype");
			return (Criteria) this;
		}

		public Criteria andDbNameLikeInsensitive(String value) {
			addCriterion("upper(db_name) like", value.toUpperCase(), "dbName");
			return (Criteria) this;
		}

		public Criteria andStatusLikeInsensitive(String value) {
			addCriterion("upper(status) like", value.toUpperCase(), "status");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table aggregation_database
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aggregation_database
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}