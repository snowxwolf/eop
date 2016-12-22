package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Permissions;

public interface PermissionsMapper {

    int deleteByPrimaryKey(Integer pid);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}