package com.fan1tuan.user.business;

import java.util.List;

import com.fan1tuan.order.pojos.Order;

public interface UserOrderService {
	
	public List<Order> getAllOrderByUserIdInThisMonth(String userId);
	
	public List<Order> getAllOrderByUserIdLastMonth(String userId);
	
	public List<Order> getNotCommentOrdersByUserId(String userId);
	
	public List<Order> getCancelOrdersByUserId(String userId);
}
