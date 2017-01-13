package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @author wolf
 * @date 2016-12-26 11:47
 * @since V1.0.0
 */
@Data
public class NavMenus {

    private String id;
    private String text;
    private String icon;
    private String url;
    private JSONArray children;
}
