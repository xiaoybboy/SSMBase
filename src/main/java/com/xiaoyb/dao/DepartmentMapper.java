package com.xiaoyb.dao;

import java.util.List;

import com.xiaoyb.domain.Department;

public interface DepartmentMapper {
	int deleteByPrimaryKey(Integer depId);

	int insert(Department record);

	List<Department> selectAllDept();

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer depId);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);
}