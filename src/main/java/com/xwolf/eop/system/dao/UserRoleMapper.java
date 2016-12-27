package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.UserRole;

public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer rid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}