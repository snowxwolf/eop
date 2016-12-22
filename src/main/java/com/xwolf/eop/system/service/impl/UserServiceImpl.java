package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.dao.UserMapper;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xwolf
 * @date 2016-12-16 21:54
 * @since V1.0.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    private static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(User puser) {
        JSONObject jsonObject=new JSONObject();
        try {
            if ( puser!=null && StringUtils.isNotBlank(puser.getUname()) && StringUtils.isNotBlank(puser.getUpasswd())) {
                UsernamePasswordToken token = new UsernamePasswordToken(puser.getUname(),"");
                token.setRememberMe(true);
                Subject user = SecurityUtils.getSubject();
                user.login(token);
                if(user.isAuthenticated()){
                    jsonObject.put("success", true);
                    jsonObject.put("restVal", "登录成功!");
                }
            }
        } catch (UnknownAccountException e) {
            jsonObject.put("success", false);
            jsonObject.put("restVal", "用户不存在!");
        }catch (LockedAccountException e){
            jsonObject.put("success", false);
            jsonObject.put("restVal", "账号锁定,请联系管理员!");
        }catch (IncorrectCredentialsException e){
            jsonObject.put("success", false);
            jsonObject.put("restVal", "密码错误!");
        }catch(Exception e){
            jsonObject.put("success", false);
            jsonObject.put("restVal", "登录失败!");
        } finally {
            return jsonObject.toJSONString();
        }
    }
}
