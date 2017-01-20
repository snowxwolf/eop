package com.xwolf.eop.erp.service.impl;

import com.xwolf.eop.erp.dao.EmployeesMapper;
import com.xwolf.eop.erp.entity.Employees;
import com.xwolf.eop.erp.service.IEmployeesService;
import com.xwolf.eop.system.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:14
 * @since V1.0.0
 */
@Service
@Slf4j
public class EmployeesServiceImpl extends BaseServiceImpl<Employees> implements IEmployeesService {
    @Autowired
    private EmployeesMapper employeesMapper;
}
