package com.xwolf.eop.common.pojo.datatables;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @author xwolf
 * @date 2016-12-20 17:58
 * @since V1.0.0
 */
@Data
public class PageResult {

    private  long draw;
    private long recordsTotal;//总记录数
    private long recordsFiltered;//过滤后的记录数
    private JSONArray data;//json数组类型
}
