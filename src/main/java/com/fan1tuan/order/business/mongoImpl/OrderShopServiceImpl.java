package com.fan1tuan.order.business.mongoImpl;


import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.order.business.OrderShopService;
import com.fan1tuan.order.pojos.Order;

public class OrderShopServiceImpl implements OrderShopService {
	
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getAllOrdersByShopId(String shopId) {
		List<Order> orderList = orderDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId));
		return orderList;
	}

	@Override
	public List<Order> getAllOrdersByShopIdInPage(String shopId,
			Pageable pageable) {
		List<Order> orderList = orderDao.findByParamsInPage(CriteriaWrapper.instance().is("shopId", shopId), pageable);
		return orderList;
	}

	@Override
	public List<Order> getAllOrdersByShopIdInOrderInPage(String shopId,
			Pageable pageable,Sortable sortable) {
		List<Order> orderList = orderDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("shopId", shopId), pageable, sortable);
		return orderList;
	}

	@Override
	public List<Order> getAllOrdersByShopIdByCriteriaWrapperInOrderInPage(
			CriteriaWrapper criteriaWrapper, Pageable pageable,
			Sortable sortable) {
		List<Order> orderList = orderDao.findByParamsInPageInOrder(criteriaWrapper, pageable, sortable);
		return orderList;
	}

	@Override
	public int getCountByShopId(String shopId) {
		
		return 0;
	}


}
