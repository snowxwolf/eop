package com.xwolf.eop.system.controller;

import com.xwolf.eop.system.service.IPermissionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Controller
@RequestMapping("/permissions")
public class PermissionsController {

    private static Logger LOG= LoggerFactory.getLogger(PermissionsController.class);

    @Autowired
    private IPermissionsService permissionsService;

}
