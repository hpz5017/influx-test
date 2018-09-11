/**
 * 
 */
package edu.pitt.medschool.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pitt.medschool.controller.analysis.vo.ColumnJSON;
import edu.pitt.medschool.controller.analysis.vo.ColumnVO;
import edu.pitt.medschool.framework.util.Util;
import edu.pitt.medschool.model.dto.Feature;
import edu.pitt.medschool.model.dto.FeatureExample;
import edu.pitt.medschool.model.mapper.FeatureMapper;

/**
 * @author Isolachine
 *
 */
@Repository
public class FeatureDao {
    @Autowired
    FeatureMapper featureMapper;

    public List<String> selectAllMeasures() {
        List<String> list = featureMapper.selectAllMeasures();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Time")) {
                list.remove(i);
            }
        }
        return list;
    }

    public List<ColumnVO> selectColumnVOsBySet(String electrode) {
        return featureMapper.selectColumnVOsBySet(electrode);
    }

    public List<Feature> selectByMeasure(String measure) {
        FeatureExample example = new FeatureExample();
        example.createCriteria().andTypeEqualTo(measure);
        return featureMapper.selectByExample(example);
    }

    public List<String> selectColumnsByAggregationGroupColumns(ColumnJSON json) {
        String colString = Util.wrapAndConcatStringList("'", ", ", json.getColumns());
        String elecString;
        boolean querySid;
        if (json.getElectrodes().size() == 1 && json.getElectrodes().get(0).startsWith("*")) {
            String[] components = json.getElectrodes().get(0).split(" ");
            List<String> sids = new ArrayList<>();
            for (int i = Integer.parseInt(components[2].substring(1, components[2].length())); i <= Integer
                    .valueOf(components[4].substring(1, components[4].length())); i++) {
                sids.add("I" + i);
            }
            elecString = Util.wrapAndConcatStringList("'", ", ", sids);
            querySid = true;
        } else {
            elecString = Util.wrapAndConcatStringList("'", ", ", json.getElectrodes());
            querySid = false;
        }
        return featureMapper.selectColumnsByAggregationGroupColumns(json.getType(), elecString, colString, querySid);
    }

}
