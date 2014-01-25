package com.fan1tuan.general.ui.struts2.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.shop.business.TagService;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.ShopTasteTag;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class IndexAction implements SessionAware, RequestAware{
	
	//session,request
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	//service dao
	private TagService tagService;
	private UserService userService;
	private AreaDao areaDao;
	
	//index init
	private ArrayList<ShopTasteTag> shopTasteTags;
	private ArrayList<DishTasteTag> dishTasteTags;
	private Map<String, Long> pageMap;
		
	//set area[]
	private List<Area> area;
	private String areaId;
	private String areaName;

	
	//logger
	Logger logger = LogManager.getLogger(getClass().getName());
	
	
	/**
	 * 初始化：历史足迹，每周之星，店铺、菜品口味(tasteTag)、电话订餐口味（tasteTag）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String execute()
	{	
		/*
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		//判断session中的areaId
		if((areaId == null || areaId.equals("")) && cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(ICookie.AREA_CONFIG)){
					areaId = cookie.getValue();
				}
			}
		}
		if(areaId != null && !areaId.equals("")){
			areaName = areaDao.findOneById(areaId).getName();
			setAreaName(areaName);
			//设置areaId
			session.put(ISession.AREAID, areaId);
			session.put(ISession.AREANAME, areaName);		
			Cookie cookie = new Cookie(ICookie.AREA_CONFIG, areaId);
			cookie.setMaxAge(ICookie.COOKIE_AGE);
			ServletActionContext.getResponse().addCookie(cookie);
			setAreaId(areaId);
		}
		
		//判断cookie,如果cookie存在的话，直接登陆
		if(session.get(ISession.LOGIN) == null || ((HashMap<String, Integer>)session.get(ISession.LOGIN)).get(ISession.LOGIN_STATUS) == null){
			
			if( null != cookies && cookies.length !=0 ){
				Cookie cookie = null;
				for(int i=0,size=cookies.length; i<size; i++){
					cookie = cookies[i];
					String cName = cookie.getName();
					if(cName.equals(ICookie.USER_CACHE)){
						String cValue = cookie.getValue();
						String[] userInfo = cValue.split("&");
						User user = new User();
						user.setCellphone(userInfo[0]);
						user.setPassword(userInfo[1]);
						userService.login(user, session,ISession.LOG_TYPE.FALSE);
					}
				}
				logger.info("login success");
			}
		}
		*/
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(areaId != null){
			HashMap<String, Object> areaMap = new HashMap<String, Object>();
			//Area area = areaDao.findOneById(areaId);
			areaMap.put(ISession.AREAID, areaId);
			areaMap.put(ISession.AREANAME, (areaName!=null)?areaName:"");
			session.setAttribute(ISession.AREA, areaMap);
		}
		
		setShopTasteTags((ArrayList<ShopTasteTag>)tagService.getShopTasteTag());
		setDishTasteTags((ArrayList<DishTasteTag>)tagService.getDishTasteTag());		
		
		return Action.SUCCESS;
	}

	
	
	//-------------------------getter and setter--------------------------------------

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}



	public TagService getTagService() {
		return tagService;
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



	public ArrayList<ShopTasteTag> getShopTasteTags() {
		return shopTasteTags;
	}



	public void setShopTasteTags(ArrayList<ShopTasteTag> shopTasteTags) {
		this.shopTasteTags = shopTasteTags;
	}



	public ArrayList<DishTasteTag> getDishTasteTags() {
		return dishTasteTags;
	}



	public void setDishTasteTags(ArrayList<DishTasteTag> dishTasteTags) {
		this.dishTasteTags = dishTasteTags;
	}



	public Map<String, Long> getPageMap() {
		return pageMap;
	}



	public void setPageMap(Map<String, Long> pageMap) {
		this.pageMap = pageMap;
	}



	public List<Area> getArea() {
		return area;
	}



	public void setArea(List<Area> area) {
		this.area = area;
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



	public Logger getLogger() {
		return logger;
	}



	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public Map<String, Object> getRequest() {
		return request;
	}
	
	
	
}	
