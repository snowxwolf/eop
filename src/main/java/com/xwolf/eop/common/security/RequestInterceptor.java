package com.xwolf.eop.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wolf
 * @date 2016-12-27 20:06
 * @since V1.0.0
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private Logger LOG= LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String method=request.getMethod();
        String url = request.getRequestURL().toString();
        String referer=request.getHeader("Referer");
        LOG.info("请求的url为:{},请求头referer:{},拦截方法:{}",url,referer,method);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        LOG.info("postHandle。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LOG.info("afterCompletion。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
