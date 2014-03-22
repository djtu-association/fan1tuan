package com.fan1tuan.life.business.mongoImpl;

import java.util.Date;
import java.util.List;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.ExpressClientDao;
import com.fan1tuan.general.dao.impl.ExpressOrderDao;
import com.fan1tuan.life.business.ExpressService;
import com.fan1tuan.life.pojos.ExpressClient;
import com.fan1tuan.life.pojos.ExpressOrder;

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
	public void addNewExpressOrder(ExpressOrder expressOrder) {
		expressOrderDao.add(expressOrder);
	}

	@Override
	public List<ExpressOrder> getUserExpressOrders(String cellphone,Pageable pageable) {
		return expressOrderDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("cellphone", cellphone), pageable, Sortable.instance("createtime", 1));
	}

	@Override
	public List<ExpressOrder> getClientExpressOrders(int status,Date createtime, Pageable pageable) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance();
		criteriaWrapper = status==0?criteriaWrapper:criteriaWrapper.is("status", status);
		criteriaWrapper = createtime==null?criteriaWrapper:criteriaWrapper.is("createtime", createtime);
		return expressOrderDao.findByParamsInPageInOrder(criteriaWrapper, pageable, Sortable.instance("id", 1));
	}

	@Override
	public void clientUpdateOrderStatus(int status, Date today) {
		expressOrderDao.updateFirstByParams(CriteriaWrapper.instance().is("createtime", today), UpdateWrapper.instance().set("status", status));
	}

	@Override
	public void clientUpdateOrderStatus(int status, String orderId) {
		expressOrderDao.updateFirstByParams(orderId, UpdateWrapper.instance().set("status", status));
	}

	@Override
	public void updateClient(ExpressClient expressClient) {
		expressClientDao.update(expressClient);
	}
	


}
