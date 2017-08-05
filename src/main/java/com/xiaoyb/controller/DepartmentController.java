package com.xiaoyb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoyb.domain.Department;
import com.xiaoyb.domain.Msg;
import com.xiaoyb.service.DepartmentService;

/**
 * 处理部门相关的请求
 * 
 * @author XIAO
 *
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentservice;

	@RequestMapping("/test2")
	public String Test() {
		System.out.println("test2");
		return "index";
	}

	@RequestMapping("/depts")
	public Msg getDepts() {
		System.out.println("test");
		List<Department> departments = departmentservice.getDepts();
		return Msg.success().add("depts", departments);
	}

}
