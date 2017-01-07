package com.xwolf.eop.system.controller;

import com.xwolf.eop.common.pojo.easyui.PageResult;
import com.xwolf.eop.system.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Controller
@RequestMapping("system/roles")
public class RolesController {
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
     @RequestMapping(value = "rolesList",method = RequestMethod.POST)
     @ResponseBody
     public PageResult listRoles(HttpServletRequest request){
             PageResult result=rolesService.selectRoleList(request);
             return result;
     }
}
