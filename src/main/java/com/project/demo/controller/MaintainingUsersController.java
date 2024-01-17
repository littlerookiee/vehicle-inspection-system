package com.project.demo.controller;

import com.project.demo.entity.MaintainingUsers;
import com.project.demo.service.MaintainingUsersService;
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
 * 维护用户：(MaintainingUsers)表控制层
 *
 */
@RestController
@RequestMapping("/maintaining_users")
public class MaintainingUsersController extends BaseController<MaintainingUsers, MaintainingUsersService> {

    /**
     * 维护用户对象
     */
    @Autowired
    public MaintainingUsersController(MaintainingUsersService service) {
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
