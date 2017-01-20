package com.xwolf.eop.erp.controller;

import com.xwolf.eop.erp.service.IEmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *     员工管理
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:17
 * @since V1.0.0
 */
@Controller
@Slf4j
@RequestMapping("erp/employees")
public class EmployeesController {
    @Autowired
    private IEmployeesService employeesService;
}
