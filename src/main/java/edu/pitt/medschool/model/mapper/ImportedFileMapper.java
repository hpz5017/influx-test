package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.ImportedFile;
import edu.pitt.medschool.model.dto.ImportedFileExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface ImportedFileMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@SelectProvider(type=ImportedFileSqlProvider.class, method="countByExample") long countByExample(ImportedFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@DeleteProvider(type=ImportedFileSqlProvider.class, method="deleteByExample") int deleteByExample(ImportedFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@Delete({"delete from imported_file","where id = #{id,jdbcType=INTEGER}"}) int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@Insert({"insert into imported_file (id, filepath, ","filename, filelines, ","filesize, PID, isAr, ","timestamp, uuid)","values (#{id,jdbcType=INTEGER}, #{filepath,jdbcType=VARCHAR}, ","#{filename,jdbcType=VARCHAR}, #{filelines,jdbcType=INTEGER}, ","#{filesize,jdbcType=BIGINT}, #{pid,jdbcType=VARCHAR}, #{isar,jdbcType=BIT}, ","#{timestamp,jdbcType=TIMESTAMP}, #{uuid,jdbcType=VARCHAR})"}) int insert(ImportedFile record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@InsertProvider(type=ImportedFileSqlProvider.class, method="insertSelective") int insertSelective(ImportedFile record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@SelectProvider(type=ImportedFileSqlProvider.class, method="selectByExample") @Results({@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),@Result(column="filepath", property="filepath", jdbcType=JdbcType.VARCHAR),@Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),@Result(column="filelines", property="filelines", jdbcType=JdbcType.INTEGER),@Result(column="filesize", property="filesize", jdbcType=JdbcType.BIGINT),@Result(column="PID", property="pid", jdbcType=JdbcType.VARCHAR),@Result(column="isAr", property="isar", jdbcType=JdbcType.BIT),@Result(column="timestamp", property="timestamp", jdbcType=JdbcType.TIMESTAMP),@Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)}) List<ImportedFile> selectByExampleWithRowbounds(ImportedFileExample example,RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@SelectProvider(type=ImportedFileSqlProvider.class, method="selectByExample") @Results({@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),@Result(column="filepath", property="filepath", jdbcType=JdbcType.VARCHAR),@Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),@Result(column="filelines", property="filelines", jdbcType=JdbcType.INTEGER),@Result(column="filesize", property="filesize", jdbcType=JdbcType.BIGINT),@Result(column="PID", property="pid", jdbcType=JdbcType.VARCHAR),@Result(column="isAr", property="isar", jdbcType=JdbcType.BIT),@Result(column="timestamp", property="timestamp", jdbcType=JdbcType.TIMESTAMP),@Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)}) List<ImportedFile> selectByExample(ImportedFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@Select({"select","id, filepath, filename, filelines, filesize, PID, isAr, timestamp, uuid","from imported_file","where id = #{id,jdbcType=INTEGER}"}) @Results({@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),@Result(column="filepath", property="filepath", jdbcType=JdbcType.VARCHAR),@Result(column="filename", property="filename", jdbcType=JdbcType.VARCHAR),@Result(column="filelines", property="filelines", jdbcType=JdbcType.INTEGER),@Result(column="filesize", property="filesize", jdbcType=JdbcType.BIGINT),@Result(column="PID", property="pid", jdbcType=JdbcType.VARCHAR),@Result(column="isAr", property="isar", jdbcType=JdbcType.BIT),@Result(column="timestamp", property="timestamp", jdbcType=JdbcType.TIMESTAMP),@Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR)}) ImportedFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@UpdateProvider(type=ImportedFileSqlProvider.class, method="updateByExampleSelective") int updateByExampleSelective(@Param("record") ImportedFile record,@Param("example") ImportedFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@UpdateProvider(type=ImportedFileSqlProvider.class, method="updateByExample") int updateByExample(@Param("record") ImportedFile record,@Param("example") ImportedFileExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@UpdateProvider(type=ImportedFileSqlProvider.class, method="updateByPrimaryKeySelective") int updateByPrimaryKeySelective(ImportedFile record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table imported_file
     * @mbg.generated
     */@Update({"update imported_file","set filepath = #{filepath,jdbcType=VARCHAR},","filename = #{filename,jdbcType=VARCHAR},","filelines = #{filelines,jdbcType=INTEGER},","filesize = #{filesize,jdbcType=BIGINT},","PID = #{pid,jdbcType=VARCHAR},","isAr = #{isar,jdbcType=BIT},","timestamp = #{timestamp,jdbcType=TIMESTAMP},","uuid = #{uuid,jdbcType=VARCHAR}","where id = #{id,jdbcType=INTEGER}"}) int updateByPrimaryKey(ImportedFile record);

    @Select({
            "SELECT PID",
            "FROM imported_file",
            "WHERE uuid = #{uid}"
    })
    @ResultType(String.class)
    @Results({@Result(column = "PID", property = "PID", jdbcType = JdbcType.VARCHAR)})
    List<String> selectAllImportedPid(String uid);
}