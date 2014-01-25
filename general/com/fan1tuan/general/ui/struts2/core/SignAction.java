package com.fan1tuan.general.ui.struts2.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.rank.business.DishRankService;
import com.fan1tuan.rank.business.ShopRankService;
import com.fan1tuan.shop.business.ShopUserService;
import com.fan1tuan.shop.business.TagService;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SignAction extends Fan1TuanAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//session,request
	private Map<String, Object> session;
	
	//service dao
	private DishRankService dishRankService;
	private ShopRankService shopRankService;
	private ShopUserService shopUserService;
	private TagService tagService;
	private UserService userService;
	private AreaDao areaDao;
	//login init
	private Map<String, String> lastLogin;
	//get login
	private String password;
	private String cellphone;
	private String loginFlag;
	private String isCookie;
	//get reg
	private String checkcode;
	private String regFlag;
	//get logout
	private String logoutFlag;
	//set area[]
	private List<Area> area;
	private String areaId;
	private String areaName;
	private String redirect;
	//default method
	public String execute(){
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 初始化登陆页面，可能要处理cookie信息
	 * @return
	 */
	public String initSignin(){
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(ICookie.USER_CACHE)){
				String[] user_cache = cookie.getValue().split(ICookie.SEPERATOR);
				String value = (user_cache.length>1)?user_cache[user_cache.length-1]:( (user_cache.length==0)?"":user_cache[0] );
				lastLogin.put("cellphone", value);
			}
		}
		flag = 0;//show login panel
		return Action.SUCCESS;
		
	}
	//init reg page
	public String initSignup(){
		flag = 1;//show reg page
		return Action.SUCCESS;
	}
	
	//ajax get login
	public String signin(){
		User user = new User();
		user.setPassword(password);
		user.setCellphone(cellphone);
		if(userService.login(user, session,ISession.LOG_TYPE.TRUE)){
			System.out.println("Session:"+session);
			//设置cookie
			if(isCookie.equals("set")){
				StringBuffer sb = new StringBuffer();
				String userId = (String) SessionUtil.getUser(session).get(ISession.USER_ID);
				sb.append(userId);
				sb.append(ICookie.SEPERATOR);
				sb.append(cellphone);
				sb.append(ICookie.SEPERATOR);
				sb.append(System.currentTimeMillis());
				Cookie cookie = new Cookie(ICookie.USER_CACHE, sb.toString());
				cookie.setMaxAge(ICookie.COOKIE_AGE);//15天
				ServletActionContext.getResponse().addCookie(cookie);
			}else{
				Cookie[] cookies = ServletActionContext.getRequest().getCookies();
				if(null != cookies && cookies.length != 0){
					Cookie cookie = new Cookie(ICookie.USER_CACHE, null); 
					cookie.setMaxAge(0);//删除cookies
					ServletActionContext.getResponse().addCookie(cookie);//没有直接删除cookie的方法，只有覆盖
				}
			}
			setLoginFlag("success");
			return Action.SUCCESS;
		}else {
			setLoginFlag("error");
			return Action.ERROR;
		}	
	}
	
	//ajax get register
	public String signup(){
		//获取来源URL
		//String url = request.get(key);
		User user = new User();
		user.setCellphone(cellphone);
		user.setPassword(password);
		//判断手机号码是否可用
		if(userService.isAvailableCellphone(cellphone)){		
			if(userService.register(user)){
				userService.login(user, session,ISession.LOG_TYPE.TRUE);//注册完成默认登陆当前用户
				setRegFlag("success");
				return Action.SUCCESS;
			}else {
				setRegFlag("error");
				return Action.ERROR;
			}
		}else {
			setRegFlag("cellphone");
			return Action.ERROR;
		}
	}
	
	/**
	 * ajax get logout
	 * 注销后，清除session中的currentUser，但是保留areaId
	 * 同时将session中的loginOk设置为2，并不清楚用户的cookie数据
	 * @return
	 */
	public String signout(){
		if(userService.logoff(session)){
			Cookie cookie = new Cookie(ICookie.USER_CACHE, null);
			cookie.setMaxAge(0);// 删除cookies
			ServletActionContext.getResponse().addCookie(cookie);// 没有直接删除cookie的方法，只有覆盖
			setLogoutFlag("success");
			return Action.SUCCESS;
		}
		setLogoutFlag("error");
		return Action.ERROR;
	}
	
	//init setArea ftl
	public String initSetArea(){
		setArea(areaDao.findAll());
		HttpServletRequest response= ServletActionContext.getRequest();
		setRedirect(response.getRequestURL().toString());
		return Action.SUCCESS;
	}
	
	public String updateArea(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(areaId != null){
			HashMap<String, Object> areaMap = new HashMap<String, Object>();
			//Area area = areaDao.findOneById(areaId);
			areaMap.put(ISession.AREAID, areaId);
			areaMap.put(ISession.AREANAME, (areaName!=null)?areaName:"");
			session.setAttribute(ISession.AREA, areaMap);
			//set cookie
			Cookie cookie = new Cookie(ICookie.AREA_CONFIG, areaId+ICookie.SEPERATOR+areaName);
			cookie.setMaxAge(ICookie.COOKIE_AGE);
			response.addCookie(cookie);
		}
		return Action.SUCCESS;
	}
	
	
	//---------------------Get Set-------------------------------

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public DishRankService getDishRankService() {
		return dishRankService;
	}

	public void setDishRankService(DishRankService dishRankService) {
		this.dishRankService = dishRankService;
	}

	public ShopRankService getShopRankService() {
		return shopRankService;
	}

	public void setShopRankService(ShopRankService shopRankService) {
		this.shopRankService = shopRankService;
	}

	public ShopUserService getShopUserService() {
		return shopUserService;
	}

	public void setShopUserService(ShopUserService shopUserService) {
		this.shopUserService = shopUserService;
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

	
	public Map<String, String> getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Map<String, String> lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getIsCookie() {
		return isCookie;
	}

	public void setIsCookie(String isCookie) {
		this.isCookie = isCookie;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getRegFlag() {
		return regFlag;
	}

	public void setRegFlag(String regFlag) {
		this.regFlag = regFlag;
	}

	public String getLogoutFlag() {
		return logoutFlag;
	}

	public void setLogoutFlag(String logoutFlag) {
		this.logoutFlag = logoutFlag;
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

	public Map<String, Object> getSession() {
		return session;
	}
	
	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

}
