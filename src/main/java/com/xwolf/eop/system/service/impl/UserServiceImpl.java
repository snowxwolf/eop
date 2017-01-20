package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.Global;
import com.xwolf.eop.common.pojo.PageHelper;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.common.util.UUIDUtil;
import com.xwolf.eop.system.dao.UserMapper;
import com.xwolf.eop.system.entity.User;
import com.xwolf.eop.system.service.IUserService;
import com.xwolf.eop.util.HttpUtil;
import com.xwolf.eop.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xwolf
 * @date 2016-12-16 21:54
 * @since V1.0.0
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject login(HttpServletRequest request) {

        JSONObject jsonObject=new JSONObject();
        try {
            String code=request.getParameter("code");
            if(StringUtils.isBlank(code) ||!HttpUtil.getCheckCode(request).equalsIgnoreCase(code)){
                jsonObject.put("success", false);
                jsonObject.put("restVal", "验证码错误!");
                return jsonObject;
            }
            String uname=request.getParameter("name");
            String passwd=request.getParameter("passwd");

            if ( StringUtils.isNotBlank(uname) && StringUtils.isNotBlank(passwd)) {
                UsernamePasswordToken token = new UsernamePasswordToken(uname, MD5.getMessageDigest(passwd, Global.DEFAULT_ENCODING));
                token.setRememberMe(true);
                Subject user = SecurityUtils.getSubject();
                user.login(token);
                if(user.isAuthenticated()){
                    jsonObject.put("success", true);
                    jsonObject.put("restVal", "登录成功!");
                }
            }
        } catch (LockedAccountException e){
            jsonObject.put("success", false);
            jsonObject.put("restVal", "账号锁定,请联系管理员!");
        }catch (DisabledAccountException e){
            jsonObject.put("success", false);
            jsonObject.put("restVal", "账号禁用,请联系管理员!");
        }catch(Exception e){
            log.error(e.getMessage(),e);
            jsonObject.put("success", false);
            jsonObject.put("restVal", "用户名或者密码错误!");
        } finally {
            return jsonObject;
        }
    }

    /**
     * 查询用户
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    /**
     * 用户列表
     * @param request
     * @return
     */
    @Override
    public PageResult getUserList(HttpServletRequest request) {
        PageHelper.getPage(request);
        Map<String,Object> map=HttpUtil.getRequestMap(request);
        List<User> userList=userMapper.selectUserList(map);
        return  PageHelper.getListResult(userList);
    }

    @Override
    public JSONObject insert(User user) {
        try {
            user.setCtime(new Date());
            user.setUcode(UUIDUtil.getUUID());
            int re= userMapper.insert(user);
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
    public JSONObject update(User user) {
        try {
            int re= userMapper.updateByPrimaryKeySelective(user);
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
            String[] idAry=HttpUtil.getRequestIds(request);
            userMapper.deleteBatch(idAry);
            return success();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return systemError();
        }
    }
}
