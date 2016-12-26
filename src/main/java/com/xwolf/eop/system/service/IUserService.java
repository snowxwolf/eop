package com.xwolf.eop.system.service;

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

    String login(HttpServletRequest request);

    User getUserByName(String username);
}
