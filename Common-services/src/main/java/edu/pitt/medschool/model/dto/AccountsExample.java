package edu.pitt.medschool.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class AccountsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public AccountsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table upmc..accounts
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

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andRoleIsNull() {
			addCriterion("role is null");
			return (Criteria) this;
		}

		public Criteria andRoleIsNotNull() {
			addCriterion("role is not null");
			return (Criteria) this;
		}

		public Criteria andRoleEqualTo(String value) {
			addCriterion("role =", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotEqualTo(String value) {
			addCriterion("role <>", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThan(String value) {
			addCriterion("role >", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleGreaterThanOrEqualTo(String value) {
			addCriterion("role >=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThan(String value) {
			addCriterion("role <", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLessThanOrEqualTo(String value) {
			addCriterion("role <=", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleLike(String value) {
			addCriterion("role like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotLike(String value) {
			addCriterion("role not like", value, "role");
			return (Criteria) this;
		}

		public Criteria andRoleIn(List<String> values) {
			addCriterion("role in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotIn(List<String> values) {
			addCriterion("role not in", values, "role");
			return (Criteria) this;
		}

		public Criteria andRoleBetween(String value1, String value2) {
			addCriterion("role between", value1, value2, "role");
			return (Criteria) this;
		}

		public Criteria andRoleNotBetween(String value1, String value2) {
			addCriterion("role not between", value1, value2, "role");
			return (Criteria) this;
		}

		public Criteria andFirstNameIsNull() {
			addCriterion("first_name is null");
			return (Criteria) this;
		}

		public Criteria andFirstNameIsNotNull() {
			addCriterion("first_name is not null");
			return (Criteria) this;
		}

		public Criteria andFirstNameEqualTo(String value) {
			addCriterion("first_name =", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameNotEqualTo(String value) {
			addCriterion("first_name <>", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameGreaterThan(String value) {
			addCriterion("first_name >", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameGreaterThanOrEqualTo(String value) {
			addCriterion("first_name >=", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameLessThan(String value) {
			addCriterion("first_name <", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameLessThanOrEqualTo(String value) {
			addCriterion("first_name <=", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameLike(String value) {
			addCriterion("first_name like", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameNotLike(String value) {
			addCriterion("first_name not like", value, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameIn(List<String> values) {
			addCriterion("first_name in", values, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameNotIn(List<String> values) {
			addCriterion("first_name not in", values, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameBetween(String value1, String value2) {
			addCriterion("first_name between", value1, value2, "firstName");
			return (Criteria) this;
		}

		public Criteria andFirstNameNotBetween(String value1, String value2) {
			addCriterion("first_name not between", value1, value2, "firstName");
			return (Criteria) this;
		}

		public Criteria andLastNameIsNull() {
			addCriterion("last_name is null");
			return (Criteria) this;
		}

		public Criteria andLastNameIsNotNull() {
			addCriterion("last_name is not null");
			return (Criteria) this;
		}

		public Criteria andLastNameEqualTo(String value) {
			addCriterion("last_name =", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameNotEqualTo(String value) {
			addCriterion("last_name <>", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameGreaterThan(String value) {
			addCriterion("last_name >", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameGreaterThanOrEqualTo(String value) {
			addCriterion("last_name >=", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameLessThan(String value) {
			addCriterion("last_name <", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameLessThanOrEqualTo(String value) {
			addCriterion("last_name <=", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameLike(String value) {
			addCriterion("last_name like", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameNotLike(String value) {
			addCriterion("last_name not like", value, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameIn(List<String> values) {
			addCriterion("last_name in", values, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameNotIn(List<String> values) {
			addCriterion("last_name not in", values, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameBetween(String value1, String value2) {
			addCriterion("last_name between", value1, value2, "lastName");
			return (Criteria) this;
		}

		public Criteria andLastNameNotBetween(String value1, String value2) {
			addCriterion("last_name not between", value1, value2, "lastName");
			return (Criteria) this;
		}

		public Criteria andEnableIsNull() {
			addCriterion("enable is null");
			return (Criteria) this;
		}

		public Criteria andEnableIsNotNull() {
			addCriterion("enable is not null");
			return (Criteria) this;
		}

		public Criteria andEnableEqualTo(Boolean value) {
			addCriterion("enable =", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotEqualTo(Boolean value) {
			addCriterion("enable <>", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableGreaterThan(Boolean value) {
			addCriterion("enable >", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
			addCriterion("enable >=", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableLessThan(Boolean value) {
			addCriterion("enable <", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableLessThanOrEqualTo(Boolean value) {
			addCriterion("enable <=", value, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableIn(List<Boolean> values) {
			addCriterion("enable in", values, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotIn(List<Boolean> values) {
			addCriterion("enable not in", values, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableBetween(Boolean value1, Boolean value2) {
			addCriterion("enable between", value1, value2, "enable");
			return (Criteria) this;
		}

		public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
			addCriterion("enable not between", value1, value2, "enable");
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

		public Criteria andDatabaseVersionIsNull() {
			addCriterion("database_version is null");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionIsNotNull() {
			addCriterion("database_version is not null");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionEqualTo(Integer value) {
			addCriterion("database_version =", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionNotEqualTo(Integer value) {
			addCriterion("database_version <>", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionGreaterThan(Integer value) {
			addCriterion("database_version >", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("database_version >=", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionLessThan(Integer value) {
			addCriterion("database_version <", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionLessThanOrEqualTo(Integer value) {
			addCriterion("database_version <=", value, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionIn(List<Integer> values) {
			addCriterion("database_version in", values, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionNotIn(List<Integer> values) {
			addCriterion("database_version not in", values, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionBetween(Integer value1, Integer value2) {
			addCriterion("database_version between", value1, value2, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andDatabaseVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("database_version not between", value1, value2, "databaseVersion");
			return (Criteria) this;
		}

		public Criteria andUsernameLikeInsensitive(String value) {
			addCriterion("upper(username) like", value.toUpperCase(), "username");
			return (Criteria) this;
		}

		public Criteria andEmailLikeInsensitive(String value) {
			addCriterion("upper(email) like", value.toUpperCase(), "email");
			return (Criteria) this;
		}

		public Criteria andPasswordLikeInsensitive(String value) {
			addCriterion("upper(password) like", value.toUpperCase(), "password");
			return (Criteria) this;
		}

		public Criteria andRoleLikeInsensitive(String value) {
			addCriterion("upper(role) like", value.toUpperCase(), "role");
			return (Criteria) this;
		}

		public Criteria andFirstNameLikeInsensitive(String value) {
			addCriterion("upper(first_name) like", value.toUpperCase(), "firstName");
			return (Criteria) this;
		}

		public Criteria andLastNameLikeInsensitive(String value) {
			addCriterion("upper(last_name) like", value.toUpperCase(), "lastName");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table upmc..accounts
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
     * This class corresponds to the database table upmc..accounts
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}