package com.xwolf.eop.system.controller;

import com.xwolf.eop.common.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基础码表
 * @author xwolf
 * @date 2016-12-15 14:25
 * @since V1.0.0
 */
@Controller
@RequestMapping("system/codes")
public class CodesController {

    private static final Logger log= LoggerFactory.getLogger(CodesController.class);

    /**
     * 到用户管理页面
     * @return
     */
    @RequestMapping(value = "toCodes",method = RequestMethod.GET)
    public ModelAndView toCodes(){
     return new ModelAndView("system/code");
    }
}
