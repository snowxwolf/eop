package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.UserRoleMapper;
import com.xwolf.eop.system.entity.UserRole;
import com.xwolf.eop.system.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:28
 * @since V1.0.0
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements IUserRoleService {
    private Logger LOG= LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleMapper userRoleMapper;
}
