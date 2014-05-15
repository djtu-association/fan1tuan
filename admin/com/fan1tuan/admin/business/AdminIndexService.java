package com.fan1tuan.admin.business;

import com.fan1tuan.general.business.IFan1TuanService;

public interface AdminIndexService extends IFan1TuanService {
	
	//登录管理后台
	public boolean doLogin();
	//登出管理后台
	public boolean doLogout();

}
