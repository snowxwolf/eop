package com.xwolf.eop.erp.pojo.charts;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xwolf
 * @date 2016-12-15 14:39
 * @since V1.0.0
 */
public class Line {

    private String title;

    private String subTitle;

    private JSONObject data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
