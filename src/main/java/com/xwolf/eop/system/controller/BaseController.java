package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.Result;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-11 15:58
 * @since V1.0.0
 */
public class BaseController {


    public JSONObject error(String code){
        Result result=new Result();
        result.setSuccess(false);
        result.setRestCode(code);
        result.setRestMsg(StatusCodeEnum.getMsg(code));
        return JSONObject.parseObject(JSON.toJSONString(result));
    }
}
