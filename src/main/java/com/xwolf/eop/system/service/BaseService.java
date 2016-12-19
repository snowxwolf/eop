package com.xwolf.eop.system.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author xwolf
 * @date 2016-12-15 14:43
 * @since V1.0.0
 */
public interface BaseService<T>{

    String insert(JSONObject json);

    String update(JSONObject json);

    String delete(JSONObject json);

    T queryForObject(JSONObject json);

    List<T> queryForList(JSONObject json);

    String insert(T t);

    String update(T t);

    String delete(String key);

    T queryForObject(String key);

    T queryForObject(T t);

    String queryPageList(List<T> list);


}
