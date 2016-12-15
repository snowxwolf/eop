package com.xwolf.eop.system.controller;

import com.xwolf.eop.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xwolf
 * @date 2016-12-13 12:40
 * @since V1.0.0
 */
@Controller
public class LoginController {
    private static final Logger log= LoggerFactory.getLogger(LoginController.class);
    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(value = "toLogin",method = RequestMethod.GET)
    public String toLogin(@RequestHeader("User-Agent")String ua){
        log.info("userAgent:{}",ua);
       return "system/login";
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        return null;
    }


}
