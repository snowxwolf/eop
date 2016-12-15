package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Codes;

public interface CodesMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Codes record);

    int insertSelective(Codes record);

    Codes selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Codes record);

    int updateByPrimaryKey(Codes record);
}