package com.fan1tuan.shop.ui.struts2.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.NumberUtil;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.fan1tuan.shop.business.ShopUserService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopGeo;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class ShopAction extends Fan1TuanAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7024895986769446372L;

	public String getShopId() {
		return shopId;
	}
	public void setShopId(String id) {
		this.shopId = id;
	}	
	public String getMapUrl() {
		return mapUrl;
	}
	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public List<Dish> getTopDishes() {
		return topDishes;
	}
	public void setTopDishes(List<Dish> topDishes) {
		this.topDishes = topDishes;
	}
	public Map<String, Integer> getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(Map<String, Integer> commentLevel) {
		this.commentLevel = commentLevel;
	}
	public List<DishTasteTag> getDishTasteTags() {
		return dishTasteTags;
	}
	public void setDishTasteTags(List<DishTasteTag> dishTasteTags) {
		this.dishTasteTags = dishTasteTags;
	}
	
	
	public boolean isLikeShop() {
		return likeShop;
	}
	public void setLikeShop(boolean likeShop) {
		this.likeShop = likeShop;
	}
	public List<Dish> getFavoredDishes() {
		return favoredDishes;
	}
	public void setFavoredDishes(List<Dish> favoredDishes) {
		this.favoredDishes = favoredDishes;
	}
	public ShoppingCart getCart() {
		return cart;
	}
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	public Map<String, List<Dish>> getDishes() {
		return dishes;
	}
	public void setDishes(Map<String,List<Dish>> dishes) {
		this.dishes = dishes;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	//service类
	private ShopUserService shopUserService;
	private ShoppingCartService shoppingCartService;
	private UserService userService;
	public ShopUserService getShopUserService() {
		return shopUserService;
	}
	public void setShopUserService(ShopUserService shopUserService) {
		this.shopUserService = shopUserService;
	}
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
	
	/*
	**-----------------/shop/index.f1t -------------action方法开始
	*/
	//入参
	private String shopId;   //shop的ID
	//出参
	private Shop shop;      //shop实体，基本信息
	private boolean likeShop;
	private double distance; //距离
	private Map<String, List<Dish>> dishes; //以才菜品标签分割的菜品映射
	private ShoppingCart cart; //购物车实体
	private List<DishTasteTag> dishTasteTags;
	private Map<String, Integer> commentLevel; //店铺的评价星级分布
	private List<Dish> topDishes;  //当前店铺的前排菜品
	private String mapUrl;  //地图的动态url
	private List<Dish> favoredDishes;
	
	public String execute(){
		//session.put("guest", true);
		
		if(shopId==null||shopId.equals("")){
			return Action.ERROR;
		}
		
		Map<String,Object> user_cache = SessionUtil.getUser(session);
		Map<String, Object> area_cache = SessionUtil.getArea(session);
		
		String areaId = (String)area_cache.get(ISession.AREAID);

		ShopGeo shopGeo = shopUserService.getShopGeo(shopId, areaId);
		likeShop = false;
		if(user_cache!=null){
			cart=shoppingCartService.getShoppingCartByUserId((String)user_cache.get(ISession.USER_ID));
			favoredDishes = userService.getFavoriteInShop((String)user_cache.get(ISession.USER_ID), shopId);
			likeShop = userService.isLikeShop((String)user_cache.get(ISession.USER_ID), shopId);
		}

		if(shopGeo==null){
			return Action.ERROR;
		}
		
		shop = shopGeo.getContent();
		distance = NumberUtil.reserveBit(shopGeo.getDistance(),1);
		
		if(shop==null){
			return Action.ERROR;
		}
		
        dishTasteTags=shopUserService. getShopDishesTastes(shopId);
        List<Dish> list = shopUserService.getDishMenu(shopId);
		dishes = new HashMap<String, List<Dish>>();
		
		for(Dish dish : list){
			List<Dish> temp = dishes.get(dish.getDishTasteTagId());
			if(temp==null){
				temp = new ArrayList<Dish>();
			}
			temp.add(dish);
			dishes.put(dish.getDishTasteTagId(), temp);
		}

		commentLevel = shopUserService.getSimpleShopComments(shopId);
		topDishes = shopUserService.getTopRecDishesInShop(shopId);
		mapUrl = shopUserService.getShopStaticMap(shopId);
		
//		
//		for(Map.Entry<String, Integer> entry : commentLevel.entrySet()){
//			System.out.println("Key:"+entry.getKey()+"\tValue:"+entry.getValue());
//		}
//		
		return Action.SUCCESS;
	}
	

	
}
