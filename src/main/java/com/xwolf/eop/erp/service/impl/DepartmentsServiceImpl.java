package com.xwolf.eop.erp.service.impl;

import com.xwolf.eop.erp.dao.DepartmentsMapper;
import com.xwolf.eop.erp.entity.Departments;
import com.xwolf.eop.erp.service.IDepartmentsService;
import com.xwolf.eop.system.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:12
 * @since V1.0.0
 */
@Service
@Slf4j
public class DepartmentsServiceImpl extends BaseServiceImpl<Departments> implements IDepartmentsService {
    @Autowired
    private DepartmentsMapper departmentsMapper;
}
