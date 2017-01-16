package com.xwolf.eop.system.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.entity.Menus;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface IMenusService extends BaseService<Menus> {

    JSONObject getNavMenus();

    JSONArray getMenusList();

    JSONArray getParentMenus();
}
