package com.fan1tuan.general.ui.struts2.core;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants.FlagStatus;
import com.opensymphony.xwork2.Action;

public class InnerAction extends Fan1TuanAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3894461312177813563L;

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	/**
	 * -------------/needLogin.f1t & /ajax/ajaxNeedLogin.f1t--------------
	 */
	//入参与出参
	private String redirect;
	
	public String needLogin(){
		flag = FlagStatus.NEEDLOGIN.ordinal();
		return Action.SUCCESS;
	}
}
