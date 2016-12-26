package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.*;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
//import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 分页
 */
public class PageHelper{

    public  static PageRequest getPage (HttpServletRequest request){

        String size=request.getParameter("length");
        String start=request.getParameter("start");
        PageRequest pageRequest =new PageRequest();
        if(StringUtils.isNoneBlank(size)){
            pageRequest.setLength(Integer.valueOf(size));
        }
        pageRequest.setStart(Integer.valueOf(start));
        String draw=request.getParameter("draw");
        pageRequest.setDraw(Long.valueOf(draw));
        com.github.pagehelper.PageHelper.startPage(pageRequest.getStart(),pageRequest.getLength(),true);
        return pageRequest;
    }


    public static <T> PageResult  getListResult(List<T> list,PageRequest pageRequest){
        PageInfo page = new PageInfo(list);
        JSONArray ary = new JSONArray();
        for(T t :list){
            ary.add(t);
        }
        PageResult result=new PageResult();
        result.setRecordsFiltered(page.getTotal());
        result.setRecordsTotal(page.getTotal());
        result.setDraw(pageRequest.getDraw());
        result.setData(ary);
        return result;
    }
}
