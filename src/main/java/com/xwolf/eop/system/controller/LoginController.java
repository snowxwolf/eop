package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xwolf.eop.system.service.IUserService;
import com.xwolf.eop.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @author xwolf
 * @date 2016-12-13 12:40
 * @since V1.0.0
 */
@Controller
@Slf4j
public class LoginController {


    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private IUserService userService;

    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(value = "toLogin",method = RequestMethod.GET)
    public String toLogin(@RequestHeader("User-Agent")String ua,HttpServletRequest request){
        log.info("userAgent:{},请求IP:{}",ua,HttpUtil.getIP(request));
       return "system/login";

    }

    /**
     * 生成验证码
     *
     * @throws Exception
     */
    @RequestMapping(value = "/checkCode", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = defaultKaptcha.createText();
        // 将验证码放入session中
        HttpUtil.setCheckCode(request,capText);
        log.info("生成的验证码为:{}",capText);
        BufferedImage bi = defaultKaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(HttpServletRequest request){
        return userService.login(request);
    }

    /**
     * 退出登陆
     * @return
     */
    @RequestMapping(value = "logout",method ={RequestMethod.POST,RequestMethod.GET})
    public String logout(HttpServletRequest request){
        HttpUtil.removeAllSessionAttr(request);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "system/login";
    }


}
