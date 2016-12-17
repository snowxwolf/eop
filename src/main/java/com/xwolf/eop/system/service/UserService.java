package com.xwolf.eop.system.service;

import com.xwolf.eop.system.entity.User;

/**
 * @author xwolf
 * @date 2016-12-16 21:54
 * @since V1.0.0
 */
public interface UserService extends BaseService<User> {

    String login(User user);

}
