package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.common.util.UUIDUtil;
import com.xwolf.eop.system.dao.RolesMapper;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.service.IRolesService;
import com.xwolf.eop.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
		Map<String,Object> map=HttpUtil.getRequestMap(request);
		List<Roles> codesList=rolesMapper.selectRolesList(map);
		return  PageHelper.getListResult(codesList);
	}

	@Override
	public JSONObject insert(Roles roles) {
		try {
			roles.setRcode(UUIDUtil.getUUID());
			roles.setRtime(new Date());
			int re= rolesMapper.insert(roles);
			if(re>0){
				return success();
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return systemError();
		}
		return unkownError();
	}

	@Override
	public JSONObject update(Roles roles) {
		try {
			int re= rolesMapper.updateByPrimaryKeySelective(roles);
			if(re>0){
				return success();
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return systemError();
		}
		return unkownError();
	}

	@Override
	public JSONObject deleteBatch(HttpServletRequest request) {
		try {
			String[] idAry= HttpUtil.getRequestIds(request);
			rolesMapper.deleteBatch(idAry);
			return success();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return systemError();
		}
	}
}
