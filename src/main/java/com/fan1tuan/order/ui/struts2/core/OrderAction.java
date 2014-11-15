package com.fan1tuan.order.ui.struts2.core;

import java.util.List;
import java.util.Map;

import com.fan1tuan.general.pojos.dto.DateWrapper;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.user.business.UserAddressService;
import com.fan1tuan.user.business.UserService;

public class OrderAction extends Fan1TuanAction{

	private UserService userService;
	private UserAddressService userAddressService;
	private ShoppingCartService shoppingCartService;
	
	
	public UserAddressService getUserAddressService() {
		return userAddressService;
	}

	public DateWrapper getNow() {
		return now;
	}

	public void setNow(DateWrapper now) {
		this.now = now;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public void setUserAddressService(UserAddressService userAddressService) {
		this.userAddressService = userAddressService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getSumDishNum() {
		return sumDishNum;
	}

	public void setSumDishNum(int sumDishNum) {
		this.sumDishNum = sumDishNum;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6503326022306151641L;

	/**
	 * ------------------------/order/index.f1t------------------
	 */
	//in
	private String shopId;
	private String shopName;
	//out
	private List<Order> orders;
	private double sumPrice = 0;
	private int sumDishNum = 0;
	private DateWrapper now;
	public String execute(){
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		orders = shoppingCartService.createNewOrders(userId);
		
		for(Order order : orders){
			sumPrice += order.getPrice();
			for(DishItem dishItem : order.getDishItems()){
				sumDishNum += dishItem.getNumber();
			}
		}
		
		now = new DateWrapper();
		
		return SUCCESS;
	}
	
	/**
	 * -------------------/order/result.f1t-------------------
	 */
	public String getOrderResult(){
		
		return SUCCESS;
	}
}
