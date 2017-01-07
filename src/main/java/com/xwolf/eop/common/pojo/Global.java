package com.xwolf.eop.common.pojo;

import com.google.common.collect.Maps;
import com.xwolf.eop.common.enums.ConfigEnum;
import com.xwolf.eop.common.enums.SystemConfigEnum;
import com.xwolf.eop.util.ResourceUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局
 * @author xwolf
 * @date 2016-12-17 06:58
 * @since V1.0.0
 */
public class Global {

    private static  ResourceUtil resourceUtil;

    static{
        resourceUtil=new ResourceUtil(ConfigEnum.SYSTEM.getName());
    }

    public static final String DEFAULT_ENCODING=resourceUtil.getValue(SystemConfigEnum.ENCODING_DEFAULT.getProperty());

    public static final boolean ENABLE_TOKEN=resourceUtil.getBooleanValue(SystemConfigEnum.WEB_TOKEN.getProperty());

    public static final boolean ENABLE_REFERER=resourceUtil.getBooleanValue(SystemConfigEnum.WEB_REFERER.getProperty());




}
