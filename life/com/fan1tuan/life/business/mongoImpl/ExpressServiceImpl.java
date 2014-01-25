package com.fan1tuan.life.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.ExpressClientDao;
import com.fan1tuan.general.dao.impl.ExpressOrderDao;
import com.fan1tuan.life.business.ExpressService;
import com.fan1tuan.life.pojos.ExpressClient;
import com.fan1tuan.life.pojos.ExpressOrder;
import com.fan1tuan.order.pojos.Order;

public class ExpressServiceImpl implements ExpressService {

	private ExpressOrderDao expressOrderDao;
	private ExpressClientDao expressClientDao;
	
	public ExpressOrderDao getExpressOrderDao() {
		return expressOrderDao;
	}

	public void setExpressOrderDao(ExpressOrderDao expressOrderDao) {
		this.expressOrderDao = expressOrderDao;
	}

	public ExpressClientDao getExpressClientDao() {
		return expressClientDao;
	}

	public void setExpressClientDao(ExpressClientDao expressClientDao) {
		this.expressClientDao = expressClientDao;
	}
	
	@Override
	public List<ExpressOrder> getAllOrders() {
		List<ExpressOrder> orderList = expressOrderDao.findAll();
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersInPage(Pageable pageable) {
		List<ExpressOrder> orderList = expressOrderDao.findAllInPage(pageable);
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersInOrderInPage(Sortable sortable,
			Pageable pageable) {
		List<ExpressOrder> orderList = expressOrderDao.findAllInPageInOrder(pageable, sortable);
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersByCriteriaWrapperInOrderInPage(
			CriteriaWrapper criteriaWrapper, Sortable sortable,
			Pageable pageable) {
		List<ExpressOrder> orderList = expressOrderDao.findByParamsInPageInOrder(criteriaWrapper, pageable, sortable);
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersByChargerId(String chargerId) {
		List<ExpressOrder> orderList = expressOrderDao.findByParams(CriteriaWrapper.instance().is("chargerId", chargerId));
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersByChargerIdInPage(String chargerId,
			Pageable pageable) {
		List<ExpressOrder> orderList = expressOrderDao.findByParamsInPage(CriteriaWrapper.instance().is("chargerId", chargerId), pageable);
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersByChargerIdInOrderInPage(
			String chargerId, Sortable sortable, Pageable pageable) {
		List<ExpressOrder> orderList = expressOrderDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("chargerId", chargerId), pageable, sortable);
		return orderList;
	}

	@Override
	public List<ExpressOrder> getAllOrdersByChargerIdByCriteriaWrapperInOrderInPage(
			String chargerId, CriteriaWrapper criteriaWrapper,
			Sortable sortable, Pageable pageable) {
		//the criteria "and" operation was override in CriteriaWrapper
		List<ExpressOrder> orderList = expressOrderDao.findByParamsInPageInOrder(criteriaWrapper.and("chargerId", chargerId), pageable, sortable);
		return orderList;
	}

	@Override
	public List<ExpressClient> getAllClients() {
		List<ExpressClient> clientList = expressClientDao.findAll();
		return clientList;
	}

	@Override
	public List<ExpressClient> getAllClientsInPage(Pageable pageable) {
		List<ExpressClient> clientList = expressClientDao.findAllInPage(pageable);
		return clientList;
	}
	
	@Override
	public boolean saveExpressOrder(ExpressOrder expressOrder) {
		try {
			if(expressOrder.getId() == null || expressOrder.getId() == "")
			{
				expressOrderDao.add(expressOrder);
			}
			else 
			{
				expressOrderDao.update(expressOrder);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeOneExpressOrderById(String expressOrderId) {
		try {
		expressOrderDao.delete(expressOrderId);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveExpressClient(ExpressClient expressClient) {
		try {
			if(expressClient.getId() == null || expressClient.getId() == "")
			{
				expressClientDao.add(expressClient);
			}
			else {
				expressClientDao.update(expressClient);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeOneExpressClientById(String expressClientId) {
		try {
			expressClientDao.delete(expressClientId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



}
