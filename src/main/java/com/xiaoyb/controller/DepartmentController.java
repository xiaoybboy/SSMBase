package com.xiaoyb.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
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

	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
		List<Department> departments = departmentservice.getDepts();
		return Msg.success().add("depts", departments);
	}

}
