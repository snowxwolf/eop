package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.MenuPermission;

public interface MenuPermissionMapper {

    int deleteByPrimaryKey(Integer rid);

    int insert(MenuPermission record);

    int insertSelective(MenuPermission record);

    MenuPermission selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(MenuPermission record);

    int updateByPrimaryKey(MenuPermission record);
}