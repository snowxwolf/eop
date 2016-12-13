package com.xwolf.eop.util;

/**
 * @author xwolf
 * @date 2016-11-03 22:41
 * @since V1.0.0
 */
public class IPUtil {
    
    public static String trim(String ip){//去掉ip字符串前后所有的空格
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

    public static void main(String[] args) {
        System.out.println(isIp("23.32.s.32"));
    }
}
