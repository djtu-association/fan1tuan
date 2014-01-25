package com.fan1tuan.order.ui.struts2.core;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.ShopItem;
import com.opensymphony.xwork2.Action;

public class OrderIndexAcition implements  SessionAware{
	//shopcart
	private ShoppingCartService shoppingCartService;
	
	
	//前台传来
	private String userId;
	private String shopId;
	private String shopItemId;//
	private String dishItemId;
	private String dishId;
	
	//传去前台
	private ArrayList<ShopItem> shopItems;//返回多个店的（多个菜品）
	private ArrayList<DishItem> dishItems;





	public String getDishItemId() {
		return dishItemId;
	}


	public void setDishItemId(String dishItemId) {
		this.dishItemId = dishItemId;
	}


	public String getDishId() {
		return dishId;
	}


	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	
	
	public String getShopItemId() {
		return shopItemId;
	}


	public void setShopItemId(String shopItemId) {
		this.shopItemId = shopItemId;
	}

	public String getShopId() {
		return shopId;
	}


	public void setShopId(String shopId) {
		this.shopId = shopId;
	}


	public ArrayList<DishItem> getDishItems() {
		return dishItems;
	}


	public void setDishItems(ArrayList<DishItem> dishItems) {
		this.dishItems = dishItems;
	}


	public String getUserId() {
		return userId;
	}


	public ArrayList<ShopItem> getShopItems() {
		return shopItems;
	}


	public void setShopItems(ArrayList<ShopItem> shopItems) {
		this.shopItems = shopItems;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	//根据userId,获取一个买家在在多个商店购买的多个菜品,返回shopItem
	public String getShopItemByUserId()
	{
		
		shopItems = (ArrayList<ShopItem>) shoppingCartService.getShopItemByUserId(userId);
		return Action.SUCCESS;
	  
	}
	//根据userId,shopId,获取一个买家在一个商店购买的多个菜品,返回对应的dishItem
	public String getDishItemsByUserIdByShopId()
	{
		dishItems = (ArrayList<DishItem>) shoppingCartService.getDishItemsByUserIdByShopId(userId, shopId);
		return Action.SUCCESS;
	}
	//删除一个shopItem
	public String removeOneShopItemByIdByShopId()
	{
		shoppingCartService.removeOneShopItemByIdByShopId(shopItemId, shopId);
		return Action.SUCCESS;
	}
	//删除一个shop对应的dishItem
	public String removeOneDishItemById()
	{
		shoppingCartService.removeOneDishItemById(dishItemId, shopId, dishId);
		return Action.SUCCESS;
	}

	public String execute()
	{
		
		return Action.SUCCESS;
	}
	
	
}
