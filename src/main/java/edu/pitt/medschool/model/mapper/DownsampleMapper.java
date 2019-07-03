package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.model.dto.Downsample;
import edu.pitt.medschool.model.dto.DownsampleExample;
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
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface DownsampleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleSqlProvider.class, method = "countByExample")
	long countByExample(DownsampleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@DeleteProvider(type = DownsampleSqlProvider.class, method = "deleteByExample")
	int deleteByExample(DownsampleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@Delete({ "delete from downsample", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@Insert({ "insert into downsample (alias, period, ", "duration, origin, ", "min_bin, min_bin_row, ",
			"downsample_first, create_time, ", "update_time, deleted)",
			"values (#{alias,jdbcType=VARCHAR}, #{period,jdbcType=INTEGER}, ",
			"#{duration,jdbcType=INTEGER}, #{origin,jdbcType=INTEGER}, ",
			"#{minBin,jdbcType=INTEGER}, #{minBinRow,jdbcType=INTEGER}, ",
			"#{downsampleFirst,jdbcType=BIT}, #{createTime,jdbcType=TIMESTAMP}, ",
			"#{updateTime,jdbcType=TIMESTAMP}, #{deleted,jdbcType=BIT})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insert(Downsample record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@InsertProvider(type = DownsampleSqlProvider.class, method = "insertSelective")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	int insertSelective(Downsample record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "alias", property = "alias", jdbcType = JdbcType.VARCHAR),
			@Result(column = "period", property = "period", jdbcType = JdbcType.INTEGER),
			@Result(column = "duration", property = "duration", jdbcType = JdbcType.INTEGER),
			@Result(column = "origin", property = "origin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin", property = "minBin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin_row", property = "minBinRow", jdbcType = JdbcType.INTEGER),
			@Result(column = "downsample_first", property = "downsampleFirst", jdbcType = JdbcType.BIT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT) })
	List<Downsample> selectByExampleWithRowbounds(DownsampleExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@SelectProvider(type = DownsampleSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
			@Result(column = "alias", property = "alias", jdbcType = JdbcType.VARCHAR),
			@Result(column = "period", property = "period", jdbcType = JdbcType.INTEGER),
			@Result(column = "duration", property = "duration", jdbcType = JdbcType.INTEGER),
			@Result(column = "origin", property = "origin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin", property = "minBin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin_row", property = "minBinRow", jdbcType = JdbcType.INTEGER),
			@Result(column = "downsample_first", property = "downsampleFirst", jdbcType = JdbcType.BIT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT) })
	List<Downsample> selectByExample(DownsampleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@Select({ "select", "id, alias, period, duration, origin, min_bin, min_bin_row, downsample_first, ",
			"create_time, update_time, deleted", "from downsample", "where id = #{id,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "alias", property = "alias", jdbcType = JdbcType.VARCHAR),
			@Result(column = "period", property = "period", jdbcType = JdbcType.INTEGER),
			@Result(column = "duration", property = "duration", jdbcType = JdbcType.INTEGER),
			@Result(column = "origin", property = "origin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin", property = "minBin", jdbcType = JdbcType.INTEGER),
			@Result(column = "min_bin_row", property = "minBinRow", jdbcType = JdbcType.INTEGER),
			@Result(column = "downsample_first", property = "downsampleFirst", jdbcType = JdbcType.BIT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "deleted", property = "deleted", jdbcType = JdbcType.BIT) })
	Downsample selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Downsample record, @Param("example") DownsampleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Downsample record, @Param("example") DownsampleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@UpdateProvider(type = DownsampleSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Downsample record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table downsample
	 * @mbg.generated
	 */
	@Update({ "update downsample", "set alias = #{alias,jdbcType=VARCHAR},", "period = #{period,jdbcType=INTEGER},",
			"duration = #{duration,jdbcType=INTEGER},", "origin = #{origin,jdbcType=INTEGER},",
			"min_bin = #{minBin,jdbcType=INTEGER},", "min_bin_row = #{minBinRow,jdbcType=INTEGER},",
			"downsample_first = #{downsampleFirst,jdbcType=BIT},", "create_time = #{createTime,jdbcType=TIMESTAMP},",
			"update_time = #{updateTime,jdbcType=TIMESTAMP},", "deleted = #{deleted,jdbcType=BIT}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Downsample record);
}