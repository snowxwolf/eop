package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.MenuPermissionMapper;
import com.xwolf.eop.system.entity.MenuPermission;
import com.xwolf.eop.system.service.IMenuPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wolf
 * @date 2016-12-27 23:34
 * @since V1.0.0
 */
@Slf4j
@Service
public class MenuPermissionServiceImpl extends BaseServiceImpl<MenuPermission> implements IMenuPermissionService {
    @Autowired
    private MenuPermissionMapper menuPermissionMapper;
}
