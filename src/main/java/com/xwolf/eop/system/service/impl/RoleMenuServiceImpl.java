package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.RoleMenuMapper;
import com.xwolf.eop.system.entity.RoleMenu;
import com.xwolf.eop.system.service.IRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:31
 * @since V1.0.0
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements IRoleMenuService {
    private Logger LOG= LoggerFactory.getLogger(RoleMenuServiceImpl.class);
    @Autowired
    private RoleMenuMapper roleMenuMapper;
}
