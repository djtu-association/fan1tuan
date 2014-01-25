package com.fan1tuan.user.ui.struts2.core;

import java.util.Map;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.opensymphony.xwork2.Action;

public class UserAjaxAction extends Fan1TuanAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2793076353887105436L;

	private ShoppingCartService shoppingCartService;

	
	
	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}


	/**
	 * ---------------/user/ajax/ajaxGetShoppingCart.f1t -------------------
	 */
	//出参
	private ShoppingCart cart;
	
	public String getShoppingCart(){
		Map<String,Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		cart = shoppingCartService.getShoppingCartByUserId(userId);
		flag = makeFlag(cart);
		return SUCCESS;
	}
	

	/**
	 * ---------------/user/ajax/secure/ajaxAddDishToCart.f1t -------------------
	 */
	//入参
	private String dishId;
	//出参
	//private ShoppingCart cart;
	public String addDishToCart(){
		Map<String,Object> user_cache = SessionUtil.getUser(session);
		
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		shoppingCartService.addOneDishToCartByUserId(userId, dishId);
					
		cart = shoppingCartService.getShoppingCartByUserId(userId);
		
		flag = makeFlag(cart);
		
		return SUCCESS;
		
	}
	
	/**
	 * ---------------/user/ajax/secure/ajaxRemoveDishFromCart.f1t -------------------
	 */
	//入参
	//private String dishId;
	//出参
	//private ShoppingCart cart;
	public String removeDishFromCart(){
		Map<String,Object> user_cache = SessionUtil.getUser(session);
		
		String userId = (String)user_cache.get(ISession.USER_ID);
			
		shoppingCartService.removeOneDishItemByUserId(userId, dishId);
						
		cart = shoppingCartService.getShoppingCartByUserId(userId);
		
		flag = makeFlag(cart);
		
		return Action.SUCCESS;
	}
	
	/**
	 * ---------------/user/ajax/secure/ajaxClearCart.f1t -------------------
	 */
	
	//出参
	//private ShoppingCart cart;
	public String clearCart(){
		Map<String,Object> user_cache = SessionUtil.getUser(session);
		
		String userId = (String)user_cache.get(ISession.USER_ID);
			
		flag = makeFlag(shoppingCartService.cleanShoppingCartByUserId(userId));
						
		return SUCCESS;
		
	}
}
