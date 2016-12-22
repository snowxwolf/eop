package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Service
public class MenusServiceImpl extends BaseServiceImpl<Menus> implements IMenusService {
	private static final Logger LOG= LoggerFactory.getLogger(MenusServiceImpl.class);
}
