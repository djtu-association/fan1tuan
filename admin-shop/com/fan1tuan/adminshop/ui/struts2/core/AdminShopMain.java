package com.fan1tuan.adminshop.ui.struts2.core;

import java.util.List;
import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.adminshop.util.AdminConstant;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.shop.pojos.Shop;
import com.opensymphony.xwork2.Action;

public class AdminShopMain extends Fan1TuanAction{

	private static final long serialVersionUID = 1L;
	
	//common params
	private AdminShopService adminShopService;
	
	private List<Shop> shopList;//出参
	public String showShopList(){
		setShopList(adminShopService.getShopsInPage(Pageable.inPage(0, AdminConstant.SHOPLIST_PAGESIZE)));
		return Action.SUCCESS;
	}
	//---------------------------
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

	
	
	
	
	
	//-------------getters and setters------------------

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	
	public AdminShopService getAdminShopService() {
		return adminShopService;
	}
	public void setAdminShopService(AdminShopService adminShopService) {
		this.adminShopService = adminShopService;
	}

}
