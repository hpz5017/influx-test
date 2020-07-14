package edu.pitt.medschool.model.mapper;

import edu.pitt.medschool.controller.load.vo.ActivityVO;
import edu.pitt.medschool.controller.load.vo.ProgressVO;
import edu.pitt.medschool.model.dto.ImportProgress;
import edu.pitt.medschool.model.dto.ImportProgressExample;
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
public interface AggregationExplorerMapper {
	/**
	 * This method select current patients' file names and corresponding .csv file paths in the upmc database
	 */
	@Select({ "select", "filepath, filename", "from imported_file" })
	@Results({ @Result(column = "filepath", property = "filepath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "filename", property = "filename", jdbcType = JdbcType.VARCHAR)})
	ImportProgress selectByPrimaryKey(Integer id);
	
	
	
	
}