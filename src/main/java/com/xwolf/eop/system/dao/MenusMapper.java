package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Menus;

public interface MenusMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);
}