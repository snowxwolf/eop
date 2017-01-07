package com.xwolf.eop.system.service;

import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.entity.Roles;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface IRolesService extends BaseService<Roles> {

    List<Roles> getRolesListByUserCode(String username);

    PageResult selectRoleList(HttpServletRequest request);
}
