package com.xwolf.eop.erp.dao;

import com.xwolf.eop.erp.entity.Jobs;

public interface JobsMapper {
    int deleteByPrimaryKey(Integer jid);

    int insert(Jobs record);

    int insertSelective(Jobs record);

    Jobs selectByPrimaryKey(Integer jid);

    int updateByPrimaryKeySelective(Jobs record);

    int updateByPrimaryKey(Jobs record);
}