package com.fan1tuan.general.ui.struts2.core;

import java.util.HashMap;
import java.util.List;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class IndexAjaxAction extends Fan1TuanAction{
	
	//service dao
	private UserService userService;
	//index ajax
	private String shopId;
	private String dishId;
	private String ajaxResult;
	private List<Dish> dishes;
	
	/**
	 * Ajax添加店铺收藏
	 * @return:
	 */
	@SuppressWarnings("unchecked")
	public String AjaxAddFavoriteShop()
	{
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			userService.addFavouriteShops(userId, shopId);
			setAjaxResult("true");
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxResult("false");
			return Action.ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	public String AjaxAddFavoriteDish()
	{
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			userService.addFavouriteDishes(userId, dishId);
			setAjaxResult("true");
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxResult("false");
			return Action.ERROR;
		}
	}
	@SuppressWarnings("unchecked")
	public String AjaxGetFavoriteInShop(){
		//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
		HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
		String userId = (user == null)?null:user.get(ISession.USER_ID);
		setDishes(userService.getFavoriteInShop(userId, shopId));
		setAjaxResult("true");
		return Action.SUCCESS;
		
		
	}
	
	//-------------------------getter and setter--------------------------------------
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getAjaxResult() {
		return ajaxResult;
	}
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	public List<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}	
	
}	
