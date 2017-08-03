package com.xiaoyb.dao;

import com.xiaoyb.domain.Employee;

public interface EmployeeMapper {

	int deleteByPrimaryKey(Integer empId);

	int insert(Employee record);

	int insertSelective(Employee record);

	Employee selectByPrimaryKey(Integer empId);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);
}