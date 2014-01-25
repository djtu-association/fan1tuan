package com.fan1tuan.user.ui.struts2.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession.LOG_TYPE;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.User;
import com.opensymphony.xwork2.Action;

public class UserAction implements SessionAware {
	/**
	 * 
	 */

	// session,request
	private Map<String, Object> session;

	// service dao
	private UserService userService;
	private AreaDao areaDao;



	// login init
	private String flag = "1";
	private Map<String, String> lastLogin;
	// get login
	private String password;
	private String cellphone;
	private String loginFlag;
	private String isCookie;
	// get reg
	private String checkcode;
	private String regFlag;
	// get logout
	private String logoutFlag;
	// set area[]
	private String areaId;
	private List<Area> area;

	/**
	 * 初始化登陆页面，可能要处理cookie信息
	 * 
	 * @return
	 */
	public String initLogin() {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (null != cookies && cookies.length != 0) {
			Cookie cookie = null;
			for (int i = 0, size = cookies.length; i < size; i++) {
				cookie = cookies[i];
				String cName = cookie.getName();
				if (cName.equals(ICookie.USER_CACHE)) {
					String[] value = cookie.getValue().split("&");
					lastLogin = new HashMap<String, String>();
					lastLogin.put("cellphone", value[0]);
					lastLogin.put("pwd", value[1]);
				}
			}
		}
		flag = "0";// show login panel
		return Action.SUCCESS;

	}

	// init reg page
	public String initReg() {
		flag = "1";// show reg page
		return Action.SUCCESS;
	}

	// ajax get login
	public String getLogin() {

		User user = new User();
		user.setPassword(password);
		user.setCellphone(cellphone);

		if (userService.login(user, session,LOG_TYPE.TRUE)) {
			// 设置cookie
			if (isCookie.equals("set")) {
				StringBuffer sb = new StringBuffer();
				sb.append(cellphone);
				sb.append("&");
				sb.append(password);
				Cookie cookie = new Cookie(ICookie.USER_CACHE, sb.toString());
				cookie.setMaxAge(ICookie.COOKIE_AGE);// 15天
				ServletActionContext.getResponse().addCookie(cookie);
			} else {
				Cookie[] cookies = ServletActionContext.getRequest()
						.getCookies();
				if (null != cookies && cookies.length != 0) {
					Cookie cookie = new Cookie(ICookie.USER_CACHE, null);
					cookie.setMaxAge(0);// 删除cookies
					ServletActionContext.getResponse().addCookie(cookie);// 没有直接删除cookie的方法，只有覆盖
				}
			}
			setLoginFlag("success");
			return Action.SUCCESS;
		} else {
			setLoginFlag("error");
			return Action.ERROR;
		}
	}

	// ajax get register
	public String getReg() {

		// 获取来源URL
		// String url = request.get(key);

		User user = new User();
		user.setCellphone(cellphone);
		user.setPassword(password);
		// 判断手机号码是否可用
		if (userService.isAvailableCellphone(cellphone)) {
			if (userService.register(user)) {
				userService.login(user, session,LOG_TYPE.TRUE);// 注册完成默认登陆当前用户
				setRegFlag("success");
				return Action.SUCCESS;
			} else {
				setRegFlag("error");
				return Action.ERROR;
			}
		} else {
			setRegFlag("cellphone");
			return Action.ERROR;
		}
	}

	/**
	 * ajax get logout 注销后，清除session中的currentUser，但是保留areaId
	 * 同时将session中的loginOk设置为2，并不清楚用户的cookie数据
	 * 
	 * @return
	 */
	public String logout() {
		if (userService.logoff(session)) {
			Cookie cookie = new Cookie(ICookie.USER_CACHE, null);
			cookie.setMaxAge(0);// 删除cookies
			ServletActionContext.getResponse().addCookie(cookie);// 没有直接删除cookie的方法，只有覆盖
			setLogoutFlag("success");
			return Action.SUCCESS;
		}
		setLogoutFlag("error");
		return Action.ERROR;
	}

	// init setArea ftl
	public String initSetArea() {
		setArea(areaDao.findAll());
		return Action.SUCCESS;
	}

	// -------------------------getter and
	// setter--------------------------------------
	


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	
	public Map<String, Object> getSession() {
		return session;
	}

	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	
	public String getIsCookie() {
		return isCookie;
	}

	public void setIsCookie(String isCookie) {
		this.isCookie = isCookie;
	}

	public Map<String, String> getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Map<String, String> lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	
}
