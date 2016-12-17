package com.xwolf.eop.common.enums;

/**
 * @author xwolf
 * @date 2016-12-17 07:06
 * @since V1.0.0
 */
public enum  ConfigEnum {

    SYSTEM("system.properties");

    private String name;
    ConfigEnum(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
