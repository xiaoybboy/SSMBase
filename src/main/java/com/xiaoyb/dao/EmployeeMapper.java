package com.xiaoyb.dao;

import java.util.List;

import com.xiaoyb.domain.Employee;

public interface EmployeeMapper {

	int deleteByPrimaryKey(Integer empId);

	int insert(Employee record);

	int insertSelective(Employee record);

	List<Employee> selectAllEmp();

	Employee selectByPrimaryKey(Integer empId);

	Employee selectByPrimaryKeyWithDep(Integer empId);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);

	int checkUser(String empName);
}