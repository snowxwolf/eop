package com.xwolf.eop.system.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xwolf
 * @date 2016-12-20 16:44
 * @since V1.0.0
 */
public interface BaseService<T> {

    JSONObject insert(T t);

    JSONObject insertBatch(T t);

    JSONObject update(T t);

    JSONObject delete(T t);

    T queryForObject(T t);

    List<T> queryForList(T t);

    String selectForList(T t);



    JSONObject deleteBatch(HttpServletRequest request);
}
