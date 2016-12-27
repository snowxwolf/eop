package com.xwolf.eop.system.service.impl;

import com.xwolf.eop.system.dao.PermissionsMapper;
import com.xwolf.eop.system.entity.Permissions;
import com.xwolf.eop.system.service.IPermissionsService;
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
public class PermissionsServiceImpl extends BaseServiceImpl<Permissions> implements IPermissionsService {

     private static final Logger LOG= LoggerFactory.getLogger(PermissionsServiceImpl.class);

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
