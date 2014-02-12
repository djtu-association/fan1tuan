package com.fan1tuan.order.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.order.pojos.Order;


public interface OrderUserService extends IFan1TuanService{
	
	
	
	/*
	public Order getOrderInfoByUserId(String userId);
	
	public boolean addDishToOrder(DishItem dishItem,String orderId);
	
	public boolean delDishFromOrder(String dishId,String orderId);
	
	public boolean dropOrdersByOrderIds(ArrayList<String> orderIds);
	
	public boolean dropOrderByOrderId(String orderId);
	
	public boolean dropOrderByUserId(String userId);
	
	public boolean saveShopcartToOrder(Order order);//transform the shoppingcart to order
	
	*/
	
	
	
	public List<Order> getAllOrdersByUserId(String userId);//获取用户所有订单
	
	public List<Order> getAllOrdersByUserIdInPage(String userId,Pageable pageable);//分页查找用户订单
	
	public List<Order> getAllOrdersByUserIdInOrderInPage(String userId,Pageable pageable,Sortable sortable);//分页排序获取订单
	
	public List<Order> getAllOrdersByUserIdByCriteriaWrapperInorderInpage(CriteriaWrapper criteriaWrapper,Pageable pageable,Sortable sortable);//criteria参数
	
	public List<Order> getAllPendingOrdersByUserId(String userId);
	
	public boolean saveOrder(Order order);//保存订单
	
	public long getCountByuserId(String userId);//获取用户订单数量
	
}
