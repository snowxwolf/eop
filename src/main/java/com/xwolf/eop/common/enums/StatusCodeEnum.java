package com.xwolf.eop.common.enums;

/**
 * 结果返回状态码
 * @author xwolf
 * @date 2016-12-15 14:56
 * @since V1.0.0
 */
public enum  StatusCodeEnum {

    SUCCESS("00000","成功"),
    PARAM_ERROR("10000","参数错误"),
    AUTH_ERROR("10001","认证失败"),
    USER_NOT_EXISTS_ERROR("10002","用户不存在"),
    PASSWD_ERROR("10003","密码"),
    SYSTEM_ERROR("10005","系统错误"),
    NOT_FOUND_ERROR("10006","资源没有找到"),
    VALIDATE_ERROR("10007","参数错误致Bean验证失败"),
    UNKNOWN_ERROR("10010","未知错误");

    private String code;
    private String msg;

    StatusCodeEnum(String code,String msg){
     this.code=code;
     this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(String code){
        StatusCodeEnum[] enums= StatusCodeEnum.values();
        for(StatusCodeEnum statusCodeEnum:enums){
                  String ecode=statusCodeEnum.getCode();
                  if(ecode.equals(code)){
                   return statusCodeEnum.getMsg();
                  }
        }
        return "未知异常";
    }
}
