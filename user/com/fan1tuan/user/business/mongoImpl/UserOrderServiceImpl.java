package com.fan1tuan.user.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.user.business.UserOrderService;

public class UserOrderServiceImpl implements UserOrderService {
	
	private UserDao userDao;
	private OrderDao orderDao;
	
	@Override
	public List<Order> getAllOrderByUserIdInThisMonth(String userId) {
		return orderDao.findByParamsInOrder(CriteriaWrapper.instance().is("userId", userId), Sortable.instance("date", Sortable.DESCEND));
	}

	@Override
	public List<Order> getAllOrderByUserIdLastMonth(String userId) {
		orderDao.findByParamsInOrder(CriteriaWrapper.instance().is("userId", userId), Sortable.instance("date", Sortable.DESCEND));
		return null;
	}

	@Override
	public List<Order> getNotCommentOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getCancelOrdersByUserId(String userId) {	
		return orderDao.findByParamsInOrder(CriteriaWrapper.instance().is("userId", userId).is("status", 2), Sortable.instance("date", Sortable.DESCEND));
	}
	
	//--------------here is the getter and setter--------------

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
