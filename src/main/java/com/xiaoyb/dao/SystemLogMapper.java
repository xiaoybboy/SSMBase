package com.xiaoyb.dao;

import com.xiaoyb.domain.SystemLog;

/**
 * @author XIAO
 * @since 2017-09-18 14:53
 **/
public interface SystemLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}
