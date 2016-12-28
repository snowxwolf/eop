package com.xwolf.eop.common.enums;

/**
 * 系统配置
 * @author xwolf
 * @date 2016-12-17 07:09
 * @since V1.0.0
 */
public enum SystemConfigEnum {

    WEB_TOKEN("system.web.token"),
    WEB_DOMAIN("system.web.domain"),
    WEB_REFERER("system.web.referer"),

    ENCODING_DEFAULT("system.encoding.default"),
    ENCODING_UTF8("system.encoding.utf8"),
    ENCODING_GBK("system.encoding.gbk"),
    ENCODING_ISO("system.encoding.iso"),

    CODE_SUCCESS("system.code.success"),
    CODE_PARAM_ERROR("system.code.paramError"),
    CODE_AUTH_ERROR("system.code.authError"),
    CODE_USER_NOT_EXIST_ERROR("system.code.userNotExist"),
    CODE_PASSWD_ERROR("system.code.passwordError"),
    CODE_SYSTEM_ERROR("system.code.systemError"),
    CODE_NOT_FOUND_ERROR("system.code.notFound"),
    CODE_UNKNOWN_ERROR("system.code.unkownError");

    private String property;
    SystemConfigEnum(String property){
        this.property=property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
