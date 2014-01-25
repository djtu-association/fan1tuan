package com.fan1tuan.general.ui.struts2.interceptor;


public class FilterConstant {

	//index/setArea.f1t
	public static final String URL_TO_SETAREA = "/fan1tuan/areas.f1t";
	public static final String URL_TO_GETAREA = "/fan1tuan/updateArea.f1t";
	
	public static final String[] ALLOW_URL = {
		"/areas.f1t",
	};
	
	public static final String[] NEED_LOGIN_NAMESPACE = {
		"user"
	};
	
}
