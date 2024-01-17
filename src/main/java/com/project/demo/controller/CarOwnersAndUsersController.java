package com.project.demo.controller;

import com.project.demo.entity.CarOwnersAndUsers;
import com.project.demo.service.CarOwnersAndUsersService;
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
 * 车主用户：(CarOwnersAndUsers)表控制层
 *
 */
@RestController
@RequestMapping("/car_owners_and_users")
public class CarOwnersAndUsersController extends BaseController<CarOwnersAndUsers, CarOwnersAndUsersService> {

    /**
     * 车主用户对象
     */
    @Autowired
    public CarOwnersAndUsersController(CarOwnersAndUsersService service) {
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
