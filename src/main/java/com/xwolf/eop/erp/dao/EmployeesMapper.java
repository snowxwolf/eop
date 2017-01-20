package com.xwolf.eop.erp.dao;

import com.xwolf.eop.erp.entity.Employees;

public interface EmployeesMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}