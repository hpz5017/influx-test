package edu.pitt.medschool.controller.analysis;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pitt.medschool.config.InfluxappConfig;
import edu.pitt.medschool.framework.rest.RestfulResponse;
import edu.pitt.medschool.service.PerformanceTest;
import edu.pitt.medschool.service.UseCaseService;

@RestController
public class UseCaseController {

    @Autowired
    UseCaseService useCaseService;
    @Autowired
    PerformanceTest performanceTest;

    @GetMapping("api/use/case/2")
    @ResponseBody
    public RestfulResponse caseTwo() throws IOException {
        RestfulResponse response = new RestfulResponse(1, "Finished");
        String msg = useCaseService.useCaseTwo();
        response.setData(msg);
        return response;
    }

    @GetMapping("api/use/case/akoglu")
    @ResponseBody
    public RestfulResponse caseAkoglu() throws IOException {
        RestfulResponse response = new RestfulResponse(1, "Finished");
        String msg = useCaseService.useCaseAkoglu();
        response.setData(msg);
        return response;
    }

    @GetMapping("api/use/case/cmu")
    @ResponseBody
    public RestfulResponse caseCMU() throws IOException {
        RestfulResponse response = new RestfulResponse(1, "Finished");
        String msg = useCaseService.useCaseCMU();
        response.setData(msg);
        return response;
    }

    @GetMapping("api/performanceTest")
    @ResponseBody
    public RestfulResponse performanceTest() throws IOException {
        RestfulResponse response = new RestfulResponse(1, "Finished");
        performanceTest.multithreadTest((int) (InfluxappConfig.AvailableCores * 0.6));
        for (int i = (int) (InfluxappConfig.AvailableCores * 0.8); i >= 1; i--) {
        }
        return response;
    }

}
