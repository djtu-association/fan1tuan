package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.opensymphony.xwork2.Action;

public class AdminShopMenu extends Fan1TuanAction {

	private static final long serialVersionUID = 1L;
	
	public String showDishList(){
		return Action.SUCCESS;
	}
	
	public String showDishAdd(){
		return Action.SUCCESS;
	}
	
	public String doDishAdd(){
		return Action.SUCCESS;
	}
	
	public String showDishEdit(){
		return Action.SUCCESS;
	}
	
	public String doDishEdit(){
		return Action.SUCCESS;
	}
	
	public String showDishType(){
		return Action.SUCCESS;
	}
	
	public String doDishTypeAdd(){
		return Action.SUCCESS;
	}
	
	//菜品分类的编辑页面由页面JS完成
	public String doDishTypeEdit(){
		return Action.SUCCESS;
	}
	
	public String doDishTypeDelete(){
		return Action.SUCCESS;
	}

}
