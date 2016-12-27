package com.xwolf.eop.system.service;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface IUserService extends BaseService<User> {

    JSONObject login(HttpServletRequest request);

    User getUserByName(String username);
}
