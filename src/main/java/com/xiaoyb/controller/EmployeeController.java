package com.xiaoyb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyb.domain.Employee;
import com.xiaoyb.domain.Msg;
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

	/**
	 * 查询所有员工信息（分页查询）
	 * 
	 * pn:查询的是第几页，默认是第一页
	 * 
	 * 导入jackson包。
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 引入PageHelper分页插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps = employeeService.getAllEmp();
		System.out.println(emps.get(0).getDepartment().getDepName());
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Employee> page = new PageInfo<Employee>(emps, 5);
		return Msg.success().add("pageInfo", page);// 把获取的所有员工以json的形式返回
	}

	/**
	 * 员工保存
	 * 
	 * 1、支持JSR303校验
	 * 
	 * 2、导入Hibernate-Validator
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/empsave", method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			// 校验失败，应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名：" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		} else {
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}

	/**
	 * 检查用户名是否可用
	 * 
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName") String empName) {
		// 先判断用户名是否是合法的表达式;
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if (!empName.matches(regx)) {
			return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}

		// 数据库用户名重复校验
		boolean b = employeeService.checkUser(empName);
		if (b) {
			return Msg.success();
		} else {
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}

	/**
	 * 根据id查询员工
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
}
