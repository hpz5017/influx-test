package edu.pitt.medschool.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import edu.pitt.medschool.model.dto.CsvFile;
import edu.pitt.medschool.model.dto.CsvFileExample;
import edu.pitt.medschool.model.dto.TimeLine;

@Mapper
public interface CsvFileMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @SelectProvider(type = CsvFileSqlProvider.class, method = "countByExample")
    long countByExample(CsvFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @DeleteProvider(type = CsvFileSqlProvider.class, method = "deleteByExample")
    int deleteByExample(CsvFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @Insert({ "insert into csv_file (id, pid, ", "filename, start_time, ", "end_time, length, ", "density, machine, ",
            "ar, path, size, ", "uuid, header_time, ", "deleted, delete_time)",
            "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=VARCHAR}, ",
            "#{filename,jdbcType=VARCHAR}, #{startTime,jdbcType=TIMESTAMP}, ",
            "#{endTime,jdbcType=TIMESTAMP}, #{length,jdbcType=INTEGER}, ",
            "#{density,jdbcType=DOUBLE}, #{machine,jdbcType=VARCHAR}, ",
            "#{ar,jdbcType=BIT}, #{path,jdbcType=VARCHAR}, #{size,jdbcType=INTEGER}, ",
            "#{uuid,jdbcType=CHAR}, #{headerTime,jdbcType=TIMESTAMP}, ",
            "#{deleted,jdbcType=BIT}, #{deleteTime,jdbcType=TIMESTAMP})" })
    int insert(CsvFile record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @InsertProvider(type = CsvFileSqlProvider.class, method = "insertSelective")
    int insertSelective(CsvFile record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @SelectProvider(type = CsvFileSqlProvider.class, method = "selectByExample")
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "filename", property = "filename", jdbcType = JdbcType.VARCHAR),
            @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "length", property = "length", jdbcType = JdbcType.INTEGER),
            @Result(column = "density", property = "density", jdbcType = JdbcType.DOUBLE),
            @Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.BIT),
            @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size", property = "size", jdbcType = JdbcType.INTEGER),
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.CHAR),
            @Result(column = "header_time", property = "headerTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT),
            @Result(column = "delete_time", property = "deleteTime", jdbcType = JdbcType.TIMESTAMP) })
    List<CsvFile> selectByExampleWithRowbounds(CsvFileExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @SelectProvider(type = CsvFileSqlProvider.class, method = "selectByExample")
    @Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "pid", property = "pid", jdbcType = JdbcType.VARCHAR),
            @Result(column = "filename", property = "filename", jdbcType = JdbcType.VARCHAR),
            @Result(column = "start_time", property = "startTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "end_time", property = "endTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "length", property = "length", jdbcType = JdbcType.INTEGER),
            @Result(column = "density", property = "density", jdbcType = JdbcType.DOUBLE),
            @Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ar", property = "ar", jdbcType = JdbcType.BIT),
            @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
            @Result(column = "size", property = "size", jdbcType = JdbcType.INTEGER),
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.CHAR),
            @Result(column = "header_time", property = "headerTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT),
            @Result(column = "delete_time", property = "deleteTime", jdbcType = JdbcType.TIMESTAMP) })
    List<CsvFile> selectByExample(CsvFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @UpdateProvider(type = CsvFileSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CsvFile record, @Param("example") CsvFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table csv_file
     * @mbg.generated
     */
    @UpdateProvider(type = CsvFileSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") CsvFile record, @Param("example") CsvFileExample example);

    @Select({ "select c.pid as pid,c.filename as filename,c.start_time as start_time,c.end_time as end_time, ",
            "p.arrestdate as arrestdate,c.length as len, p.arresttime as arresttime, c.uuid as uuid from csv_file c , ",
            "patient p where c.pid = p.id and c.machine= '${machine}' and p.arrestdate is not null" })
    List<TimeLine> getPatientTimeLines(@Param("machine") String machine);

}