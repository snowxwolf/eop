package com.xwolf.eop.common.pojo;

/**
 * 返回结果实体
 * @author xwolf
 * @date 2016-12-15 14:50
 * @since V1.0.0
 */
public class Result {

    private boolean success;
    private String restMsg;
    private String restCode;
    private String data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRestMsg() {
        return restMsg;
    }

    public void setRestMsg(String restMsg) {
        this.restMsg = restMsg;
    }

    public String getRestCode() {
        return restCode;
    }

    public void setRestCode(String restCode) {
        this.restCode = restCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
