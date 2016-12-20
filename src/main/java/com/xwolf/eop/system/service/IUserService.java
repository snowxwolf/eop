package com.xwolf.eop.system.service;

import com.xwolf.eop.system.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface IUserService extends BaseService<User> {

    String login(User puser);
}
