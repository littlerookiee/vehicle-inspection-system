package com.project.demo.controller;

import com.project.demo.entity.DetectionAddress;
import com.project.demo.service.DetectionAddressService;
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
 * 检测地址：(DetectionAddress)表控制层
 *
 */
@RestController
@RequestMapping("/detection_address")
public class DetectionAddressController extends BaseController<DetectionAddress, DetectionAddressService> {

    /**
     * 检测地址对象
     */
    @Autowired
    public DetectionAddressController(DetectionAddressService service) {
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
