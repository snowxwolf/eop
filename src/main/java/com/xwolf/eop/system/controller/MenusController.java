package com.xwolf.eop.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller
@RequestMapping("system/menus")
public class MenusController {

    private static final Logger log= LoggerFactory.getLogger(MenusController.class);

    @Autowired
    private IMenusService menusService;

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
