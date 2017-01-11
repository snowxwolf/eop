package com.xwolf.eop.system.controller;

import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.service.IUserService;
import com.xwolf.eop.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xwolf
 * @date 2016-12-20 17:41
 * @since V1.0.0
 */
@Slf4j
@Controller
@RequestMapping("system/user")
public class UserController {


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
}
