package com.xiaoyb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyb.dao.DepartmentMapper;
import com.xiaoyb.domain.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	/**
	 * 查询所有的部门
	 * 
	 * @return
	 */
	public List<Department> getDepts() {
		return departmentMapper.selectAllDept();
	}

}
