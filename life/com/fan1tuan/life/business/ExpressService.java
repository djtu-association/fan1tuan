/**
 * 
 */
package com.fan1tuan.life.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.life.pojos.ExpressClient;
import com.fan1tuan.life.pojos.ExpressOrder;

/**
 * @author JOE
 * 本地生活，快递板块
 *此处包含的 对ExpressOrder 和 ExpressClient的操作
 */
public interface ExpressService extends IFan1TuanService{

	List<ExpressOrder> getAllOrders();
	
	List<ExpressOrder> getAllOrdersInPage(Pageable pageable);
	
	List<ExpressOrder> getAllOrdersInOrderInPage(Sortable sortable,Pageable pageable);
	
	List<ExpressOrder> getAllOrdersByCriteriaWrapperInOrderInPage(CriteriaWrapper criteriaWrapper,Sortable sortable,Pageable pageable);//CriteriaWrapper添加条件，sortable,pageable
	
	List<ExpressOrder> getAllOrdersByChargerId(String chargerId);
	
	List<ExpressOrder> getAllOrdersByChargerIdInPage(String chargerId,Pageable pageable);
	
	List<ExpressOrder> getAllOrdersByChargerIdInOrderInPage(String chargerId,Sortable sortable,Pageable pageable);
	
	List<ExpressOrder> getAllOrdersByChargerIdByCriteriaWrapperInOrderInPage(String chargerId,CriteriaWrapper criteriaWrapper,Sortable sortable,Pageable pageable);
	
	List<ExpressClient> getAllClients();
	
	List<ExpressClient> getAllClientsInPage(Pageable pageable);
	
	boolean saveExpressOrder(ExpressOrder expressOrder);
	
	boolean removeOneExpressOrderById(String expressOrderId);
	
	boolean saveExpressClient(ExpressClient expressClient);
	
	boolean removeOneExpressClientById(String expressClientId);
}
