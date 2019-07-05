package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.Accounts;
import edu.pitt.medschool.model.dto.AccountsExample.Criteria;
import edu.pitt.medschool.model.dto.AccountsExample.Criterion;
import edu.pitt.medschool.model.dto.AccountsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class AccountsSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String countByExample(AccountsExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("accounts");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String deleteByExample(AccountsExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("accounts");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String insertSelective(Accounts record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("accounts");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getUsername() != null) {
			sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.VALUES("role", "#{role,jdbcType=VARCHAR}");
		}
		if (record.getFirstName() != null) {
			sql.VALUES("first_name", "#{firstName,jdbcType=VARCHAR}");
		}
		if (record.getLastName() != null) {
			sql.VALUES("last_name", "#{lastName,jdbcType=VARCHAR}");
		}
		if (record.getEnable() != null) {
			sql.VALUES("enable", "#{enable,jdbcType=BIT}");
		}
		if (record.getLastUpdate() != null) {
			sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getCreateTime() != null) {
			sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDatabaseVersion() != null) {
			sql.VALUES("database_version", "#{databaseVersion,jdbcType=INTEGER}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String selectByExample(AccountsExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("username");
		sql.SELECT("email");
		sql.SELECT("password");
		sql.SELECT("role");
		sql.SELECT("first_name");
		sql.SELECT("last_name");
		sql.SELECT("enable");
		sql.SELECT("last_update");
		sql.SELECT("create_time");
		sql.SELECT("database_version");
		sql.FROM("accounts");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Accounts record = (Accounts) parameter.get("record");
		AccountsExample example = (AccountsExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("accounts");
		if (record.getId() != null) {
			sql.SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getUsername() != null) {
			sql.SET("username = #{record.username,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.SET("email = #{record.email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.SET("password = #{record.password,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.SET("role = #{record.role,jdbcType=VARCHAR}");
		}
		if (record.getFirstName() != null) {
			sql.SET("first_name = #{record.firstName,jdbcType=VARCHAR}");
		}
		if (record.getLastName() != null) {
			sql.SET("last_name = #{record.lastName,jdbcType=VARCHAR}");
		}
		if (record.getEnable() != null) {
			sql.SET("enable = #{record.enable,jdbcType=BIT}");
		}
		if (record.getLastUpdate() != null) {
			sql.SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getCreateTime() != null) {
			sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDatabaseVersion() != null) {
			sql.SET("database_version = #{record.databaseVersion,jdbcType=INTEGER}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("accounts");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("username = #{record.username,jdbcType=VARCHAR}");
		sql.SET("email = #{record.email,jdbcType=VARCHAR}");
		sql.SET("password = #{record.password,jdbcType=VARCHAR}");
		sql.SET("role = #{record.role,jdbcType=VARCHAR}");
		sql.SET("first_name = #{record.firstName,jdbcType=VARCHAR}");
		sql.SET("last_name = #{record.lastName,jdbcType=VARCHAR}");
		sql.SET("enable = #{record.enable,jdbcType=BIT}");
		sql.SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
		sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
		sql.SET("database_version = #{record.databaseVersion,jdbcType=INTEGER}");
		AccountsExample example = (AccountsExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	public String updateByPrimaryKeySelective(Accounts record) {
		SQL sql = new SQL();
		sql.UPDATE("accounts");
		if (record.getUsername() != null) {
			sql.SET("username = #{username,jdbcType=VARCHAR}");
		}
		if (record.getEmail() != null) {
			sql.SET("email = #{email,jdbcType=VARCHAR}");
		}
		if (record.getPassword() != null) {
			sql.SET("password = #{password,jdbcType=VARCHAR}");
		}
		if (record.getRole() != null) {
			sql.SET("role = #{role,jdbcType=VARCHAR}");
		}
		if (record.getFirstName() != null) {
			sql.SET("first_name = #{firstName,jdbcType=VARCHAR}");
		}
		if (record.getLastName() != null) {
			sql.SET("last_name = #{lastName,jdbcType=VARCHAR}");
		}
		if (record.getEnable() != null) {
			sql.SET("enable = #{enable,jdbcType=BIT}");
		}
		if (record.getLastUpdate() != null) {
			sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getCreateTime() != null) {
			sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDatabaseVersion() != null) {
			sql.SET("database_version = #{databaseVersion,jdbcType=INTEGER}");
		}
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..accounts
	 * @mbg.generated
	 */
	protected void applyWhere(SQL sql, AccountsExample example, boolean includeExamplePhrase) {
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
							sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
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