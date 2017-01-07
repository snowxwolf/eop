package com.xwolf.eop.common.pojo.datatables;

import com.alibaba.fastjson.JSONArray;

/**
 * @author xwolf
 * @date 2016-12-20 17:58
 * @since V1.0.0
 */
public class PageResult {

    private  long draw;
    private long recordsTotal;//总记录数
    private long recordsFiltered;//过滤后的记录数
    private JSONArray data;//json数组类型

    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data.toJSONString() +
                '}';
    }
}
