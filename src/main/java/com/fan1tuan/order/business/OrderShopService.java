package com.fan1tuan.order.business;


import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.order.pojos.Order;

public interface OrderShopService extends IFan1TuanService{
	
	/*
	public List<Order> getAllOrderByShopId(String shopId,int limit,int skip);
	
	public List<Order> getAllOrderByShopIdByDate(String shopId,int limit,int skip,Date date);
	
	public Order getOrderInfoByOrderId(String orderId);
	
	public long getAmountOfOrderByShopByDate(String shopId,Date date);
	
	public long getAmountOfOrderByShop(String shopId);
	*/
	
	public List<Order> getAllOrdersByShopId(String shopId);//获取商铺的所有订单
	
	public List<Order> getAllOrdersByShopIdInPage(String shopId,Pageable pageable);//分页查找店铺所有订单
	
	public List<Order> getAllOrdersByShopIdInOrderInPage(String shopId,Pageable pageable,Sortable sortable);//根据过滤字段进行分页
	
	public List<Order> getAllOrdersByShopIdByCriteriaWrapperInOrderInPage(CriteriaWrapper criteriaWrapper,Pageable pageable,Sortable sortable);//criteriaWrapper参数	
	
	public int getCountByShopId(String shopId);//获取店铺订单的数量

}
