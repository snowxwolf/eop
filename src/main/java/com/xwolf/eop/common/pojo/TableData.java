package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;

/**
 * jQuery Table 分页数据封装
 * @author wolf
 * @date 2016-12-26 18:23
 * @since V1.0.0
 */
public class TableData {

    private int draw;//请求次数
    private int  recordsTotal;//总记录数
    private int start;//开始
    private int end;//结束
    private int recordsFiltered;
    private int length;//长度
    private JSONArray data;//数据封装

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }
}
