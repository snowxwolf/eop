package com.xwolf.eop.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xwolf
 * @date 2016-12-13 12:40
 * @since V1.0.0
 */
@Controller
public class LoginController {
    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(value = "toLogin",method = RequestMethod.POST)
    public String toLogin(){
       return "system/login";
    }
}
