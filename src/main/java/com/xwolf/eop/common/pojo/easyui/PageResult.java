package com.xwolf.eop.common.pojo.easyui;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * <p>
 *     easyui 结果集封装
 * </p>
 *
 * @author xwolf
 * @date 2017-01-06 18:08
 * @since V1.0.0
 */
@Data
public class PageResult {

    private long total; //总页数
    private JSONArray rows;//数据封装

}
