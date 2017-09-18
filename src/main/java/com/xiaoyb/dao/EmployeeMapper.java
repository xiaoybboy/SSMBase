package com.xiaoyb.dao;

import com.xiaoyb.domain.Employee;

import java.util.List;

public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer empId);

    void batchDeleteEmployee(List<Integer> ids);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectAllEmp();

    Employee selectByPrimaryKey(Integer empId);

    Employee selectByPrimaryKeyWithDep(Integer empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int checkUser(String empName);
}