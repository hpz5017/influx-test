package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.DownsampleGroup;
import edu.pitt.medschool.model.dto.DownsampleGroupExample.Criteria;
import edu.pitt.medschool.model.dto.DownsampleGroupExample.Criterion;
import edu.pitt.medschool.model.dto.DownsampleGroupExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class DownsampleGroupSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String countByExample(DownsampleGroupExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("downsample_group");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String deleteByExample(DownsampleGroupExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("downsample_group");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String insertSelective(DownsampleGroup record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("downsample_group");
		if (record.getQueryId() != null) {
			sql.VALUES("query_id", "#{queryId,jdbcType=INTEGER}");
		}
		if (record.getLabel() != null) {
			sql.VALUES("label", "#{label,jdbcType=VARCHAR}");
		}
		if (record.getDownsample() != null) {
			sql.VALUES("downsample", "#{downsample,jdbcType=VARCHAR}");
		}
		if (record.getAggregation() != null) {
			sql.VALUES("aggregation", "#{aggregation,jdbcType=VARCHAR}");
		}
		if (record.getCreateTime() != null) {
			sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUpdateTime() != null) {
			sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDeleted() != null) {
			sql.VALUES("deleted", "#{deleted,jdbcType=BIT}");
		}
		if (record.getColumns() != null) {
			sql.VALUES("columns", "#{columns,jdbcType=LONGVARCHAR}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String selectByExampleWithBLOBs(DownsampleGroupExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("query_id");
		sql.SELECT("label");
		sql.SELECT("downsample");
		sql.SELECT("aggregation");
		sql.SELECT("create_time");
		sql.SELECT("update_time");
		sql.SELECT("deleted");
		sql.SELECT("columns");
		sql.FROM("downsample_group");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String selectByExample(DownsampleGroupExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("query_id");
		sql.SELECT("label");
		sql.SELECT("downsample");
		sql.SELECT("aggregation");
		sql.SELECT("create_time");
		sql.SELECT("update_time");
		sql.SELECT("deleted");
		sql.FROM("downsample_group");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		DownsampleGroup record = (DownsampleGroup) parameter.get("record");
		DownsampleGroupExample example = (DownsampleGroupExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("downsample_group");
		if (record.getId() != null) {
			sql.SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getQueryId() != null) {
			sql.SET("query_id = #{record.queryId,jdbcType=INTEGER}");
		}
		if (record.getLabel() != null) {
			sql.SET("label = #{record.label,jdbcType=VARCHAR}");
		}
		if (record.getDownsample() != null) {
			sql.SET("downsample = #{record.downsample,jdbcType=VARCHAR}");
		}
		if (record.getAggregation() != null) {
			sql.SET("aggregation = #{record.aggregation,jdbcType=VARCHAR}");
		}
		if (record.getCreateTime() != null) {
			sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUpdateTime() != null) {
			sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDeleted() != null) {
			sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
		}
		if (record.getColumns() != null) {
			sql.SET("columns = #{record.columns,jdbcType=LONGVARCHAR}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("downsample_group");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("query_id = #{record.queryId,jdbcType=INTEGER}");
		sql.SET("label = #{record.label,jdbcType=VARCHAR}");
		sql.SET("downsample = #{record.downsample,jdbcType=VARCHAR}");
		sql.SET("aggregation = #{record.aggregation,jdbcType=VARCHAR}");
		sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
		sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
		sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
		sql.SET("columns = #{record.columns,jdbcType=LONGVARCHAR}");
		DownsampleGroupExample example = (DownsampleGroupExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("downsample_group");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("query_id = #{record.queryId,jdbcType=INTEGER}");
		sql.SET("label = #{record.label,jdbcType=VARCHAR}");
		sql.SET("downsample = #{record.downsample,jdbcType=VARCHAR}");
		sql.SET("aggregation = #{record.aggregation,jdbcType=VARCHAR}");
		sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
		sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
		sql.SET("deleted = #{record.deleted,jdbcType=BIT}");
		DownsampleGroupExample example = (DownsampleGroupExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	public String updateByPrimaryKeySelective(DownsampleGroup record) {
		SQL sql = new SQL();
		sql.UPDATE("downsample_group");
		if (record.getQueryId() != null) {
			sql.SET("query_id = #{queryId,jdbcType=INTEGER}");
		}
		if (record.getLabel() != null) {
			sql.SET("label = #{label,jdbcType=VARCHAR}");
		}
		if (record.getDownsample() != null) {
			sql.SET("downsample = #{downsample,jdbcType=VARCHAR}");
		}
		if (record.getAggregation() != null) {
			sql.SET("aggregation = #{aggregation,jdbcType=VARCHAR}");
		}
		if (record.getCreateTime() != null) {
			sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUpdateTime() != null) {
			sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
		}
		if (record.getDeleted() != null) {
			sql.SET("deleted = #{deleted,jdbcType=BIT}");
		}
		if (record.getColumns() != null) {
			sql.SET("columns = #{columns,jdbcType=LONGVARCHAR}");
		}
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	protected void applyWhere(SQL sql, DownsampleGroupExample example, boolean includeExamplePhrase) {
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