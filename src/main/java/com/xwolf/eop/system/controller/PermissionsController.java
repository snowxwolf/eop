package com.xwolf.eop.system.controller;

import com.xwolf.eop.system.service.IPermissionsService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private IPermissionsService permissionsService;

}
