package com.xwolf.eop.system.enums;

/**
 * 用户状态
 * @author xwolf
 * @date 2016-12-14 12:28
 * @since V1.0.0
 */
public enum  UserStatusEnums {

    ABLED("1","正常"),
    DISABLED("0","用户禁用"),
    LOCKED("2","用户锁定"),
    DELETE("3","删除");

    private String code;
    private String desc;
    UserStatusEnums(String code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
