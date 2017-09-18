package com.xiaoyb.service;

import com.xiaoyb.dao.SystemLogMapper;
import com.xiaoyb.domain.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 系统日志插入service
 *
 * @author XIAO
 * @since 2017-09-18 14:56
 **/
public class SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    public int deleteSystemLog(String id) {

        return systemLogMapper.deleteByPrimaryKey(id);
    }

    public int insert(SystemLog record) {

        return systemLogMapper.insertSelective(record);
    }

    public SystemLog selectSystemLog(String id) {

        return systemLogMapper.selectByPrimaryKey(id);
    }

    public int updateSystemLog(SystemLog record) {

        return systemLogMapper.updateByPrimaryKeySelective(record);
    }

    public int insertTest(SystemLog record) {

        return systemLogMapper.insert(record);
    }
}
