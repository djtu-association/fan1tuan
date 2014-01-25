package com.fan1tuan.order.business.mongoImpl;

import java.util.ArrayList;
import java.util.List;

import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.order.business.OrderService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	private DishDao dishDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	

	@Override
	public Order getOneOrderByOrderId(String orderId) {
		Order order = orderDao.findOneById(orderId);
		return order;
	}

	@Override
	public List<Dish> getAllDishesInOrder(String orderId) {
		Order order = orderDao.findOneProjectedById(orderId, FieldFilter.instance("DishItem"));
		List<Dish> dishList = new ArrayList<Dish>();
		for(DishItem dishItem : order.getDishItems())
		{			
			dishList.add(dishDao.findOneById(dishItem.getDishId()));
		}
		return dishList;
	}

	@Override
	public boolean removeOneOrderByOrderId(String OrderId) {
		try {
			orderDao.delete(OrderId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveOrder(Order order) {
		try {
			if(order.getId() != null || order.getId() != "")
			{
				orderDao.update(order);
				return true;
			}
			orderDao.add(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isRight(){return true;}

}
