package com.xiaoyb.service;

import com.xiaoyb.dao.EmployeeMapper;
import com.xiaoyb.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据员工id查询员工
     *
     * @param id
     * @return
     */
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 批量删除员工
     *
     * @param del_ids
     */
    public void deleteBatch(List<Integer> del_ids) {
        employeeMapper.batchDeleteEmployee(del_ids);
    }

    /**
     * 删除单个员工
     *
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

}
