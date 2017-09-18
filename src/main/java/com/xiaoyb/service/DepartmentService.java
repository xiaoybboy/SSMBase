package com.xiaoyb.service;

import com.xiaoyb.dao.DepartmentMapper;
import com.xiaoyb.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
