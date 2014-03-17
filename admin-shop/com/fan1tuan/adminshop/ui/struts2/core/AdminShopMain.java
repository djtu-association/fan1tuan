package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.opensymphony.xwork2.Action;

public class AdminShopMain extends Fan1TuanAction{

	private static final long serialVersionUID = 1L;
	
	public String showShopList(){
		return Action.SUCCESS;
	}
	
	public String showShopAdd(){
		return Action.SUCCESS;
	}
	
	public String doShopAdd(){
		return Action.SUCCESS;
	}
	
	public String showShopEdit(){
		return Action.SUCCESS;
	}
	
	public String doShopEdit(){
		return Action.SUCCESS;
	}
	
	public String doShopDelete(){
		return Action.SUCCESS;
	}
	
	public String showShopOrders(){
		return Action.SUCCESS;
	}
	
	public String doShopOrderDelete(){
		return Action.SUCCESS;
	}

}
