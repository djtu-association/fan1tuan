package com.fan1tuan.life.business.mongoImpl;

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
	public List<ExpressOrder> getClientExpressOrders(int status,String date, Pageable pageable) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance();
		criteriaWrapper = status==0?criteriaWrapper:criteriaWrapper.is("status", status);
		criteriaWrapper = date==null?criteriaWrapper:criteriaWrapper.is("date", date);
		return expressOrderDao.findByParamsInPageInOrder(criteriaWrapper, pageable, Sortable.instance("createtime", 1));
	}

	@Override
	public void clientUpdateTodayOrderStatus(int status, String today) {
		//expressOrderDao.updateFirstByParams(CriteriaWrapper.instance().is("date", today), UpdateWrapper.instance().set("status", status));
		if(status == 2){
			expressOrderDao.updateMultiByParams(CriteriaWrapper.instance().is("date", today).is("status", 1), UpdateWrapper.instance().set("status", status));
		}else if(status == 3){
			expressOrderDao.updateMultiByParams(CriteriaWrapper.instance().is("date", today).is("status", 2), UpdateWrapper.instance().set("status", status));
		}else{
			expressOrderDao.updateMultiByParams(CriteriaWrapper.instance().is("date", today).is("status", 3), UpdateWrapper.instance().set("status", status));
		}
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
