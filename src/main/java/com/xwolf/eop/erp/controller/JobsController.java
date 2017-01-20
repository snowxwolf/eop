package com.xwolf.eop.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.erp.entity.Jobs;
import com.xwolf.eop.erp.service.IJobsService;
import com.xwolf.eop.system.controller.BaseController;
import com.xwolf.eop.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 *     职位管理
 * </p>
 *
 * @author xwolf
 * @date 2017-01-20 17:10
 * @since V1.0.0
 */
@Controller
@Slf4j
@RequestMapping(value = "erp/jobs")
public class JobsController extends BaseController {

    @Autowired
    private IJobsService jobsService;
    // @RequiresPermissions({"erp:job"})
    @RequestMapping(value = "toJobs",method = {RequestMethod.GET,RequestMethod.POST})
    public  String toUser(){
        return "erp/jobs";
    }
    /**
     * 查看职位列表
     * @param request
     * @return
     */
    //@RequiresPermissions({"erp:job:list"})
    @RequestMapping(value = "listJobs",method = RequestMethod.POST)
    @ResponseBody
    public PageResult list(HttpServletRequest request){
        String ip= IPUtil.getIp(request);
        log.info("ip:{}",ip);
        PageResult result=jobsService.getJobsList(request);
        return result;
    }

    /**
     * 添加
     * @param job
     * @return
     */
    //@RequiresPermissions({"erp:job:add"})
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody
    JSONObject add(@Valid Jobs job, BindingResult bindingResult){
        log.info("job:{}",job);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=jobsService.insert(job);
        return result;
    }

    /**
     * 修改
     * @param job
     * @return
     */
    //@RequiresPermissions({"erp:job:update"})
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(@Valid Jobs job, BindingResult bindingResult){
        log.info("menus:{}",job);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=jobsService.update(job);
        return result;
    }

    /**
     * 删除
     * @param request
     * @return
     */
    //@RequiresPermissions({"erp:job:delete"})
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(HttpServletRequest request){
        JSONObject result=jobsService.deleteBatch(request);
        return result;
    }
}
