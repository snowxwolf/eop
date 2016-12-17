package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.Result;
import com.xwolf.eop.system.service.BaseService;

import java.util.List;

/**
 * @author xwolf
 * @date 2016-12-15 14:44
 * @since V1.0.0
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    public String success(){
        Result result=new Result();
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestCode(StatusCodeEnum.SUCCESS.getMsg());
        return JSON.toJSONString(result);
    }

    public String success(JSONObject json){
        Result result=new Result();
        result.setData(json.toJSONString());
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestCode(StatusCodeEnum.SUCCESS.getMsg());
        return JSON.toJSONString(result);
    }


    @Override
    public String insert(JSONObject json) {
        return null;
    }

    @Override
    public String update(JSONObject json) {
        return null;
    }

    @Override
    public String delete(JSONObject json) {
        return null;
    }

    @Override
    public T queryForObject(JSONObject json) {
        return null;
    }

    @Override
    public List<T> queryForList(JSONObject json) {
        return null;
    }

    @Override
    public String insert(T t) {
        return null;
    }

    @Override
    public String update(T t) {
        return null;
    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public T queryForObject(String key) {
        return null;
    }

    @Override
    public T queryForObject(T t) {
        return null;
    }
}
