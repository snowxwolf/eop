package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.Result;
import com.xwolf.eop.system.service.BaseService;

import java.util.List;

/**
 * @author xwolf
 * @date 2016-12-20 16:42
 * @since V1.0.0
 */
public class BaseServiceImpl<T> implements BaseService<T>  {

    public String success(){
        Result result=new Result();
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestMsg(StatusCodeEnum.SUCCESS.getMsg());
        result.setSuccess(true);
        return JSON.toJSONString(result);
    }

    public String success(String data){
        Result result=new Result();
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestMsg(StatusCodeEnum.SUCCESS.getMsg());
        result.setSuccess(true);
        result.setData(data);
        return JSON.toJSONString(result);
    }

    public String error(String code){
        Result result=new Result();
        result.setSuccess(false);
        result.setRestCode(code);
        return JSON.toJSONString(result);
    }

    @Override
    public String insert(JSONObject json) {
        return null;
    }

    @Override
    public String insertBatch(JSONObject json) {
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
    public String queryForObject(JSONObject json) {
        return null;
    }

    @Override
    public List<T> queryForList(JSONObject json) {
        return null;
    }

    @Override
    public String selectForList(JSONObject json) {
        return null;
    }
}
