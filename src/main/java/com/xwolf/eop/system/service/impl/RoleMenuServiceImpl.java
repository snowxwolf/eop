package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.RoleMenuMapper;
import com.xwolf.eop.system.entity.RoleMenu;
import com.xwolf.eop.system.service.IRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:31
 * @since V1.0.0
 */
@Slf4j
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements IRoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
}
