package com.xwolf.eop.system.controller;

import com.xwolf.eop.system.service.IUserService;
import com.xwolf.eop.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xwolf
 * @date 2016-12-20 17:41
 * @since V1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 查看用户列表
     * @param request
     * @return
     */
    @RequestMapping("listUser")
    @ResponseBody
    public String list(HttpServletRequest request){
      String ip= IPUtil.getIp(request);
       log.info("ip:{}",ip);
      return null;

    }
}
