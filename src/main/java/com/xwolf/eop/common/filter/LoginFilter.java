package com.xwolf.eop.common.filter;

import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

/**
 * 登录过滤器
 * @author xwolf
 * @date 2016-12-14 22:30
 * @since V1.0.0
 */
public class LoginFilter implements Filter {
    private static final Logger log= LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        String url = request.getRequestURL().toString();
        String referer=request.getHeader("Referer");
        log.info("请求的url为:{}",url);
        boolean isPass = false;
        if (url.endsWith(".gif")||url.endsWith(".css")||url.endsWith(".jpg")||
                url.endsWith(".js")|| url.endsWith(".bmp")||url.endsWith(".png")){
            isPass=true;
        }

        if(user!=null){
            isPass=true;
        }
        //登陆，注册页面跳过
        if(url.endsWith("toLogin.htm")|| url.endsWith("toReg.htm")){
            isPass=true;
        }

        ResourceUtil resourceUtil=new ResourceUtil("system.properties");
        String domain=resourceUtil.getValue("system.web.domain");
        String[] domains=domain.split(",");
        for(String dm:domains){
            if(referer.contains(dm)){
                isPass=true;
            }
        }

        if(!isPass){
            response.sendRedirect(request.getContextPath()+"/toLogin.htm");
            log.info("用户未登陆,不能访问,为其跳转到登陆页面");
        }

        filterChain.doFilter(request, response);
    
    }

    @Override
    public void destroy() {

    }
}
