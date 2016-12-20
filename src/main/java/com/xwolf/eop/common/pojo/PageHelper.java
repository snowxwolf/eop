package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页
 * @param <T>
 */
public class PageHelper<T>{

    public  String  getListResult (List<T> list){
     /*   PageInfo<T> pageInfo=new PageInfo<T>(list);
        List<T> ts=pageInfo.getList();
        long total = pageInfo.getTotal();
        JSONObject row=new JSONObject();
        JSONArray ary = new JSONArray();
        for(T t :ts){
            ary.add(t);
        }
        row.put("rows",ary);
        row.put("total",total);
        String json = row.toJSONString();
        return json;*/
     return null;
    }
}
