package com.fan1tuan.admin.ui.struts2.core;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.opensymphony.xwork2.Action;

public class AdminIndex extends Fan1TuanAction {
	
	private static final long serialVersionUID = 1L;
	//base params
	private String navName = "adminindex";
	
	public String showAdminIndex(){
		return Action.SUCCESS;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

}
