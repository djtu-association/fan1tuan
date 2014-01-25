package com.fan1tuan.general.ui.struts2.core;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.fan1tuan.general.config.Fan1TuanConfig;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.general.util.StringUtil;
import com.fan1tuan.shop.business.TagService;
import com.fan1tuan.shop.pojos.ShopTasteTag;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class IndexAction extends Fan1TuanAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5167138841477322356L;

	// service dao
	private TagService tagService;
	private UserService userService;
	private AreaDao areaDao;

	// logger
	Logger logger = LogManager.getLogger(getClass().getName());

	/**
	 * --------------------------/index.f1t----------------------
	 * 	 * 初始化：历史足迹，每周之星，店铺、菜品口味(tasteTag)、电话订餐口味（tasteTag）
	 * @return
	 */

	// 出参
	private List<ShopTasteTag> shopTasteTags;
	// private List<DishTasteTag> dishTasteTags;
	// 不应该使用dishTasteTag，就算是菜品排行依然使用shopTasteTags
	private String areaId;
	private String areaName;

	public String execute() {

		
		Map<String, Object> area_cache = SessionUtil.getArea(session);
		areaId = (String) area_cache.get(ISession.AREAID);
		areaName = (String) area_cache.get(ISession.AREANAME);

		
		setShopTasteTags(tagService.getShopTasteTag());

		return Action.SUCCESS;
	}

	/**
	 * --------------------------/areas.f1t----------------------
	 * @return
	 */
	//入参
	private String redirect;
	//出参
	private List<Area> area;
	
	public String getAreas() {
		area = areaDao.findAll();
		return Action.SUCCESS;
	}

	/**
	 * --------------------------/updateArea.f1t----------------------
	 * @return
	 */
	//入参
	//private String redirect;   这次redirect不会从url中自动进来，需要js在页面提供支持
	//private String areaId;
	//private String areaName;
	
	public String updateArea() {
		
		Cookie cookie = new Cookie(ICookie.AREA_CONFIG, areaId+ICookie.SEPERATOR+areaName);
		cookie.setMaxAge(ICookie.COOKIE_AGE);
		ServletActionContext.getResponse().addCookie(cookie);
		
		try {
			areaName = new String(areaName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> area_cache = SessionUtil.getArea(session);
		area_cache.put(ISession.AREAID, areaId);
		area_cache.put(ISession.AREANAME, areaName);
		
		session.put(ISession.AREA, area_cache);
		
		
		if(redirect==null||redirect.equals("")){
			redirect = Fan1TuanConfig.getProperty("fan1tuan.home");
		}else{
			redirect = StringUtil.decodeURL(redirect);
		}
		
		
		return Action.SUCCESS;
	}

	/**
	 * --------------------------/signout.f1t----------------------
	 * @return
	 */
	//入参
	//private String redirect;   redirect不会从url中自动进来，需要js在页面提供支持
	public String signout(){
		
		userService.logoff(session);
		Cookie cookie = new Cookie(ICookie.USER_CACHE, null);
		cookie.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie);
		
		return SUCCESS;
	}
	
	/**
	 * --------------------------/signin.f1t----------------------
	 * @return
	 */
	
	//入参
	//private String redirect;   跳转
	
	public String signin(){
		
		flag = 0;//show login panel
		return Action.SUCCESS;
		
	}
	
	/**
	 * --------------------------/signup.f1t----------------------
	 * @return
	 */

	//入参
	//private String redirect;   跳转
	
	public String signup(){
		flag = 1;
		return Action.SUCCESS;
	}
	
	
	
	
	// -------------------------getter and
	// setter--------------------------------------

	public TagService getTagService() {
		return tagService;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public List<ShopTasteTag> getShopTasteTags() {
		return shopTasteTags;
	}

	public void setShopTasteTags(List<ShopTasteTag> shopTasteTags) {
		this.shopTasteTags = shopTasteTags;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
