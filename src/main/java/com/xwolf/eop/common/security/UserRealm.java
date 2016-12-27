package com.xwolf.eop.common.security;


import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xwolf.eop.system.entity.Permissions;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.enums.UserStatusEnums;
import com.xwolf.eop.system.service.IPermissionsService;
import com.xwolf.eop.system.service.IRolesService;
import com.xwolf.eop.system.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xwolf
 * @date 2016-12-14 11:48
 * @since V1.0.0
 */
public class UserRealm extends AuthorizingRealm {

    private Logger LOG= LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionsService permissionsService;

    @Autowired
    private IRolesService rolesService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        LOG.info("Auth user:{}",username);
        User user=userService.getUserByName(username);
        String ucode=user.getUcode();
        Map<String,Object> map = Maps.newHashMap();
        //根据用户名获取角色列表
        List<Roles> rolesList=rolesService.getRolesListByUserCode(ucode);

        List<Permissions> permissionList=permissionsService.getPermissionsByUserCode(ucode);
        //角色名的集合
        Set<String> roles = Sets.newHashSet();
        //权限名的集合
        Set<String> permissions =Sets.newHashSet();
         for(Roles role:rolesList){
             roles.add(role.getRpcode());
         }
        if(permissionList!=null){
            for(Permissions permission:permissionList){
                permissions.add(permission.getPcode());
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user =userService.getUserByName(token.getUsername());
        if(user==null){
            throw new UnknownAccountException();
        }
        int status =user.getUstatus();
        //账号锁定
        if (UserStatusEnums.LOCKED.getCode().equals(status)) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUname(),user
                .getUpasswd(),getName());
    }
}

