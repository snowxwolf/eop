package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.RolesMapper;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.service.IRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Service
public class RolesServiceImpl extends BaseServiceImpl<Roles> implements IRolesService {
	private static final Logger LOG= LoggerFactory.getLogger(RolesServiceImpl.class);
	@Autowired
	private RolesMapper rolesMapper;

	@Override
	public List<Roles> getRolesListByUserCode(String usercode) {
		return null;
	}
}
