package com.xwolf.eop.common.security;


import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xwolf.eop.system.entity.Permissions;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.enums.UserStatusEnums;
import com.xwolf.eop.system.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        Map<String,Object> map = Maps.newHashMap();
        Set<Roles> roleSet = null;

        List<Permissions> permissionList=null;
        //角色名的集合
        Set<String> roles = Sets.newHashSet();
        //权限名的集合
        Set<String> permissions =Sets.newHashSet();

        // Iterator<SysRole> it = roleSet.iterator();
        //* while(it.hasNext()){
        // roles.add(it.next().getRname();

        if(permissionList!=null){
            for(Permissions permission:permissionList){
                permissions.add("");
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

