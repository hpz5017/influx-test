package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.NotInCsvFile;
import edu.pitt.medschool.model.dto.NotInCsvFileExample.Criteria;
import edu.pitt.medschool.model.dto.NotInCsvFileExample.Criterion;
import edu.pitt.medschool.model.dto.NotInCsvFileExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class NotInCsvFileSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String countByExample(NotInCsvFileExample example) {
		SQL sql = new SQL();
		sql.SELECT("count(*)").FROM("not_in_csv_file");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String deleteByExample(NotInCsvFileExample example) {
		SQL sql = new SQL();
		sql.DELETE_FROM("not_in_csv_file");
		applyWhere(sql, example, false);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String insertSelective(NotInCsvFile record) {
		SQL sql = new SQL();
		sql.INSERT_INTO("not_in_csv_file");
		if (record.getId() != null) {
			sql.VALUES("id", "#{id,jdbcType=INTEGER}");
		}
		if (record.getPid() != null) {
			sql.VALUES("pid", "#{pid,jdbcType=VARCHAR}");
		}
		if (record.getStartTime() != null) {
			sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
		}
		if (record.getEndTime() != null) {
			sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
		}
		if (record.getHeaderTime() != null) {
			sql.VALUES("header_time", "#{headerTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUuid() != null) {
			sql.VALUES("uuid", "#{uuid,jdbcType=CHAR}");
		}
		if (record.getFilename() != null) {
			sql.VALUES("filename", "#{filename,jdbcType=VARCHAR}");
		}
		if (record.getLength() != null) {
			sql.VALUES("length", "#{length,jdbcType=INTEGER}");
		}
		if (record.getDensity() != null) {
			sql.VALUES("density", "#{density,jdbcType=DOUBLE}");
		}
		if (record.getComment() != null) {
			sql.VALUES("comment", "#{comment,jdbcType=VARCHAR}");
		}
		if (record.getLastUpdate() != null) {
			sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getNotInCsvFilecol() != null) {
			sql.VALUES("not_in_csv_filecol", "#{notInCsvFilecol,jdbcType=VARCHAR}");
		}
		if (record.getMachine() != null) {
			sql.VALUES("machine", "#{machine,jdbcType=VARCHAR}");
		}
		if (record.getAr() != null) {
			sql.VALUES("ar", "#{ar,jdbcType=BIT}");
		}
		if (record.getPath() != null) {
			sql.VALUES("path", "#{path,jdbcType=VARCHAR}");
		}
		if (record.getSize() != null) {
			sql.VALUES("size", "#{size,jdbcType=BIGINT}");
		}
		if (record.getConflictResolved() != null) {
			sql.VALUES("conflict_resolved", "#{conflictResolved,jdbcType=BIT}");
		}
		if (record.getStatus() != null) {
			sql.VALUES("status", "#{status,jdbcType=INTEGER}");
		}
		if (record.getWidth() != null) {
			sql.VALUES("width", "#{width,jdbcType=INTEGER}");
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String selectByExample(NotInCsvFileExample example) {
		SQL sql = new SQL();
		if (example != null && example.isDistinct()) {
			sql.SELECT_DISTINCT("id");
		} else {
			sql.SELECT("id");
		}
		sql.SELECT("pid");
		sql.SELECT("start_time");
		sql.SELECT("end_time");
		sql.SELECT("header_time");
		sql.SELECT("uuid");
		sql.SELECT("filename");
		sql.SELECT("length");
		sql.SELECT("density");
		sql.SELECT("comment");
		sql.SELECT("last_update");
		sql.SELECT("not_in_csv_filecol");
		sql.SELECT("machine");
		sql.SELECT("ar");
		sql.SELECT("path");
		sql.SELECT("size");
		sql.SELECT("conflict_resolved");
		sql.SELECT("status");
		sql.SELECT("width");
		sql.FROM("not_in_csv_file");
		applyWhere(sql, example, false);
		if (example != null && example.getOrderByClause() != null) {
			sql.ORDER_BY(example.getOrderByClause());
		}
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		NotInCsvFile record = (NotInCsvFile) parameter.get("record");
		NotInCsvFileExample example = (NotInCsvFileExample) parameter.get("example");
		SQL sql = new SQL();
		sql.UPDATE("not_in_csv_file");
		if (record.getId() != null) {
			sql.SET("id = #{record.id,jdbcType=INTEGER}");
		}
		if (record.getPid() != null) {
			sql.SET("pid = #{record.pid,jdbcType=VARCHAR}");
		}
		if (record.getStartTime() != null) {
			sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
		}
		if (record.getEndTime() != null) {
			sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
		}
		if (record.getHeaderTime() != null) {
			sql.SET("header_time = #{record.headerTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUuid() != null) {
			sql.SET("uuid = #{record.uuid,jdbcType=CHAR}");
		}
		if (record.getFilename() != null) {
			sql.SET("filename = #{record.filename,jdbcType=VARCHAR}");
		}
		if (record.getLength() != null) {
			sql.SET("length = #{record.length,jdbcType=INTEGER}");
		}
		if (record.getDensity() != null) {
			sql.SET("density = #{record.density,jdbcType=DOUBLE}");
		}
		if (record.getComment() != null) {
			sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
		}
		if (record.getLastUpdate() != null) {
			sql.SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getNotInCsvFilecol() != null) {
			sql.SET("not_in_csv_filecol = #{record.notInCsvFilecol,jdbcType=VARCHAR}");
		}
		if (record.getMachine() != null) {
			sql.SET("machine = #{record.machine,jdbcType=VARCHAR}");
		}
		if (record.getAr() != null) {
			sql.SET("ar = #{record.ar,jdbcType=BIT}");
		}
		if (record.getPath() != null) {
			sql.SET("path = #{record.path,jdbcType=VARCHAR}");
		}
		if (record.getSize() != null) {
			sql.SET("size = #{record.size,jdbcType=BIGINT}");
		}
		if (record.getConflictResolved() != null) {
			sql.SET("conflict_resolved = #{record.conflictResolved,jdbcType=BIT}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{record.status,jdbcType=INTEGER}");
		}
		if (record.getWidth() != null) {
			sql.SET("width = #{record.width,jdbcType=INTEGER}");
		}
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String updateByExample(Map<String, Object> parameter) {
		SQL sql = new SQL();
		sql.UPDATE("not_in_csv_file");
		sql.SET("id = #{record.id,jdbcType=INTEGER}");
		sql.SET("pid = #{record.pid,jdbcType=VARCHAR}");
		sql.SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
		sql.SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
		sql.SET("header_time = #{record.headerTime,jdbcType=TIMESTAMP}");
		sql.SET("uuid = #{record.uuid,jdbcType=CHAR}");
		sql.SET("filename = #{record.filename,jdbcType=VARCHAR}");
		sql.SET("length = #{record.length,jdbcType=INTEGER}");
		sql.SET("density = #{record.density,jdbcType=DOUBLE}");
		sql.SET("comment = #{record.comment,jdbcType=VARCHAR}");
		sql.SET("last_update = #{record.lastUpdate,jdbcType=TIMESTAMP}");
		sql.SET("not_in_csv_filecol = #{record.notInCsvFilecol,jdbcType=VARCHAR}");
		sql.SET("machine = #{record.machine,jdbcType=VARCHAR}");
		sql.SET("ar = #{record.ar,jdbcType=BIT}");
		sql.SET("path = #{record.path,jdbcType=VARCHAR}");
		sql.SET("size = #{record.size,jdbcType=BIGINT}");
		sql.SET("conflict_resolved = #{record.conflictResolved,jdbcType=BIT}");
		sql.SET("status = #{record.status,jdbcType=INTEGER}");
		sql.SET("width = #{record.width,jdbcType=INTEGER}");
		NotInCsvFileExample example = (NotInCsvFileExample) parameter.get("example");
		applyWhere(sql, example, true);
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	public String updateByPrimaryKeySelective(NotInCsvFile record) {
		SQL sql = new SQL();
		sql.UPDATE("not_in_csv_file");
		if (record.getPid() != null) {
			sql.SET("pid = #{pid,jdbcType=VARCHAR}");
		}
		if (record.getStartTime() != null) {
			sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
		}
		if (record.getEndTime() != null) {
			sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
		}
		if (record.getHeaderTime() != null) {
			sql.SET("header_time = #{headerTime,jdbcType=TIMESTAMP}");
		}
		if (record.getUuid() != null) {
			sql.SET("uuid = #{uuid,jdbcType=CHAR}");
		}
		if (record.getFilename() != null) {
			sql.SET("filename = #{filename,jdbcType=VARCHAR}");
		}
		if (record.getLength() != null) {
			sql.SET("length = #{length,jdbcType=INTEGER}");
		}
		if (record.getDensity() != null) {
			sql.SET("density = #{density,jdbcType=DOUBLE}");
		}
		if (record.getComment() != null) {
			sql.SET("comment = #{comment,jdbcType=VARCHAR}");
		}
		if (record.getLastUpdate() != null) {
			sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
		}
		if (record.getNotInCsvFilecol() != null) {
			sql.SET("not_in_csv_filecol = #{notInCsvFilecol,jdbcType=VARCHAR}");
		}
		if (record.getMachine() != null) {
			sql.SET("machine = #{machine,jdbcType=VARCHAR}");
		}
		if (record.getAr() != null) {
			sql.SET("ar = #{ar,jdbcType=BIT}");
		}
		if (record.getPath() != null) {
			sql.SET("path = #{path,jdbcType=VARCHAR}");
		}
		if (record.getSize() != null) {
			sql.SET("size = #{size,jdbcType=BIGINT}");
		}
		if (record.getConflictResolved() != null) {
			sql.SET("conflict_resolved = #{conflictResolved,jdbcType=BIT}");
		}
		if (record.getStatus() != null) {
			sql.SET("status = #{status,jdbcType=INTEGER}");
		}
		if (record.getWidth() != null) {
			sql.SET("width = #{width,jdbcType=INTEGER}");
		}
		sql.WHERE("id = #{id,jdbcType=INTEGER}");
		return sql.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table upmc..not_in_csv_file
	 * @mbg.generated
	 */
	protected void applyWhere(SQL sql, NotInCsvFileExample example, boolean includeExamplePhrase) {
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