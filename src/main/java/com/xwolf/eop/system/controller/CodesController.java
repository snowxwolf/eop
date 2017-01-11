package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.entity.Codes;
import com.xwolf.eop.system.service.ICodesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Slf4j
@Controller
@RequestMapping("system/codes")
public class CodesController {

    @Autowired
    private ICodesService codesService;
    /**
     * 到用户管理页面
     * @return
     */
    @RequiresPermissions({"system:codes"})
    @RequestMapping(value = "toCodes",method = {RequestMethod.GET,RequestMethod.POST})
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

    /**
     * 增加码表
     * @param codes
     * @return
     */
    @RequiresPermissions({"system:codes:add"})
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody JSONObject add(Codes codes){
        log.info("codes: {}",codes);
        JSONObject result=codesService.insert(codes);
        return result;
    }

    /**
     * 修改码表
     * @param codes
     * @return
     */
    @RequiresPermissions({"system:codes:update"})
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(Codes codes){
        log.info("codes: {}",codes);
        JSONObject result=codesService.update(codes);
        return result;
    }

    /**
     * 删除码表
     * @param request
     * @return
     */
    @RequiresPermissions({"system:codes:delete"})
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(HttpServletRequest request){
        JSONObject result=codesService.deleteBatch(request);
        return result;
    }
}
