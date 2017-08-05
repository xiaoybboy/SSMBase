package com.xiaoyb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyb.dao.EmployeeMapper;
import com.xiaoyb.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	public List<Employee> getAllEmp() {
		return employeeMapper.selectAllEmp();
	}

	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	/**
	 * 检验用户名是否重复
	 * 
	 * @param empName
	 * @return true：代表当前姓名可用 fasle：不可用
	 */
	public boolean checkUser(String empName) {
		return employeeMapper.checkUser(empName) == 0;
	}

}
