package com.xwolf.eop.system.service;

import com.xwolf.eop.system.entity.Permissions;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
public interface IPermissionsService extends BaseService<Permissions> {

    List<Permissions> getPermissionsByUserCode(String usercode);
}
