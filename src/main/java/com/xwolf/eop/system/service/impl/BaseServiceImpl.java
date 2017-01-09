package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.Result;
import com.xwolf.eop.system.service.BaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xwolf
 * @date 2016-12-20 16:42
 * @since V1.0.0
 */
public class BaseServiceImpl<T> implements BaseService<T>  {

    public JSONObject success(){
        Result result=new Result();
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestMsg(StatusCodeEnum.SUCCESS.getMsg());
        result.setSuccess(true);
       return JSONObject.parseObject(JSON.toJSONString(result));
    }

    public JSONObject success(String data){
        Result result=new Result();
        result.setRestCode(StatusCodeEnum.SUCCESS.getCode());
        result.setRestMsg(StatusCodeEnum.SUCCESS.getMsg());
        result.setSuccess(true);
        result.setData(data);
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    public JSONObject error(String code){
        Result result=new Result();
        result.setSuccess(false);
        result.setRestCode(code);
        result.setRestMsg(StatusCodeEnum.getMsg(code));
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    public JSONObject systemError(){
        Result result=new Result();
        result.setSuccess(false);
        result.setRestCode(StatusCodeEnum.SYSTEM_ERROR.getCode());
        result.setRestMsg(StatusCodeEnum.SYSTEM_ERROR.getMsg());
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    public JSONObject unkownError(){
        Result result=new Result();
        result.setSuccess(false);
        result.setRestCode(StatusCodeEnum.UNKNOWN_ERROR.getCode());
        result.setRestMsg(StatusCodeEnum.UNKNOWN_ERROR.getMsg());
        return JSONObject.parseObject(JSON.toJSONString(result));
    }


    @Override
    public JSONObject insert(T t) {
        return null;
    }

    @Override
    public JSONObject insertBatch(T t) {
        return null;
    }

    @Override
    public JSONObject update(T t) {
        return null;
    }

    @Override
    public JSONObject delete(T t) {
        return null;
    }

    @Override
    public T queryForObject(T t) {
        return null;
    }

    @Override
    public List<T> queryForList(T t) {
        return null;
    }

    @Override
    public String selectForList(T t) {
        return null;
    }

    @Override
    public JSONObject deleteBatch(HttpServletRequest request) {
        return null;
    }
}
