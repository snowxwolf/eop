package com.xwolf.eop.common.util;

import java.util.UUID;

/**
 * @author xwolf
 * @date 2016-12-14 12:36
 * @since V1.0.0
 */
public class UUIDUtil {

    /**
     * 获取小写的UUID
     * @return
     */
    public static String  getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 获取大写UUID
     * @return
     */
    public static String  getUpperCaseUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }

}
