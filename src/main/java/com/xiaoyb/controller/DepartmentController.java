package com.xiaoyb.controller;

import com.xiaoyb.domain.Department;
import com.xiaoyb.domain.Msg;
import com.xiaoyb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理部门相关的请求
 *
 * @author XIAO
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentservice;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts() {
        List<Department> departments = departmentservice.getDepts();
        return Msg.success().add("depts", departments);
    }

}
