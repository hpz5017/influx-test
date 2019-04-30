package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.ImportLog;
import edu.pitt.medschool.model.dto.ImportLogExample.Criteria;
import edu.pitt.medschool.model.dto.ImportLogExample.Criterion;
import edu.pitt.medschool.model.dto.ImportLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ImportLogSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String countByExample(ImportLogExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("import_log");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String deleteByExample(ImportLogExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("import_log");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String insertSelective(ImportLog record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("import_log");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getUuid() != null) {
			sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
		}
		if (record.getBatchId() != null) {
			sql.VALUES("batch_id", "#{batchId,jdbcType=VARCHAR}");
		}
		if (record.getFilename() != null) {
			sql.VALUES("filename", "#{filename,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
		}
		if (record.getTimestamp() != null) {
			sql.VALUES("timestamp", "#{timestamp,jdbcType=TIMESTAMP}");
		}
		if (record.getAllPercent() != null) {
			sql.VALUES("all_percent", "#{allPercent,jdbcType=DOUBLE}");
		}
		if (record.getThisPercent() != null) {
			sql.VALUES("this_percent", "#{thisPercent,jdbcType=DOUBLE}");
		}
		if (record.getAllFileSize() != null) {
			sql.VALUES("all_file_size", "#{allFileSize,jdbcType=BIGINT}");
		}
		if (record.getThisFileSize() != null) {
			sql.VALUES("this_file_size", "#{thisFileSize,jdbcType=BIGINT}");
		}
		if (record.getReason() != null) {
			sql.VALUES("reason", "#{reason,jdbcType=LONGVARCHAR}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String selectByExampleWithBLOBs(ImportLogExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("uuid");
		sql.SELECT("batch_id");
		sql.SELECT("filename");
		sql.SELECT("status");
		sql.SELECT("timestamp");
		sql.SELECT("all_percent");
		sql.SELECT("this_percent");
		sql.SELECT("all_file_size");
		sql.SELECT("this_file_size");
		sql.SELECT("reason");
		sql.FROM("import_log");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String selectByExample(ImportLogExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("uuid");
		sql.SELECT("batch_id");
		sql.SELECT("filename");
		sql.SELECT("status");
		sql.SELECT("timestamp");
		sql.SELECT("all_percent");
		sql.SELECT("this_percent");
		sql.SELECT("all_file_size");
		sql.SELECT("this_file_size");
		sql.FROM("import_log");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		ImportLog record = (ImportLog) parameter.get("record");
		ImportLogExample example = (ImportLogExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("import_log");
		if (record.getId() != null) {
			sql.SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getUuid() != null) {
			sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
		}
		if (record.getBatchId() != null) {
			sql.SET("batch_id = #{record.batchId,jdbcType=VARCHAR}");
		}
		if (record.getFilename() != null) {
			sql.SET("filename = #{record.filename,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{record.status,jdbcType=VARCHAR}");
		}
		if (record.getTimestamp() != null) {
			sql.SET("timestamp = #{record.timestamp,jdbcType=TIMESTAMP}");
		}
		if (record.getAllPercent() != null) {
			sql.SET("all_percent = #{record.allPercent,jdbcType=DOUBLE}");
		}
		if (record.getThisPercent() != null) {
			sql.SET("this_percent = #{record.thisPercent,jdbcType=DOUBLE}");
		}
		if (record.getAllFileSize() != null) {
			sql.SET("all_file_size = #{record.allFileSize,jdbcType=BIGINT}");
		}
		if (record.getThisFileSize() != null) {
			sql.SET("this_file_size = #{record.thisFileSize,jdbcType=BIGINT}");
		}
		if (record.getReason() != null) {
			sql.SET("reason = #{record.reason,jdbcType=LONGVARCHAR}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("import_log");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
		sql.SET("batch_id = #{record.batchId,jdbcType=VARCHAR}");
		sql.SET("filename = #{record.filename,jdbcType=VARCHAR}");
		sql.SET("status = #{record.status,jdbcType=VARCHAR}");
		sql.SET("timestamp = #{record.timestamp,jdbcType=TIMESTAMP}");
		sql.SET("all_percent = #{record.allPercent,jdbcType=DOUBLE}");
		sql.SET("this_percent = #{record.thisPercent,jdbcType=DOUBLE}");
		sql.SET("all_file_size = #{record.allFileSize,jdbcType=BIGINT}");
		sql.SET("this_file_size = #{record.thisFileSize,jdbcType=BIGINT}");
		sql.SET("reason = #{record.reason,jdbcType=LONGVARCHAR}");
		ImportLogExample example = (ImportLogExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("import_log");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("uuid = #{record.uuid,jdbcType=VARCHAR}");
		sql.SET("batch_id = #{record.batchId,jdbcType=VARCHAR}");
		sql.SET("filename = #{record.filename,jdbcType=VARCHAR}");
		sql.SET("status = #{record.status,jdbcType=VARCHAR}");
		sql.SET("timestamp = #{record.timestamp,jdbcType=TIMESTAMP}");
		sql.SET("all_percent = #{record.allPercent,jdbcType=DOUBLE}");
		sql.SET("this_percent = #{record.thisPercent,jdbcType=DOUBLE}");
		sql.SET("all_file_size = #{record.allFileSize,jdbcType=BIGINT}");
		sql.SET("this_file_size = #{record.thisFileSize,jdbcType=BIGINT}");
		ImportLogExample example = (ImportLogExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	public String updateByPrimaryKeySelective(ImportLog record) {
		SQL sql = new SQL();
		sql.UPDATE("import_log");
		if (record.getUuid() != null) {
			sql.SET("uuid = #{uuid,jdbcType=VARCHAR}");
		}
		if (record.getBatchId() != null) {
			sql.SET("batch_id = #{batchId,jdbcType=VARCHAR}");
		}
		if (record.getFilename() != null) {
			sql.SET("filename = #{filename,jdbcType=VARCHAR}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{status,jdbcType=VARCHAR}");
		}
		if (record.getTimestamp() != null) {
			sql.SET("timestamp = #{timestamp,jdbcType=TIMESTAMP}");
		}
		if (record.getAllPercent() != null) {
			sql.SET("all_percent = #{allPercent,jdbcType=DOUBLE}");
		}
		if (record.getThisPercent() != null) {
			sql.SET("this_percent = #{thisPercent,jdbcType=DOUBLE}");
		}
		if (record.getAllFileSize() != null) {
			sql.SET("all_file_size = #{allFileSize,jdbcType=BIGINT}");
		}
		if (record.getThisFileSize() != null) {
			sql.SET("this_file_size = #{thisFileSize,jdbcType=BIGINT}");
		}
		if (record.getReason() != null) {
			sql.SET("reason = #{reason,jdbcType=LONGVARCHAR}");
		}
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table import_log
	 * @mbg.generated
	 */
	protected void applyWhere(SQL sql, ImportLogExample example, boolean includeExamplePhrase) {
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