package com.fan1tuan.general.ui.struts2.core;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants.FlagStatus;
import com.fan1tuan.general.util.CookieUtil;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.User;
import com.opensymphony.xwork2.Action;

public class IndexAjaxAction extends Fan1TuanAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6996130082521708353L;
	//service dao
	private UserService userService;
	

	/**
	 * --------------------------/ajaxSignin.f1t----------------------
	 * @return
	 */
	//入参
	private String password;
	private String cellphone;
	private String isCookie;
	//出参
	private String loginFlag;
	public String signin(){	
		ServletActionContext.getResponse().addCookie(new Cookie("USER_STORE", "1234"));
		
		User user = new User();
		user.setPassword(password);
		user.setCellphone(cellphone);
		
		flag = makeFlag(userService.login(user, session,ISession.LOG_TYPE.TRUE));
		
		if(flag==FlagStatus.SUCCESS.ordinal()){
			//System.out.println("Session:"+session);
			//设置cookie
			if(isCookie.equals("set")){				
				StringBuilder sb = new StringBuilder();
				String userId = (String) SessionUtil.getUser(session).get(ISession.USER_ID);
				sb.append(userId);
				sb.append(ICookie.SEPERATOR);
				sb.append(cellphone);
				sb.append(ICookie.SEPERATOR);
				sb.append(System.currentTimeMillis());
				//System.err.println(sb.toString());
				Cookie cookie = new Cookie(ICookie.USER_CACHE, sb.toString());
				cookie.setMaxAge(ICookie.COOKIE_AGE);//15天
				ServletActionContext.getResponse().addCookie(cookie);
			}else{
				Cookie[] cookies = ServletActionContext.getRequest().getCookies();
				Cookie cookie = CookieUtil.getUserCacheCookie(cookies);
				
				if(cookie!=null){
					cookie = new Cookie(ICookie.USER_CACHE, null); 
					cookie.setMaxAge(0);//删除cookies
					ServletActionContext.getResponse().addCookie(cookie);
				}
				
			}
			setLoginFlag("success");
		}else{
			setLoginFlag("error");
		}
		
		return Action.SUCCESS;
	}
	
	
	/**
	 * --------------------------/ajaxSignup.f1t----------------------
	 * @return
	 */
	//入参
	//private String password;
	//private String cellphone;
	//出参
	private String regFlag;
	
	public String signup(){
		User user = new User();
		user.setCellphone(cellphone);
		user.setPassword(password);
		flag = makeFlag(false);
		//判断手机号码是否可用
		if(userService.isAvailableCellphone(cellphone)){		
			if(userService.register(user)){
				flag = makeFlag(true);
				userService.login(user, session,ISession.LOG_TYPE.TRUE);//注册完成默认登陆当前用户
				setRegFlag("success");
			}else {
				setRegFlag("error");
			}
		}else {
			setRegFlag("cellphone");
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	//-------------------------getter and setter--------------------------------------
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public String getRegFlag() {
		return regFlag;
	}
	public void setRegFlag(String regFlag) {
		this.regFlag = regFlag;
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
	public String getIsCookie() {
		return isCookie;
	}
	public void setIsCookie(String isCookie) {
		this.isCookie = isCookie;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}	
