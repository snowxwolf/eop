package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.service.IUserService;
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
 * @author xwolf
 * @date 2016-12-20 17:41
 * @since V1.0.0
 */
@Slf4j
@Controller
@RequestMapping("system/user")
public class UserController extends BaseController {


    @Autowired
    private IUserService userService;

   // @RequiresPermissions({"system:user"})
    @RequestMapping(value = "toUser",method = {RequestMethod.GET,RequestMethod.POST})
    public  String toUser(){
        return "system/user";
    }
    /**
     * 查看用户列表
     * @param request
     * @return
     */
    //@RequiresPermissions({"system:user:list"})
    @RequestMapping(value = "listUser",method = RequestMethod.POST)
    @ResponseBody
    public PageResult list(HttpServletRequest request){
      String ip= IPUtil.getIp(request);
       log.info("ip:{}",ip);
        PageResult result=userService.getUserList(request);
      return result;
    }

    /**
     * 添加
     * @param user
     * @return
     */
    //@RequiresPermissions({"system:user:add"})
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody
    JSONObject add(@Valid User user, BindingResult bindingResult){
        log.info("user:{}",user);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=userService.insert(user);
        return result;
    }

    /**
     * 修改
     * @param user
     * @return
     */
    //@RequiresPermissions({"system:user:update"})
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(@Valid User user,BindingResult bindingResult){
        log.info("menus:{}",user);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=userService.update(user);
        return result;
    }

    /**
     * 删除
     * @param request
     * @return
     */
    //@RequiresPermissions({"system:user:delete"})
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(HttpServletRequest request){
        JSONObject result=userService.deleteBatch(request);
        return result;
    }
}
