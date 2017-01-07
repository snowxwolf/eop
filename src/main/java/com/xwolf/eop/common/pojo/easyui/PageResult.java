package com.xwolf.eop.common.pojo.easyui;

import com.alibaba.fastjson.JSONArray;

/**
 * <p>
 *     easyui 结果集封装
 * </p>
 *
 * @author xwolf
 * @date 2017-01-06 18:08
 * @since V1.0.0
 */
public class PageResult {

    private long total; //总页数
    private JSONArray rows;//数据封装

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public JSONArray getRows() {
        return rows;
    }

    public void setRows(JSONArray rows) {
        this.rows = rows;
    }
}
