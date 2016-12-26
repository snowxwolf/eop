package com.xwolf.eop.system.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xwolf.eop.common.pojo.NavMenus;
import com.xwolf.eop.system.dao.MenusMapper;
import com.xwolf.eop.system.entity.Menus;
import com.xwolf.eop.system.service.IMenusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author xwolf
 * @since 2016-12-20
 */
@Service
public class MenusServiceImpl extends BaseServiceImpl<Menus> implements IMenusService {

	private static final Logger LOG= LoggerFactory.getLogger(MenusServiceImpl.class);
    @Autowired
	private MenusMapper menusMapper;

	/**
	 * 导航菜单
	 * @return
	 */
	@Override
	@Cacheable(key = "nav_menus",value = "nav_menus")
	public JSONObject getNavMenus() {
		List<Menus> parentMenus=menusMapper.getParentMenus();
		JSONObject nav=new JSONObject();
		JSONArray navAry=new JSONArray();
		for(Menus pmenu:parentMenus){
			NavMenus navMenus =new NavMenus();
			String pcode=pmenu.getMcode();
			navMenus.setId(pmenu.getMcode());
			navMenus.setIcon(pmenu.getIcon());
			navMenus.setUrl(pmenu.getMurl());
			navMenus.setText(pmenu.getMname());
            List<Menus> sonMenus=menusMapper.getSonMenus(pcode);
			JSONArray ary=new JSONArray();
            for(Menus sonMenu:sonMenus){
				NavMenus navSonMenu =new NavMenus();
				navSonMenu.setId(sonMenu.getMcode());
				navSonMenu.setIcon(sonMenu.getIcon());
				navSonMenu.setUrl(sonMenu.getMurl());
				navSonMenu.setText(sonMenu.getMname());
				ary.add(navSonMenu);
			}
			navMenus.setMenus(ary);
			navAry.add(navMenus);
		}
		nav.put("data",navAry);
 		return nav;
	}
}
