package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.entity.Roles;
import com.xwolf.eop.system.service.IRolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Slf4j
@Controller
@RequestMapping("system/roles")
public class RolesController extends BaseController {
     @Autowired
    private IRolesService rolesService;

    /**
     * 到角色列表
     * @return
     */
    @RequestMapping(value = "toRoles",method = {RequestMethod.GET,RequestMethod.POST})
     public String toRoles(){
         return "system/roles";
     }
    /**
     * 角色列表
     * @param request
     * @return
     */
    //@RequiresPermissions({"system:roles:list"})
     @RequestMapping(value = "rolesList",method = RequestMethod.POST)
     @ResponseBody
     public PageResult listRoles(HttpServletRequest request){
             PageResult result=rolesService.selectRoleList(request);
             return result;
     }

    /**
     * 添加
     * @param roles
     * @return
     */
    //@RequiresPermissions({"system:roles:add"})
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody
    JSONObject add(@Valid Roles roles, BindingResult bindingResult){
        log.info("user:{}",roles);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=rolesService.insert(roles);
        return result;
    }

    /**
     * 修改
     * @param roles
     * @return
     */
    //@RequiresPermissions({"system:roles:update"})
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(@Valid Roles roles,BindingResult bindingResult){
        log.info("menus:{}",roles);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=rolesService.update(roles);
        return result;
    }

    /**
     * 删除
     * @param request
     * @return
     */
    //@RequiresPermissions({"system:roles:delete"})
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(HttpServletRequest request){
        JSONObject result=rolesService.deleteBatch(request);
        return result;
    }
}
