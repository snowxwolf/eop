package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}