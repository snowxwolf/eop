package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Citys;

public interface CitysMapper {

    int deleteByPrimaryKey(Integer cid);

    int insert(Citys record);

    int insertSelective(Citys record);

    Citys selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Citys record);

    int updateByPrimaryKey(Citys record);
}