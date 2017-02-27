package com.xwolf.eop.common.pojo;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.*;
import com.xwolf.eop.common.pojo.easyui.PageRequest;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 分页
 */
public class PageHelper{

    public  static PageRequest getPage (HttpServletRequest request){

        String size=request.getParameter("rows");
        String start=request.getParameter("page");
        PageRequest pageRequest =new PageRequest();
        int s=pageRequest.getRows();
        if(StringUtils.isNoneBlank(size)){
            s=Integer.valueOf(size);
            pageRequest.setRows(s);
        }
        int ps=pageRequest.getPage();
        if(StringUtils.isNoneBlank(start)){
            ps=Integer.valueOf(start);
            pageRequest.setPage(ps);
        }
        int p=pageRequest.getPage();
        int st=(p-1)*s;
        com.github.pagehelper.PageHelper.startPage(st,pageRequest.getRows(),true);
        return pageRequest;
    }


    public static <T> PageResult getListResult(List<T> list){
        PageInfo page = new PageInfo(list);
        JSONArray ary = new JSONArray();
        for(T t :list){
            ary.add(t);
        }
        PageResult result=new PageResult();
        int size=list.size();
        result.setTotal(0);
        if ( size != 0){
            result.setTotal(page.getTotal());
        }
        result.setRows(ary);
        return result;
    }
}
