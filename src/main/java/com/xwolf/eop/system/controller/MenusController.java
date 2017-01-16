package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.enums.StatusCodeEnum;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
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
@RequestMapping("system/menus")
public class MenusController extends BaseController {


    @Autowired
    private IMenusService menusService;

    /**
     * 到菜单管理页面
     * @return
     */
    @RequestMapping(value = "toMenus",method = {RequestMethod.POST,RequestMethod.GET})
    public String toMenus(){
         return "system/menus";
    }

    /**
     * 获取父菜单
     * @return
     */
    @RequestMapping(value = "getParentMenus",method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getParentMenus(){
        JSONArray ary=menusService.getParentMenus();
        return ary;
    }
    /**
     * 获取所有菜单
     * @return
     */
    @RequestMapping(value = "getMenusList",method = RequestMethod.POST)
    public @ResponseBody JSONArray getMenuList(){
        return menusService.getMenusList();
    }
    /**
     * 主页导航菜单
     * @return
     */
    @RequestMapping(value ="navMenus",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject list(){
        JSONObject menus=  menusService.getNavMenus();
      log.info("导航菜单:{}",menus);
      return menus ;
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public @ResponseBody JSONObject add(@Valid Menus menu, BindingResult bindingResult){
     log.info("menus:{}",menu);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
     JSONObject result=menusService.insert(menu);
     return result;
    }

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(@Valid Menus menu,BindingResult bindingResult){
        log.info("menus:{}",menu);
        if(bindingResult.hasErrors()){
            return error(StatusCodeEnum.VALIDATE_ERROR.getCode());
        }
        JSONObject result=menusService.update(menu);
        return result;
    }

    /**
     * 删除菜单
     * @param request
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public @ResponseBody JSONObject update(HttpServletRequest request){
        JSONObject result=menusService.deleteBatch(request);
        return result;
    }
}
