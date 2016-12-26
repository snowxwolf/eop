package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;

/**
 * @author wolf
 * @date 2016-12-26 11:47
 * @since V1.0.0
 */
public class NavMenus {

    private String id;
    private String text;
    private String icon;
    private String url;
    private JSONArray menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONArray getMenus() {
        return menus;
    }

    public void setMenus(JSONArray menus) {
        this.menus = menus;
    }
}
