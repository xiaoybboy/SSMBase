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

}
