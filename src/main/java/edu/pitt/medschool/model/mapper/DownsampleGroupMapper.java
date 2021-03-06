package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.DownsampleGroup;
import edu.pitt.medschool.model.dto.DownsampleGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface DownsampleGroupMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleGroupSqlProvider.class, method = "countByExample")
	long countByExample(DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@DeleteProvider(type = DownsampleGroupSqlProvider.class, method = "deleteByExample")
	int deleteByExample(DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@Delete({ "delete from downsample_group", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@Insert({ "insert into downsample_group (query_id, label, ", "downsample, aggregation, ",
			"create_time, update_time, ", "deleted, columns)",
			"values (#{queryId,jdbcType=INTEGER}, #{label,jdbcType=VARCHAR}, ",
			"#{downsample,jdbcType=VARCHAR}, #{aggregation,jdbcType=VARCHAR}, ",
			"#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
			"#{deleted,jdbcType=BIT}, #{columns,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(DownsampleGroup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@InsertProvider(type = DownsampleGroupSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(DownsampleGroup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleGroupSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "query_id", property = "queryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
			@Result(column = "downsample", property = "downsample", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aggregation", property = "aggregation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "columns", property = "columns", jdbcType = JdbcType.LONGVARCHAR) })
	List<DownsampleGroup> selectByExampleWithBLOBsWithRowbounds(DownsampleGroupExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleGroupSqlProvider.class, method = "selectByExampleWithBLOBs")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "query_id", property = "queryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
			@Result(column = "downsample", property = "downsample", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aggregation", property = "aggregation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "columns", property = "columns", jdbcType = JdbcType.LONGVARCHAR) })
	List<DownsampleGroup> selectByExampleWithBLOBs(DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleGroupSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "query_id", property = "queryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
			@Result(column = "downsample", property = "downsample", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aggregation", property = "aggregation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT) })
	List<DownsampleGroup> selectByExampleWithRowbounds(DownsampleGroupExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleGroupSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "query_id", property = "queryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
			@Result(column = "downsample", property = "downsample", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aggregation", property = "aggregation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT) })
	List<DownsampleGroup> selectByExample(DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@Select({ "select", "id, query_id, label, downsample, aggregation, create_time, update_time, deleted, ", "columns",
			"from downsample_group", "where id = #{id,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "query_id", property = "queryId", jdbcType = JdbcType.INTEGER),
			@Result(column = "label", property = "label", jdbcType = JdbcType.VARCHAR),
			@Result(column = "downsample", property = "downsample", jdbcType = JdbcType.VARCHAR),
			@Result(column = "aggregation", property = "aggregation", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT),
			@Result(column = "columns", property = "columns", jdbcType = JdbcType.LONGVARCHAR) })
	DownsampleGroup selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleGroupSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") DownsampleGroup record,
			@Param("example") DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleGroupSqlProvider.class, method = "updateByExampleWithBLOBs")
	int updateByExampleWithBLOBs(@Param("record") DownsampleGroup record,
			@Param("example") DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleGroupSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") DownsampleGroup record, @Param("example") DownsampleGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleGroupSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(DownsampleGroup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@Update({ "update downsample_group", "set query_id = #{queryId,jdbcType=INTEGER},",
			"label = #{label,jdbcType=VARCHAR},", "downsample = #{downsample,jdbcType=VARCHAR},",
			"aggregation = #{aggregation,jdbcType=VARCHAR},", "create_time = #{createTime,jdbcType=TIMESTAMP},",
			"update_time = #{updateTime,jdbcType=TIMESTAMP},", "deleted = #{deleted,jdbcType=BIT},",
			"columns = #{columns,jdbcType=LONGVARCHAR}", "where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(DownsampleGroup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample_group
	 * @mbg.generated
	 */
	@Update({ "update downsample_group", "set query_id = #{queryId,jdbcType=INTEGER},",
			"label = #{label,jdbcType=VARCHAR},", "downsample = #{downsample,jdbcType=VARCHAR},",
			"aggregation = #{aggregation,jdbcType=VARCHAR},", "create_time = #{createTime,jdbcType=TIMESTAMP},",
			"update_time = #{updateTime,jdbcType=TIMESTAMP},", "deleted = #{deleted,jdbcType=BIT}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(DownsampleGroup record);
}