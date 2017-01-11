package com.xwolf.eop.system.service.impl;

import com.google.common.collect.Maps;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.dao.RolesMapper;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.service.IRolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Slf4j
@Service
public class RolesServiceImpl extends BaseServiceImpl<Roles> implements IRolesService {
	@Autowired
	private RolesMapper rolesMapper;

	/**
	 * 根据用户code获取角色列表
	 * @param usercode
	 * @return
	 */
	@Override
	public List<Roles> getRolesListByUserCode(String usercode) {
		log.info("usercode:{}",usercode);
		return rolesMapper.getRolesListByUserCode(usercode);
	}

	@Override
	public PageResult selectRoleList(HttpServletRequest request) {
		PageHelper.getPage(request);
		Map<String,Object> map= Maps.newHashMap();
		List<Roles> codesList=rolesMapper.selectRolesList(map);
		return  PageHelper.getListResult(codesList);
	}
}
