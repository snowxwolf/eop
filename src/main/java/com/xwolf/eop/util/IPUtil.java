package com.xwolf.eop.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xwolf
 * @date 2016-11-03 22:41
 * @since V1.0.0
 */
public class IPUtil {
    
    private static String trim(String ip){//去掉ip字符串前后所有的空格
        while(ip.startsWith(" ")){
            ip= ip.substring(1,ip.length()).trim();
        }
        while(ip.endsWith(" ")){
            ip= ip.substring(0,ip.length()-1).trim();
        }
        return ip;
    }

    //判断是否是一个ip
    public  static boolean isIp(String ip){
        boolean b = false;
        ip = trim(ip);
        if(ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")){
            String s[] = ip.split("\\.");
            if(Integer.parseInt(s[0])<255)
                if(Integer.parseInt(s[1])<255)
                    if(Integer.parseInt(s[2])<255)
                        if(Integer.parseInt(s[3])<255)
                            b = true;
        }
        return b;
    }

    /**
     * 获取请求IP
     * @param request
     * @return IP地址
     * @throws Exception
     */
    public static String getIp(HttpServletRequest request) throws Exception{
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
           // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }


}
