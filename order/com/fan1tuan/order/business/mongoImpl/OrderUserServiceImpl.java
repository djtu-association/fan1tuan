package com.fan1tuan.order.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.util.Constants.OrderStatus;
import com.fan1tuan.order.business.OrderUserService;
import com.fan1tuan.order.pojos.Order;

public class OrderUserServiceImpl implements OrderUserService{
	
	private OrderDao orderDao;

	@Override
	public List<Order> getAllOrdersByUserId(String userId) {
		List<Order> orderList = orderDao.findByParams(CriteriaWrapper.instance().is("userId", userId));
		return orderList;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getAllOrdersByUserIdInPage(String userId,
			Pageable pageable) {
		List<Order> orderList = orderDao.findByParamsInPage(CriteriaWrapper.instance().is("userId", userId), pageable);
		return orderList;
	}
	
	@Override
	public List<Order> getAllOrdersByUserIdInOrderInPage(String userId,Pageable pageable,Sortable sortable) {
		List<Order> orderList = orderDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("userId", userId), pageable,sortable);
		return orderList;
	}
	
	@Override
	public boolean saveOrder(Order order) {
		try {
			orderDao.add(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Order> getAllOrdersByUserIdByCriteriaWrapperInorderInpage(CriteriaWrapper criteriaWrapper, Pageable pageable,
			Sortable sortable) {
		List<Order> orderList = orderDao.findByParamsInPageInOrder(criteriaWrapper, pageable, sortable);
		return orderList;
	}

	@Override
	public long getCountByuserId(String userId) {		
		//return orderDao.getCount();
		return 0;
	}

	@Override
	public List<Order> getAllPendingOrdersByUserId(String userId) {
		
		return orderDao.findByParams(CriteriaWrapper.instance().is("userId", userId).lt("status", OrderStatus.USER_ACCEPT.ordinal()));
		
	}
	
	

}
