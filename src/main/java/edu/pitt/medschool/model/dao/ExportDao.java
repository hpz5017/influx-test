package edu.pitt.medschool.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import edu.pitt.medschool.controller.analysis.vo.ExportVO;
import edu.pitt.medschool.model.dto.ExportWithBLOBs;
import edu.pitt.medschool.model.mapper.ExportMapper;

@Repository
public class ExportDao {
    @Value("${machine}")
    private String machineId;
    
    @Autowired
    ExportMapper exportMapper;

    public int insertExportJob(ExportWithBLOBs job) {
        return exportMapper.insertSelective(job);
    }

    public ExportWithBLOBs selectByPrimaryKey(Integer exportId) {
        return exportMapper.selectByPrimaryKey(exportId);
    }

    public List<ExportVO> selectAllExportJobOnLocalMachine() {
        return exportMapper.selectAllExportJobOnLocalMachine(machineId);
    }

    public void updateByPrimaryKeySelective(ExportWithBLOBs job) {
        exportMapper.updateByPrimaryKeySelective(job);
    }

}