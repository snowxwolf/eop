package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.UserRoleMapper;
import com.xwolf.eop.system.entity.UserRole;
import com.xwolf.eop.system.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:28
 * @since V1.0.0
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
}
