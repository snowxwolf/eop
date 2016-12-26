package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Codes;

import java.util.List;
import java.util.Map;

public interface CodesMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Codes record);

    int insertSelective(Codes record);

    Codes selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Codes record);

    int updateByPrimaryKey(Codes record);

    List<Codes> selectCodesList(Map<String, Object> map);
}