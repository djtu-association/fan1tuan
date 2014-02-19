package com.fan1tuan.user.ui.struts2.core;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.order.business.OrderUserService;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.User;

public class UserAction extends Fan1TuanAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5139229021131179900L;



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

	public String execute() {
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		String userId = (String)user_cache.get(ISession.USER_ID);
		
		//判断是否为早上
		Date now = new Date();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(now);
		if(gregorianCalendar.get(Calendar.HOUR_OF_DAY)>18||gregorianCalendar.get(Calendar.HOUR_OF_DAY)<6){
			morning = false;
		}else{
			morning = true;
		}
		
		
		//获取用户信息
		user = userService.getUser(userId);
		
		//获取订单信息
		orders = orderUserService.getAllOrdersByUserIdInOrderInPage(userId, Pageable.inPage(pageNumber, pageSize),Sortable.instance("date", Sortable.DESCEND));
		
		return "success";
	}
	
	
	
}
