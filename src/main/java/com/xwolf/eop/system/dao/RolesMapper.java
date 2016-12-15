package com.xwolf.eop.system.dao;

import com.xwolf.eop.system.entity.Roles;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}