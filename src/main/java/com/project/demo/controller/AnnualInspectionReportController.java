package com.project.demo.controller;

import com.project.demo.entity.AnnualInspectionReport;
import com.project.demo.service.AnnualInspectionReportService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * 年检报告：(AnnualInspectionReport)表控制层
 *
 */
@RestController
@RequestMapping("/annual_inspection_report")
public class AnnualInspectionReportController extends BaseController<AnnualInspectionReport, AnnualInspectionReportService> {

    /**
     * 年检报告对象
     */
    @Autowired
    public AnnualInspectionReportController(AnnualInspectionReportService service) {
        setService(service);
    }



    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }


}
