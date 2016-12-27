package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.MenuPermissionMapper;
import com.xwolf.eop.system.entity.MenuPermission;
import com.xwolf.eop.system.service.IMenuPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:34
 * @since V1.0.0
 */
@Service
public class MenuPermissionServiceImpl extends BaseServiceImpl<MenuPermission> implements IMenuPermissionService {
    private Logger LOG= LoggerFactory.getLogger(MenuPermissionServiceImpl.class);
    @Autowired
    private MenuPermissionMapper menuPermissionMapper;
}
