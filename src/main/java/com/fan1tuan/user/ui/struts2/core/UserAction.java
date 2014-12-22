package com.fan1tuan.user.ui.struts2.core;

import java.util.*;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.OrderUserService;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishCommentDto;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.FavoriteShop;
import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.dto.FavoriteShopDto;

public class UserAction extends Fan1TuanAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5139229021131179900L;



	
	public List<DishCommentDto> getDishComments() {
		return dishComments;
	}

	public void setDishComments(List<DishCommentDto> dishComments) {
		this.dishComments = dishComments;
	}

	public List<Dish> getFavoriteDishes() {
		return favoriteDishes;
	}

	public void setFavoriteDishes(List<Dish> favoriteDishes) {
		this.favoriteDishes = favoriteDishes;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isMorning() {
		return morning;
	}

	public void setMorning(boolean morning) {
		this.morning = morning;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderUserService getOrderUserService() {
		return orderUserService;
	}

	public void setOrderUserService(OrderUserService orderUserService) {
		this.orderUserService = orderUserService;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	

	public List<FavoriteShopDto> getFavoriteShopDtos() {
		return favoriteShopDtos;
	}

	public void setFavoriteShopDtos(List<FavoriteShopDto> favoriteShopDtos) {
		this.favoriteShopDtos = favoriteShopDtos;
	}



	// service dao
	private UserService userService;
	private OrderUserService orderUserService;

	/**
	 * user用户页面主页 ------/user/index.f1t
	 */
	//out
	private boolean morning;
	private User user;
	private int pageNumber;
	private int pageSize;
	private List<Order> orders; //订单部分
	private List<FavoriteShopDto> favoriteShopDtos; //店铺收藏部分
	private List<Dish> favoriteDishes;
	private List<DishCommentDto> dishComments;
	public String execute() {
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		Map<String, Object> area_cache = SessionUtil.getArea(session);
		String areaId = (String)area_cache.get(ISession.AREAID);
		
		//判断是否为早上
		Date now = new Date();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(now);
		morning = !(gregorianCalendar.get(Calendar.HOUR_OF_DAY) > 18 || gregorianCalendar.get(Calendar.HOUR_OF_DAY) < 6);
		
		
		//获取用户信息
		user = userService.getUser(userId);
		
		//获取订单信息
		orders = orderUserService.getAllOrdersByUserIdInOrderInPage(userId, Pageable.inPage(pageNumber, pageSize),Sortable.instance("date", Sortable.DESCEND));
		
		//获取收藏部分
		favoriteShopDtos = userService.getFavoriteShopDtos(userId, areaId);

		//获取收藏的菜品
		favoriteDishes = userService.getFavoriteDishes(userId);
		
		//获取分页评价
		dishComments = userService.getAllUserCommentDtos(userId, 0, 20);
		
		return SUCCESS;
	}
	
	
	
}
