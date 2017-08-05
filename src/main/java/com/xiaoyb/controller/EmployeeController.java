package com.xiaoyb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyb.domain.Employee;
import com.xiaoyb.service.EmployeeService;

/**
 * 处理员工相关请求
 * 
 * @author XIAO
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/test")
	public String Test() {
		System.out.println("test");
		return "index";
	}

	/**
	 * 查询所有员工信息（分页查询）
	 * 
	 * pn:查询的是第几页，默认是第一页
	 * 
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

		// 分页查询，在查询数据之前调用startPage,传入页码和每页的数量
		PageHelper.startPage(pn, 5);
		// 紧跟着的第一个select方法会被分页
		List<Employee> employees = employeeService.getAllEmp();
		// 用PageInfo对结果进行包装
		PageInfo<Employee> page = new PageInfo<Employee>(employees);
		model.addAttribute("pageInfo", page);
		System.out.println("success");
		return "list";

	}

}
