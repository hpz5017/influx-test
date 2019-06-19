package edu.pitt.medschool.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CsvFileNewExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public CsvFileNewExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..csv_file_new
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table upmc..csv_file_new
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

		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return (Criteria) this;
		}

		public Criteria andPidIsNotNull() {
			addCriterion("pid is not null");
			return (Criteria) this;
		}

		public Criteria andPidEqualTo(String value) {
			addCriterion("pid =", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotEqualTo(String value) {
			addCriterion("pid <>", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThan(String value) {
			addCriterion("pid >", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThanOrEqualTo(String value) {
			addCriterion("pid >=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThan(String value) {
			addCriterion("pid <", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThanOrEqualTo(String value) {
			addCriterion("pid <=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLike(String value) {
			addCriterion("pid like", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotLike(String value) {
			addCriterion("pid not like", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidIn(List<String> values) {
			addCriterion("pid in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotIn(List<String> values) {
			addCriterion("pid not in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidBetween(String value1, String value2) {
			addCriterion("pid between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotBetween(String value1, String value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("start_time is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(LocalDateTime value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(LocalDateTime value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(LocalDateTime value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(LocalDateTime value) {
			addCriterion("start_time >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(LocalDateTime value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(LocalDateTime value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<LocalDateTime> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<LocalDateTime> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(LocalDateTime value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(LocalDateTime value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(LocalDateTime value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(LocalDateTime value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(LocalDateTime value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(LocalDateTime value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<LocalDateTime> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<LocalDateTime> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeIsNull() {
			addCriterion("header_time is null");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeIsNotNull() {
			addCriterion("header_time is not null");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeEqualTo(LocalDateTime value) {
			addCriterion("header_time =", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeNotEqualTo(LocalDateTime value) {
			addCriterion("header_time <>", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeGreaterThan(LocalDateTime value) {
			addCriterion("header_time >", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeGreaterThanOrEqualTo(LocalDateTime value) {
			addCriterion("header_time >=", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeLessThan(LocalDateTime value) {
			addCriterion("header_time <", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeLessThanOrEqualTo(LocalDateTime value) {
			addCriterion("header_time <=", value, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeIn(List<LocalDateTime> values) {
			addCriterion("header_time in", values, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeNotIn(List<LocalDateTime> values) {
			addCriterion("header_time not in", values, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("header_time between", value1, value2, "headerTime");
			return (Criteria) this;
		}

		public Criteria andHeaderTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("header_time not between", value1, value2, "headerTime");
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

		public Criteria andLengthIsNull() {
			addCriterion("length is null");
			return (Criteria) this;
		}

		public Criteria andLengthIsNotNull() {
			addCriterion("length is not null");
			return (Criteria) this;
		}

		public Criteria andLengthEqualTo(Integer value) {
			addCriterion("length =", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotEqualTo(Integer value) {
			addCriterion("length <>", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthGreaterThan(Integer value) {
			addCriterion("length >", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthGreaterThanOrEqualTo(Integer value) {
			addCriterion("length >=", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthLessThan(Integer value) {
			addCriterion("length <", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthLessThanOrEqualTo(Integer value) {
			addCriterion("length <=", value, "length");
			return (Criteria) this;
		}

		public Criteria andLengthIn(List<Integer> values) {
			addCriterion("length in", values, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotIn(List<Integer> values) {
			addCriterion("length not in", values, "length");
			return (Criteria) this;
		}

		public Criteria andLengthBetween(Integer value1, Integer value2) {
			addCriterion("length between", value1, value2, "length");
			return (Criteria) this;
		}

		public Criteria andLengthNotBetween(Integer value1, Integer value2) {
			addCriterion("length not between", value1, value2, "length");
			return (Criteria) this;
		}

		public Criteria andDensityIsNull() {
			addCriterion("density is null");
			return (Criteria) this;
		}

		public Criteria andDensityIsNotNull() {
			addCriterion("density is not null");
			return (Criteria) this;
		}

		public Criteria andDensityEqualTo(Double value) {
			addCriterion("density =", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotEqualTo(Double value) {
			addCriterion("density <>", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityGreaterThan(Double value) {
			addCriterion("density >", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityGreaterThanOrEqualTo(Double value) {
			addCriterion("density >=", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityLessThan(Double value) {
			addCriterion("density <", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityLessThanOrEqualTo(Double value) {
			addCriterion("density <=", value, "density");
			return (Criteria) this;
		}

		public Criteria andDensityIn(List<Double> values) {
			addCriterion("density in", values, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotIn(List<Double> values) {
			addCriterion("density not in", values, "density");
			return (Criteria) this;
		}

		public Criteria andDensityBetween(Double value1, Double value2) {
			addCriterion("density between", value1, value2, "density");
			return (Criteria) this;
		}

		public Criteria andDensityNotBetween(Double value1, Double value2) {
			addCriterion("density not between", value1, value2, "density");
			return (Criteria) this;
		}

		public Criteria andCommentIsNull() {
			addCriterion("comment is null");
			return (Criteria) this;
		}

		public Criteria andCommentIsNotNull() {
			addCriterion("comment is not null");
			return (Criteria) this;
		}

		public Criteria andCommentEqualTo(String value) {
			addCriterion("comment =", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotEqualTo(String value) {
			addCriterion("comment <>", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentGreaterThan(String value) {
			addCriterion("comment >", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentGreaterThanOrEqualTo(String value) {
			addCriterion("comment >=", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLessThan(String value) {
			addCriterion("comment <", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLessThanOrEqualTo(String value) {
			addCriterion("comment <=", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLike(String value) {
			addCriterion("comment like", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotLike(String value) {
			addCriterion("comment not like", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentIn(List<String> values) {
			addCriterion("comment in", values, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotIn(List<String> values) {
			addCriterion("comment not in", values, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentBetween(String value1, String value2) {
			addCriterion("comment between", value1, value2, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotBetween(String value1, String value2) {
			addCriterion("comment not between", value1, value2, "comment");
			return (Criteria) this;
		}

		public Criteria andLastUpdateIsNull() {
			addCriterion("last_update is null");
			return (Criteria) this;
		}

		public Criteria andLastUpdateIsNotNull() {
			addCriterion("last_update is not null");
			return (Criteria) this;
		}

		public Criteria andLastUpdateEqualTo(LocalDateTime value) {
			addCriterion("last_update =", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateNotEqualTo(LocalDateTime value) {
			addCriterion("last_update <>", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateGreaterThan(LocalDateTime value) {
			addCriterion("last_update >", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateGreaterThanOrEqualTo(LocalDateTime value) {
			addCriterion("last_update >=", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateLessThan(LocalDateTime value) {
			addCriterion("last_update <", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateLessThanOrEqualTo(LocalDateTime value) {
			addCriterion("last_update <=", value, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateIn(List<LocalDateTime> values) {
			addCriterion("last_update in", values, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateNotIn(List<LocalDateTime> values) {
			addCriterion("last_update not in", values, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("last_update between", value1, value2, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andLastUpdateNotBetween(LocalDateTime value1, LocalDateTime value2) {
			addCriterion("last_update not between", value1, value2, "lastUpdate");
			return (Criteria) this;
		}

		public Criteria andMachineIsNull() {
			addCriterion("machine is null");
			return (Criteria) this;
		}

		public Criteria andMachineIsNotNull() {
			addCriterion("machine is not null");
			return (Criteria) this;
		}

		public Criteria andMachineEqualTo(String value) {
			addCriterion("machine =", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineNotEqualTo(String value) {
			addCriterion("machine <>", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineGreaterThan(String value) {
			addCriterion("machine >", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineGreaterThanOrEqualTo(String value) {
			addCriterion("machine >=", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineLessThan(String value) {
			addCriterion("machine <", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineLessThanOrEqualTo(String value) {
			addCriterion("machine <=", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineLike(String value) {
			addCriterion("machine like", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineNotLike(String value) {
			addCriterion("machine not like", value, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineIn(List<String> values) {
			addCriterion("machine in", values, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineNotIn(List<String> values) {
			addCriterion("machine not in", values, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineBetween(String value1, String value2) {
			addCriterion("machine between", value1, value2, "machine");
			return (Criteria) this;
		}

		public Criteria andMachineNotBetween(String value1, String value2) {
			addCriterion("machine not between", value1, value2, "machine");
			return (Criteria) this;
		}

		public Criteria andArIsNull() {
			addCriterion("ar is null");
			return (Criteria) this;
		}

		public Criteria andArIsNotNull() {
			addCriterion("ar is not null");
			return (Criteria) this;
		}

		public Criteria andArEqualTo(Boolean value) {
			addCriterion("ar =", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArNotEqualTo(Boolean value) {
			addCriterion("ar <>", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArGreaterThan(Boolean value) {
			addCriterion("ar >", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ar >=", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArLessThan(Boolean value) {
			addCriterion("ar <", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArLessThanOrEqualTo(Boolean value) {
			addCriterion("ar <=", value, "ar");
			return (Criteria) this;
		}

		public Criteria andArIn(List<Boolean> values) {
			addCriterion("ar in", values, "ar");
			return (Criteria) this;
		}

		public Criteria andArNotIn(List<Boolean> values) {
			addCriterion("ar not in", values, "ar");
			return (Criteria) this;
		}

		public Criteria andArBetween(Boolean value1, Boolean value2) {
			addCriterion("ar between", value1, value2, "ar");
			return (Criteria) this;
		}

		public Criteria andArNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ar not between", value1, value2, "ar");
			return (Criteria) this;
		}

		public Criteria andPathIsNull() {
			addCriterion("path is null");
			return (Criteria) this;
		}

		public Criteria andPathIsNotNull() {
			addCriterion("path is not null");
			return (Criteria) this;
		}

		public Criteria andPathEqualTo(String value) {
			addCriterion("path =", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotEqualTo(String value) {
			addCriterion("path <>", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThan(String value) {
			addCriterion("path >", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathGreaterThanOrEqualTo(String value) {
			addCriterion("path >=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThan(String value) {
			addCriterion("path <", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLessThanOrEqualTo(String value) {
			addCriterion("path <=", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathLike(String value) {
			addCriterion("path like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotLike(String value) {
			addCriterion("path not like", value, "path");
			return (Criteria) this;
		}

		public Criteria andPathIn(List<String> values) {
			addCriterion("path in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotIn(List<String> values) {
			addCriterion("path not in", values, "path");
			return (Criteria) this;
		}

		public Criteria andPathBetween(String value1, String value2) {
			addCriterion("path between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andPathNotBetween(String value1, String value2) {
			addCriterion("path not between", value1, value2, "path");
			return (Criteria) this;
		}

		public Criteria andSizeIsNull() {
			addCriterion("size is null");
			return (Criteria) this;
		}

		public Criteria andSizeIsNotNull() {
			addCriterion("size is not null");
			return (Criteria) this;
		}

		public Criteria andSizeEqualTo(Long value) {
			addCriterion("size =", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotEqualTo(Long value) {
			addCriterion("size <>", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThan(Long value) {
			addCriterion("size >", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeGreaterThanOrEqualTo(Long value) {
			addCriterion("size >=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThan(Long value) {
			addCriterion("size <", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeLessThanOrEqualTo(Long value) {
			addCriterion("size <=", value, "size");
			return (Criteria) this;
		}

		public Criteria andSizeIn(List<Long> values) {
			addCriterion("size in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotIn(List<Long> values) {
			addCriterion("size not in", values, "size");
			return (Criteria) this;
		}

		public Criteria andSizeBetween(Long value1, Long value2) {
			addCriterion("size between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andSizeNotBetween(Long value1, Long value2) {
			addCriterion("size not between", value1, value2, "size");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedIsNull() {
			addCriterion("conflict_resolved is null");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedIsNotNull() {
			addCriterion("conflict_resolved is not null");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedEqualTo(Boolean value) {
			addCriterion("conflict_resolved =", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedNotEqualTo(Boolean value) {
			addCriterion("conflict_resolved <>", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedGreaterThan(Boolean value) {
			addCriterion("conflict_resolved >", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("conflict_resolved >=", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedLessThan(Boolean value) {
			addCriterion("conflict_resolved <", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedLessThanOrEqualTo(Boolean value) {
			addCriterion("conflict_resolved <=", value, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedIn(List<Boolean> values) {
			addCriterion("conflict_resolved in", values, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedNotIn(List<Boolean> values) {
			addCriterion("conflict_resolved not in", values, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedBetween(Boolean value1, Boolean value2) {
			addCriterion("conflict_resolved between", value1, value2, "conflictResolved");
			return (Criteria) this;
		}

		public Criteria andConflictResolvedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("conflict_resolved not between", value1, value2, "conflictResolved");
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

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andWidthIsNull() {
			addCriterion("width is null");
			return (Criteria) this;
		}

		public Criteria andWidthIsNotNull() {
			addCriterion("width is not null");
			return (Criteria) this;
		}

		public Criteria andWidthEqualTo(Integer value) {
			addCriterion("width =", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotEqualTo(Integer value) {
			addCriterion("width <>", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThan(Integer value) {
			addCriterion("width >", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
			addCriterion("width >=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThan(Integer value) {
			addCriterion("width <", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThanOrEqualTo(Integer value) {
			addCriterion("width <=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthIn(List<Integer> values) {
			addCriterion("width in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotIn(List<Integer> values) {
			addCriterion("width not in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthBetween(Integer value1, Integer value2) {
			addCriterion("width between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotBetween(Integer value1, Integer value2) {
			addCriterion("width not between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andPidLikeInsensitive(String value) {
			addCriterion("upper(pid) like", value.toUpperCase(), "pid");
			return (Criteria) this;
		}

		public Criteria andUuidLikeInsensitive(String value) {
			addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
			return (Criteria) this;
		}

		public Criteria andFilenameLikeInsensitive(String value) {
			addCriterion("upper(filename) like", value.toUpperCase(), "filename");
			return (Criteria) this;
		}

		public Criteria andCommentLikeInsensitive(String value) {
			addCriterion("upper(comment) like", value.toUpperCase(), "comment");
			return (Criteria) this;
		}

		public Criteria andMachineLikeInsensitive(String value) {
			addCriterion("upper(machine) like", value.toUpperCase(), "machine");
			return (Criteria) this;
		}

		public Criteria andPathLikeInsensitive(String value) {
			addCriterion("upper(path) like", value.toUpperCase(), "path");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table upmc..csv_file_new
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
     * This class corresponds to the database table upmc..csv_file_new
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}