package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class LoginController {

    private static final Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private IUserService userService;

    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(value = "toLogin",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String toLogin(@RequestHeader("User-Agent")String ua){
        log.info("userAgent:{}",ua);
        Page<User> page =new Page<>();
        Wrapper<User> wrapper;
        Page pages= userService.selectPage(page);
         return JSON.toJSONString(pages);

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
        request.getSession().setAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, capText);
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
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        return userService.login(user);
    }

    /**
     * 退出登陆
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public String logout(){
        /*HttpUtil.removeAllSessionAttr(request);*/
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "system/login";
    }


}
