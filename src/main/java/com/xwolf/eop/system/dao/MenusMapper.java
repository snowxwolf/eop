package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Menus;

import java.util.List;
import java.util.Map;

public interface MenusMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);

    List<Menus> getParentMenus(Map<String,Object> map);

    List<Menus> getSonMenus(Map<String,Object> map);
}