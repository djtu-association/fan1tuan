package com.fan1tuan.general.ui.struts2.interceptor;


public class FilterConstant {

	//index/setArea.f1t
	public static final String URL_TO_SETAREA = "/areas.f1t";
	public static final String URL_TO_GETAREA = "/updateArea.f1t";
	public static final String URL_RELATED_ADMIN = "/admin/";
	
	public static final String[] ALLOW_URL = {
		"/areas.f1t",
	};
	
	public static final String[] NEED_LOGIN_NAMESPACE = {
		"user"
	};
	
	public static final String AUTO_LOGIN_ALLOW_URL = "/ajax/secure/ajaxSignin.f1t";
	
}
