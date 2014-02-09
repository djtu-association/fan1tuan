package com.fan1tuan.user.ui.struts2.core;

import java.util.List;
import java.util.Map;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class UserAjaxAction extends Fan1TuanAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2793076353887105436L;

	private ShoppingCartService shoppingCartService;
	private UserService userService;
	
	
	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

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

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
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


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * ---------------/user/ajax/ajaxGetShoppingCart.f1t -------------------
	 */
	//out
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
	//in
	private String dishId;
	//out
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
	//in
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
	
	
	
	/**
	 * --------------------/user/ajax/ajaxAddFavoriteShop.f1t ---------------
	 * @return
	 */
	//in
	//private String shopId;
	public String addFavoriteShop()
	{
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		flag = makeFlag(userService.addFavouriteShops(userId, shopId));

		return SUCCESS;
	}
	
	/**
	 * --------------------/user/ajax/ajaxAddFavoriteDish.f1t ---------------
	 * @return
	 */
	//in
	//private String dishId;
	public String addFavoriteDish()
	{
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		flag = makeFlag(userService.addFavouriteDishes(userId, dishId));
		
		return SUCCESS;
	}
	
	
	/**
	 * --------------------/user/ajax/ajaxRemoveFavoriteDish.f1t ---------------
	 * @return
	 */
	//in
	//private String dishId;
	public String removeFavoriteDish()
	{
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		flag = makeFlag(userService.removeFavoriteDishes(userId, dishId));
		
		return SUCCESS;
	}
	
	
	/**
	 * --------------------/user/ajax/ajaxRemoveFavoriteShop.f1t ---------------
	 * @return
	 */
	//in
	//private String shopId;
	public String removeFavoriteShop(){
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		flag = makeFlag(userService.removeFavoriteShops(userId, shopId));
		
		return SUCCESS;
	}
	
	
	/**
	 * --------------------/user/ajax/ajaxGetFavoriteDishesInShop.f1t ---------------
	 * @return
	 */
	//in
	private String shopId;
	//out
	private List<Dish> dishes;
	public String getFavoriteDishesInShop(){
		//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
		Map<String, Object> user = SessionUtil.getUser(session);
		String userId = (String)user.get(ISession.USER_ID);
		dishes = userService.getFavoriteInShop(userId, shopId);
		
		flag = makeFlag(dishes);
		
		return Action.SUCCESS;
		
		
	}
	
	/**
	 * ----------------/user/ajax/secure/confirmOrder.f1t
	 * @return
	 */
	//in
	//out
	private String message;
	
	
	
}
