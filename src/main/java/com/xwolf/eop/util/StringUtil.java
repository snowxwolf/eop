package com.xwolf.eop.util;

/**
 * <p>
 *     字符串处理工具类
 * </p>
 *
 * @author xwolf
 * @date 2017-01-07 12:47
 * @since V1.0.0
 */
public class StringUtil {

     private static final String UNDERLINE="_";

     /**
     * 将驼峰命名法转化为_链接的字符串
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将下划线转化为驼峰命名
     * @return
     */
    public static String underlineToCamel(String param){
        int index=param.indexOf(UNDERLINE);
        StringBuilder builder=new StringBuilder(param);
        if(index!=-1){
            char a=param.charAt(index+1);
            builder.replace(index,index+2,String.valueOf(Character.toUpperCase(a)));
            return  underlineToCamel(builder.toString());
        } else{
            return builder.toString();
        }

    }

    /**
     * 防止SQL注入
     * @param sql 原始字符串
     * @return 处理后的字符串
     */
    public static String escapeSql(String sql){
         return org.apache.commons.lang.StringEscapeUtils.escapeSql(sql);
    }


}
