package com.xwolf.eop.util;

/**
 * @author xwolf
 * @date 2016-12-21 13:48
 * @since V1.0.0
 */
public class HashUtil {

    /**
     * 获取字符串Hash值
     * @param str
     * @return
     */
    public static int getHash(String str){
        return Math.abs(str.hashCode());
    }

}
