/**
 *
 */
package edu.pitt.medschool.controller.query;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.pitt.medschool.model.dao.PatientDao;
import edu.pitt.medschool.model.dto.PatientExample;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pitt.medschool.controller.query.vo.DifferRequestBodyBean;
import edu.pitt.medschool.controller.query.vo.ExceedRequestBodyBean;
import edu.pitt.medschool.controller.query.vo.RawDataRequestBodyBean;
import edu.pitt.medschool.model.QueryResultBean;
import edu.pitt.medschool.model.TSData.RawData;
import edu.pitt.medschool.service.ColumnService;
import edu.pitt.medschool.service.QueryUserDefinedService;
import edu.pitt.medschool.service.RawDataService;

/**
 * @author Isolachine
 */

@Controller
@RestController
@RequestMapping("query")
public class QueryController {

    @Value("${machine}")
    private String uuid;

    @Autowired
    QueryUserDefinedService queryUserDefinedService;
    @Autowired
    ColumnService columnService;
    @Autowired
    PatientDao patientDao;
    @Autowired
    RawDataService rawDataService;

    @RequestMapping("exceed")
    @ResponseBody
    public Model exceed(Model model) {
        model.addAttribute("columns", columnService.selectAllColumn());
        model.addAttribute("nav", "queries");
        model.addAttribute("subnav", "exceed");
        return model;
    }

    @RequestMapping("exceed/query")
    public Map<String, Object> exceedQuery(@RequestBody ExceedRequestBodyBean request, Model model) {
        if (request.getColumn() == null) {
            Map<String, Object> map = new HashedMap<>();
            map.put("data", new ArrayList<>());
            return map;
        }

        Map<String, String> meta = request.getMeta();
        PatientExample pe = new PatientExample();
        PatientExample.Criteria pec = pe.createCriteria();
        if (meta.get("ageLower") != null && !meta.get("ageLower").isEmpty()) {
            pec.andAgeGreaterThan(Byte.valueOf(meta.get("ageLower")));
        }
        if (meta.get("ageUpper") != null && !meta.get("ageUpper").isEmpty()) {
            pec.andAgeLessThanOrEqualTo(Byte.valueOf(meta.get("ageUpper")));
        }
        if (meta.get("gender") != null && !meta.get("gender").isEmpty()) {
            pec.andFemaleEqualTo(meta.get("gender").toUpperCase().equals("F"));
        }
        List<String> patientIDs = patientDao.selectIdByCustom(pe);

        List<QueryResultBean> resultBeans = queryUserDefinedService.TypeAQuery(request.getColumn(), (double) request.getThreshold(),
                request.getCount(), patientIDs, null);
        Map<String, Object> map = new HashedMap<>();
        map.put("data", resultBeans);
        return map;
    }

    @RequestMapping("differ")
    @ResponseBody
    public Model differ(Model model) {
        model.addAttribute("columns", columnService.selectAllColumn());
        model.addAttribute("nav", "queries");
        model.addAttribute("subnav", "differ");
        return model;
    }

    @RequestMapping("differ/query")
    public Map<String, Object> differQuery(@RequestBody DifferRequestBodyBean request, Model model) {
        if (request.getColumnA() == null || request.getColumnB() == null) {
            Map<String, Object> map = new HashedMap<>();
            map.put("data", new ArrayList<>());
            return map;
        }

        Map<String, String> meta = request.getMeta();
        PatientExample pe = new PatientExample();
        PatientExample.Criteria pec = pe.createCriteria();
        if (meta.get("ageLower") != null && !meta.get("ageLower").isEmpty()) {
            pec.andAgeGreaterThan(Byte.valueOf(meta.get("ageLower")));
        }
        if (meta.get("ageUpper") != null && !meta.get("ageUpper").isEmpty()) {
            pec.andAgeLessThanOrEqualTo(Byte.valueOf(meta.get("ageUpper")));
        }
        if (meta.get("gender") != null && !meta.get("gender").isEmpty()) {
            pec.andFemaleEqualTo(meta.get("gender").toUpperCase().equals("F"));
        }
        List<String> patientIDs = patientDao.selectIdByCustom(pe);

        List<QueryResultBean> resultBeans = queryUserDefinedService.TypeBQuery(request.getColumnA(), request.getColumnB(), request.getThreshold(),
                request.getCount(), patientIDs, null);
        Map<String, Object> map = new HashedMap<>();
        map.put("data", resultBeans);
        return map;
    }

    @RequestMapping("raw")
    public Map<String, Object> raw(@RequestBody RawDataRequestBodyBean request, Model model) throws ParseException {
        Map<String, Object> map = new HashedMap<>();

        List<RawData> rawData = rawDataService.selectAllRawDataInColumns(request.getTableName(), request.getColumnNames());

        List<List<String[]>> rawDataResponse = new ArrayList<>();
        int columnSize = request.getColumnNames().size();

        for (int i = 0; i < columnSize; i++) {
            List<String[]> aColumnData = new ArrayList<>();
            rawDataResponse.add(aColumnData);
        }

        for (RawData data : rawData) {
            for (int i = 0; i < columnSize; i++) {
                String[] point = new String[2];
                long millisecond = data.getTime().getEpochSecond() * 1000;
                point[0] = String.valueOf(millisecond);
                point[1] = String.valueOf(data.getValues().get(i));
                rawDataResponse.get(i).add(point);
            }
        }
        map.put("raw", rawDataResponse);

        return map;
    }

}
