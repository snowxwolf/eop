package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
public class MenusController {


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
    @RequestMapping(value = "addMenu",method = RequestMethod.POST)
    public @ResponseBody String add(Menus menu){
     log.info("menus:{}",menu);
     return null;
    }
}
