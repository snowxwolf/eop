package com.xwolf.eop.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import java.security.Principal;

/**
 * 拦截所有POST请求
 * @author wolf
 * @date 2016-12-27 19:54
 * @since V1.0.0
 */
public class PostInterceptor implements WebRequestInterceptor {

    private Logger LOG= LoggerFactory.getLogger(PostInterceptor.class);

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        Principal principal=webRequest.getUserPrincipal();
        String name=principal.getName();
        LOG.info("principal name:{}",name);
    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
