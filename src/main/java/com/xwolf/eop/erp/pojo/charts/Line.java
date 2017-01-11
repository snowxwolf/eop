package com.xwolf.eop.erp.pojo.charts;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author xwolf
 * @date 2016-12-15 14:39
 * @since V1.0.0
 */
@Data
public class Line {

    private String title;

    private String subTitle;

    private JSONObject data;

}
