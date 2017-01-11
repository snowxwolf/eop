package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * jQuery Table 分页数据封装
 * @author wolf
 * @date 2016-12-26 18:23
 * @since V1.0.0
 */
@Data
public class TableData {

    private int draw;//请求次数
    private int  recordsTotal;//总记录数
    private int start;//开始
    private int end;//结束
    private int recordsFiltered;
    private int length;//长度
    private JSONArray data;//数据封装

}
