package com.project.demo.controller;

import com.project.demo.entity.AnnualInspectionAppointment;
import com.project.demo.service.AnnualInspectionAppointmentService;
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
 * 年检预约：(AnnualInspectionAppointment)表控制层
 *
 */
@RestController
@RequestMapping("/annual_inspection_appointment")
public class AnnualInspectionAppointmentController extends BaseController<AnnualInspectionAppointment, AnnualInspectionAppointmentService> {

    /**
     * 年检预约对象
     */
    @Autowired
    public AnnualInspectionAppointmentController(AnnualInspectionAppointmentService service) {
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
