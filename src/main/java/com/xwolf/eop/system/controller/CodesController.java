package com.xwolf.eop.system.controller;

import com.xwolf.eop.common.pojo.PageResult;
import com.xwolf.eop.system.service.ICodesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private ICodesService codesService;
    /**
     * 到用户管理页面
     * @return
     */

    @RequiresPermissions({"system:codes"})
    @RequestMapping(value = "toCodes",method = RequestMethod.GET)
    public ModelAndView toCodes(@RequestHeader("User-Agent")String ua){
        log.info("UserAgent:{}",ua);
     return new ModelAndView("system/codes");
    }

    @RequiresPermissions({"system:codes:list"})
    @RequestMapping(value = "listCodes",method = RequestMethod.POST)
    public  @ResponseBody PageResult  listCodes(HttpServletRequest request){
        PageResult json=codesService.selectCodesList(request);
        log.info("码表列表:{}",json);
        return json;
    }
}
