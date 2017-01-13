package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.BlackList;

public interface BlackListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlackList record);

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlackList record);

    int updateByPrimaryKey(BlackList record);
}