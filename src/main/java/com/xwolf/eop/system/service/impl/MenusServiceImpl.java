package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.xwolf.eop.common.pojo.Global;
import com.xwolf.eop.common.pojo.NavMenus;
import com.xwolf.eop.system.dao.MenusMapper;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Slf4j
@Service
public class MenusServiceImpl extends BaseServiceImpl<Menus> implements IMenusService {

    @Autowired
	private MenusMapper menusMapper;

	/**
	 * 导航菜单
	 * @return
	 */
	@Override
	public JSONObject getNavMenus() {
		Map<String,Object> map= Maps.newHashMap();
		map.put("mstatus",Global.ENABLE_STATUS);
		List<Menus> parentMenus=menusMapper.getParentMenus(map);
		JSONObject nav=new JSONObject();
		JSONArray navAry=new JSONArray();
		for(Menus pmenu:parentMenus){
			NavMenus navMenus =new NavMenus();
			String pcode=pmenu.getMcode();
			navMenus.setId(pmenu.getMcode());
			navMenus.setIcon(pmenu.getIcon());
			navMenus.setUrl(pmenu.getMurl());
			navMenus.setText(pmenu.getMname());
			Map<String,Object> smap=Maps.newHashMap();
			smap.put("pcode",pcode);
			smap.put("mstatus",Global.ENABLE_STATUS);
            List<Menus> sonMenus=menusMapper.getSonMenus(smap);
			JSONArray ary=new JSONArray();
            for(Menus sonMenu:sonMenus){
				NavMenus navSonMenu =new NavMenus();
				navSonMenu.setId(sonMenu.getMcode());
				navSonMenu.setIcon(sonMenu.getIcon());
				navSonMenu.setUrl(sonMenu.getMurl());
				navSonMenu.setText(sonMenu.getMname());
				ary.add(navSonMenu);
			}
			navMenus.setChildren(ary);
			navAry.add(navMenus);
		}
		nav.put("data",navAry);
 		return nav;
	}

	@Override
	public JSONArray getMenusList() {
		//获取所有父菜单
		List<Menus> parentMenus=menusMapper.getParentMenus(null);
		JSONArray navAry=new JSONArray();
		for(Menus pmenu:parentMenus){
			String pcode=pmenu.getMcode();
			JSONObject pjson=JSON.parseObject(JSON.toJSONString(pmenu));
			Map<String,Object> map=Maps.newHashMap();
			map.put("pcode",pcode);
			List<Menus> sonMenus=menusMapper.getSonMenus(map);
			JSONArray ary=new JSONArray();
			for(Menus sonMenu:sonMenus){
				ary.add(sonMenu);
			}
			pjson.put("children",ary);
			navAry.add(pjson);
		}
		return navAry;
	}
}
