package com.fan1tuan.order.business;

import java.util.List;
import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;

public interface OrderService extends IFan1TuanService {
	
	public Order getOneOrderByOrderId(String orderId);//获取一个订单信息
	
	public List<Dish> getAllDishesInOrder(String orderId); //订单中所有菜品
	
	public boolean removeOneOrderByOrderId(String OrderId);//删除一个订单
	
	public boolean saveOrder(Order order);//upsert 一个order
	
}
