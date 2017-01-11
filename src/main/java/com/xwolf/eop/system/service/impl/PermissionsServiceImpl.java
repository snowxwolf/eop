package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.PermissionsMapper;
import com.xwolf.eop.system.entity.Permissions;
import com.xwolf.eop.system.service.IPermissionsService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class PermissionsServiceImpl extends BaseServiceImpl<Permissions> implements IPermissionsService {


     @Autowired
     private PermissionsMapper permissionsMapper;

     /**
      * 根据用户code获取权限列表
      * @param usercode
      * @return
      */
     @Override
     public List<Permissions> getPermissionsByUserCode(String usercode) {
          return permissionsMapper.getPermissionsByUserCode(usercode);
     }
}
