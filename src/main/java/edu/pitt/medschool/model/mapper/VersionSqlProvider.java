package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.Version;
import edu.pitt.medschool.model.dto.VersionExample.Criteria;
import edu.pitt.medschool.model.dto.VersionExample.Criterion;
import edu.pitt.medschool.model.dto.VersionExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class VersionSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String countByExample(VersionExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("version");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String deleteByExample(VersionExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("version");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String insertSelective(Version record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("version");
		if (record.getVersionId() != null) {
			sql.VALUES("version_id", "#{versionId,jdbcType=INTEGER}");
		}
		if (record.getCreateDate() != null) {
			sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
		}
		if (record.getPatientNum() != null) {
			sql.VALUES("patient_num", "#{patientNum,jdbcType=INTEGER}");
		}
		if (record.getCsvFileNum() != null) {
			sql.VALUES("csv_file_num", "#{csvFileNum,jdbcType=INTEGER}");
		}
		if (record.getMedicationNum() != null) {
			sql.VALUES("medication_num", "#{medicationNum,jdbcType=INTEGER}");
		}
		if (record.getPatientIncrease() != null) {
			sql.VALUES("patient_increase", "#{patientIncrease,jdbcType=INTEGER}");
		}
		if (record.getMedicationIncrease() != null) {
			sql.VALUES("medication_increase", "#{medicationIncrease,jdbcType=INTEGER}");
		}
		if (record.getCsvIncrease() != null) {
			sql.VALUES("csv_increase", "#{csvIncrease,jdbcType=INTEGER}");
		}
		if (record.getCsvDelete() != null) {
			sql.VALUES("csv_delete", "#{csvDelete,jdbcType=INTEGER}");
		}
		if (record.getComment() != null) {
			sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String selectByExample(VersionExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("version_id");
		} else {
			sql.SELECT("version_id");
		}
		sql.SELECT("create_date");
		sql.SELECT("patient_num");
		sql.SELECT("csv_file_num");
		sql.SELECT("medication_num");
		sql.SELECT("patient_increase");
		sql.SELECT("medication_increase");
		sql.SELECT("csv_increase");
		sql.SELECT("csv_delete");
		sql.SELECT("comment");
		sql.FROM("version");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		Version record = (Version) parameter.get("record");
		VersionExample example = (VersionExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("version");
		if (record.getVersionId() != null) {
			sql.SET("version_id = #{record.versionId,jdbcType=INTEGER}");
		}
		if (record.getCreateDate() != null) {
			sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
		}
		if (record.getPatientNum() != null) {
			sql.SET("patient_num = #{record.patientNum,jdbcType=INTEGER}");
		}
		if (record.getCsvFileNum() != null) {
			sql.SET("csv_file_num = #{record.csvFileNum,jdbcType=INTEGER}");
		}
		if (record.getMedicationNum() != null) {
			sql.SET("medication_num = #{record.medicationNum,jdbcType=INTEGER}");
		}
		if (record.getPatientIncrease() != null) {
			sql.SET("patient_increase = #{record.patientIncrease,jdbcType=INTEGER}");
		}
		if (record.getMedicationIncrease() != null) {
			sql.SET("medication_increase = #{record.medicationIncrease,jdbcType=INTEGER}");
		}
		if (record.getCsvIncrease() != null) {
			sql.SET("csv_increase = #{record.csvIncrease,jdbcType=INTEGER}");
		}
		if (record.getCsvDelete() != null) {
			sql.SET("csv_delete = #{record.csvDelete,jdbcType=INTEGER}");
		}
		if (record.getComment() != null) {
			sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("version");
		sql.SET("version_id = #{record.versionId,jdbcType=INTEGER}");
		sql.SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
		sql.SET("patient_num = #{record.patientNum,jdbcType=INTEGER}");
		sql.SET("csv_file_num = #{record.csvFileNum,jdbcType=INTEGER}");
		sql.SET("medication_num = #{record.medicationNum,jdbcType=INTEGER}");
		sql.SET("patient_increase = #{record.patientIncrease,jdbcType=INTEGER}");
		sql.SET("medication_increase = #{record.medicationIncrease,jdbcType=INTEGER}");
		sql.SET("csv_increase = #{record.csvIncrease,jdbcType=INTEGER}");
		sql.SET("csv_delete = #{record.csvDelete,jdbcType=INTEGER}");
		sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
		VersionExample example = (VersionExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	protected void applyWhere(SQL sql, VersionExample example, boolean includeExamplePhrase) {
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