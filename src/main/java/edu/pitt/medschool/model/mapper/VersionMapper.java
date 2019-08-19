package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.Version;
import edu.pitt.medschool.model.dto.VersionExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VersionMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@SelectProvider(type = VersionSqlProvider.class, method = "countByExample")
	long countByExample(VersionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@DeleteProvider(type = VersionSqlProvider.class, method = "deleteByExample")
	int deleteByExample(VersionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@Delete({ "delete from version", "where version_id = #{versionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer versionId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "versionId", before = false, resultType = Integer.class)
	@Insert({ "insert into version (version_id, create_date, ", "patient_num, csv_file_num, ",
			"medication_num, patient_increase, ", "medication_increase, csv_increase, ", "csv_delete, comment, ",
			"PUH_patients, UAB_patients, ", "TBI_patients, patients_with_csv, ", "total_length, db_size)",
			"values (#{versionId,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP}, ",
			"#{patientNum,jdbcType=INTEGER}, #{csvFileNum,jdbcType=INTEGER}, ",
			"#{medicationNum,jdbcType=INTEGER}, #{patientIncrease,jdbcType=INTEGER}, ",
			"#{medicationIncrease,jdbcType=INTEGER}, #{csvIncrease,jdbcType=INTEGER}, ",
			"#{csvDelete,jdbcType=INTEGER}, #{comment,jdbcType=VARCHAR}, ",
			"#{puhPatients,jdbcType=INTEGER}, #{uabPatients,jdbcType=INTEGER}, ",
			"#{tbiPatients,jdbcType=INTEGER}, #{patientsWithCsv,jdbcType=INTEGER}, ",
			"#{totalLength,jdbcType=INTEGER}, #{dbSize,jdbcType=INTEGER})" })
	int insert(Version record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	@InsertProvider(type = VersionSqlProvider.class, method = "insertSelective")
	int insertSelective(Version record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@SelectProvider(type = VersionSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "version_id", property = "versionId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "patient_num", property = "patientNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_file_num", property = "csvFileNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_num", property = "medicationNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "patient_increase", property = "patientIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_increase", property = "medicationIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_increase", property = "csvIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_delete", property = "csvDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PUH_patients", property = "puhPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "UAB_patients", property = "uabPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "TBI_patients", property = "tbiPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "patients_with_csv", property = "patientsWithCsv", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_length", property = "totalLength", jdbcType = JdbcType.INTEGER),
			@Result(column = "db_size", property = "dbSize", jdbcType = JdbcType.INTEGER) })
	List<Version> selectByExampleWithRowbounds(VersionExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@SelectProvider(type = VersionSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "version_id", property = "versionId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "patient_num", property = "patientNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_file_num", property = "csvFileNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_num", property = "medicationNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "patient_increase", property = "patientIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_increase", property = "medicationIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_increase", property = "csvIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_delete", property = "csvDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PUH_patients", property = "puhPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "UAB_patients", property = "uabPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "TBI_patients", property = "tbiPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "patients_with_csv", property = "patientsWithCsv", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_length", property = "totalLength", jdbcType = JdbcType.INTEGER),
			@Result(column = "db_size", property = "dbSize", jdbcType = JdbcType.INTEGER) })
	List<Version> selectByExample(VersionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@Select({ "select", "version_id, create_date, patient_num, csv_file_num, medication_num, patient_increase, ",
			"medication_increase, csv_increase, csv_delete, comment, PUH_patients, UAB_patients, ",
			"TBI_patients, patients_with_csv, total_length, db_size", "from version",
			"where version_id = #{versionId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "version_id", property = "versionId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "patient_num", property = "patientNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_file_num", property = "csvFileNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_num", property = "medicationNum", jdbcType = JdbcType.INTEGER),
			@Result(column = "patient_increase", property = "patientIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "medication_increase", property = "medicationIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_increase", property = "csvIncrease", jdbcType = JdbcType.INTEGER),
			@Result(column = "csv_delete", property = "csvDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "comment", property = "comment", jdbcType = JdbcType.VARCHAR),
			@Result(column = "PUH_patients", property = "puhPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "UAB_patients", property = "uabPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "TBI_patients", property = "tbiPatients", jdbcType = JdbcType.INTEGER),
			@Result(column = "patients_with_csv", property = "patientsWithCsv", jdbcType = JdbcType.INTEGER),
			@Result(column = "total_length", property = "totalLength", jdbcType = JdbcType.INTEGER),
			@Result(column = "db_size", property = "dbSize", jdbcType = JdbcType.INTEGER) })
	Version selectByPrimaryKey(Integer versionId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@UpdateProvider(type = VersionSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@UpdateProvider(type = VersionSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@UpdateProvider(type = VersionSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Version record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table version
	 * @mbg.generated
	 */
	@Update({ "update version", "set create_date = #{createDate,jdbcType=TIMESTAMP},",
			"patient_num = #{patientNum,jdbcType=INTEGER},", "csv_file_num = #{csvFileNum,jdbcType=INTEGER},",
			"medication_num = #{medicationNum,jdbcType=INTEGER},",
			"patient_increase = #{patientIncrease,jdbcType=INTEGER},",
			"medication_increase = #{medicationIncrease,jdbcType=INTEGER},",
			"csv_increase = #{csvIncrease,jdbcType=INTEGER},", "csv_delete = #{csvDelete,jdbcType=INTEGER},",
			"comment = #{comment,jdbcType=VARCHAR},", "PUH_patients = #{puhPatients,jdbcType=INTEGER},",
			"UAB_patients = #{uabPatients,jdbcType=INTEGER},", "TBI_patients = #{tbiPatients,jdbcType=INTEGER},",
			"patients_with_csv = #{patientsWithCsv,jdbcType=INTEGER},",
			"total_length = #{totalLength,jdbcType=INTEGER},", "db_size = #{dbSize,jdbcType=INTEGER}",
			"where version_id = #{versionId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Version record);

	@Select("SELECT IFNULL(MAX(version_id),0) FROM version")
    int getlatestID();
}