/**
 *
 */
package edu.pitt.medschool.controller.analysis;

import java.io.IOException;
import java.util.*;

import edu.pitt.medschool.model.dao.ImportedFileDao;
import edu.pitt.medschool.model.dao.PatientDao;
import edu.pitt.medschool.model.dto.Patient;
import edu.pitt.medschool.model.dto.PatientExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.pitt.medschool.controller.analysis.vo.DownsampleEditResponse;
import edu.pitt.medschool.controller.analysis.vo.DownsampleGroupVO;
import edu.pitt.medschool.framework.rest.RestfulResponse;
import edu.pitt.medschool.model.dto.Downsample;
import edu.pitt.medschool.service.AnalysisService;
import edu.pitt.medschool.service.ColumnService;

/**
 * @author Isolachine
 */

@Controller
public class AnalysisController {

    @Value("${machine}")
    private String uuid;

    @Autowired
    ColumnService columnService;
    @Autowired
    PatientDao patientDao;
    @Autowired
    ImportedFileDao importedFileDao;
    @Autowired
    AnalysisService analysisService;

    @RequestMapping("analysis/export")
    public Model exportPage(Model model) {
        model.addAttribute("nav", "analysis");
        model.addAttribute("subnav", "export");
        List<String> trends = columnService.selectAllMeasures();
        trends.add(0, "All");
        model.addAttribute("measures", trends);
        return model;
    }

    @RequestMapping("analysis/builder")
    public Model builderPage(Model model) {
        model.addAttribute("nav", "analysis");
        model.addAttribute("subnav", "builder");
        List<Downsample> downsamples = analysisService.selectAll();
        model.addAttribute("downsamples", downsamples);
        return model;
    }

    @RequestMapping(value = {"/analysis/edit/{id}", "/analysis/edit"}, method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Optional<Integer> id, ModelAndView modelAndView) {
        modelAndView.addObject("nav", "analysis");
        modelAndView.addObject("subnav", "edit");
        modelAndView.setViewName("/analysis/edit");
        if (id.isPresent()) {
            modelAndView.addObject("edit", true);
            Downsample downsample = analysisService.selectByPrimaryKey(id.get());
            DownsampleEditResponse downsampleEditResponse = new DownsampleEditResponse(downsample);
            modelAndView.addObject("query", downsampleEditResponse);
        } else {
            modelAndView.addObject("edit", false);
            List<Downsample> downsamples = analysisService.selectAll();
            modelAndView.addObject("downsamples", downsamples);
        }
        modelAndView.addObject("measures", columnService.selectAllMeasures());
        return modelAndView;
    }

    @RequestMapping(value = "analysis/query", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allQuery(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", analysisService.selectAll());
        RestfulResponse response = new RestfulResponse(1, "success");
        map.put("res", response);
        return map;
    }

    @RequestMapping(value = "analysis/query", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@RequestBody(required = true) Downsample downsample) throws Exception {
        analysisService.insert(downsample);
        Map<String, Object> map = new HashMap<>();
        map.put("data", analysisService.selectAll());
        return map;
    }

    @RequestMapping(value = "analysis/query", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> update(@RequestBody(required = true) Downsample downsample) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (analysisService.updateByPrimaryKey(downsample) == 1) {
            map.put("res", new RestfulResponse(1, "success"));
        } else {
            map.put("res", new RestfulResponse(0, "update failed"));
        }
        map.put("data", analysisService.selectByPrimaryKey(downsample.getId()));
        return map;
    }

    @RequestMapping(value = "analysis/group/{queryId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allQueryGroup(@PathVariable Integer queryId, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", analysisService.selectAllAggregationGroupByQueryId(queryId));
        RestfulResponse response = new RestfulResponse(1, "success");
        map.put("res", response);
        return map;
    }

    @RequestMapping(value = "analysis/group", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertQueryGroup(@RequestBody(required = true) DownsampleGroupVO group) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (analysisService.insertAggregationGroup(group)) {
            map.put("res", new RestfulResponse(1, "success"));
        } else {
            map.put("res", new RestfulResponse(0, "failed"));
        }
        return map;
    }

    @RequestMapping(value = "analysis/group", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateQueryGroup(@RequestBody(required = true) DownsampleGroupVO group) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (analysisService.updateAggregationGroup(group) == 1) {
            map.put("res", new RestfulResponse(1, "success"));
        } else {
            map.put("res", new RestfulResponse(0, "update failed"));
        }
        // map.put("data", analysisService.selectByPrimaryKey(group.getQueryId()));
        return map;
    }

    @RequestMapping("api/export/electrode")
    @ResponseBody
    public List<String> electrode(@RequestBody(required = true) List<String> measures, Model model) {
        return columnService.selectElectrodesByMeasures(measures);
    }

    public static class ColumnRequest {
        public String measure;
        public List<String> electrode;
    }

    @RequestMapping("api/export/column")
    @ResponseBody
    public List<String> column(@RequestBody(required = true) ColumnRequest params, Model model) {
        return columnService.selectColumnsByMeasuresAndElectrodes(params.measure, params.electrode);
    }

    public static class ExportRequest {
        // column
        public String measure;
        public String electrode;
        public String column;
        // downsample
        public String method;
        public String interval;
        public String time;
        // meta filter
        public String ar;
        public String gender;
        public String ageLower;
        public String ageUpper;
    }

    @RequestMapping("api/export/export")
    @ResponseBody
    public void export(@RequestBody(required = true) ExportRequest request, Model model) throws IOException {
        PatientExample pe = new PatientExample();
        PatientExample.Criteria pec = pe.createCriteria();
        if (request.ageLower != null && !request.ageLower.isEmpty()) {
            pec.andAgeGreaterThan(Byte.valueOf(request.ageLower));
        }
        if (request.ageUpper != null && !request.ageUpper.isEmpty()) {
            pec.andAgeLessThanOrEqualTo(Byte.valueOf(request.ageUpper));
        }
        if (request.gender != null && !request.gender.isEmpty()) {
            pec.andFemaleEqualTo(request.gender.toUpperCase().equals("F"));
        }
        List<String> patientIDs = extractPid(patientDao.selectByCustom(pe));
        patientIDs.retainAll(importedFileDao.getAllImportedPid(uuid));

        System.out.println(patientIDs);
        System.out.println(request.interval + "====" + request.time + "======" + request.method);
        analysisService.exportFromPatientsWithDownsampling(patientIDs, request.column, request.method, request.interval, request.time);
    }

    /**
     * TODO: Mybatis support for ONLY SELECT PID?
     * Extract only PID from 'Patient' object
     */
    private List<String> extractPid(List<Patient> p) {
        if (p == null)
            return new ArrayList<>(0);
        List<String> res = new ArrayList<>(p.size());
        for (Patient ap : p) {
            res.add(ap.getId());
        }
        return res;
    }

}
