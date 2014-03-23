package com.fan1tuan.adminexpress.ui.struts2.core;

import java.util.Date;
import java.util.List;

import com.fan1tuan.admin.dto.Page;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.DateUtil;
import com.fan1tuan.life.business.ExpressService;
import com.fan1tuan.life.pojos.ExpressOrder;
import com.opensymphony.xwork2.Action;

public class AdminExpressMain extends Fan1TuanAction {

	private static final long serialVersionUID = 1L;
	//constant param
	private static final int PAGESIZE = 50;
	private static final int STATUS_CONFIRM = 2;
	private static final int STATUS_FETCH = 3;
	private static final int STATUS_COMPLETE = 4;
	private static final int STATUS_REJECT = 5;
	//common params
	private ExpressService expressService;
	private List<ExpressOrder> expressOrders;
	private int expressPage;
	private Page expressListPage;
	private int status;
	
	public String showAdminExpressIndex(){
		return Action.SUCCESS;
	}
	//expressorders:param-out
	public String showHistoryOrders(){
		setExpressOrders(expressService.getClientExpressOrders(0, null, Pageable.inPage(getExpressPage(), PAGESIZE)));
		return Action.SUCCESS;
	}
	//expressorders:param-out
	public String showTodayOrders(){
		setExpressOrders(expressService.getClientExpressOrders(0, null, Pageable.inPage(getExpressPage(), PAGESIZE)));
		return Action.SUCCESS;
	}
	
	public String doConfirmAllToday(){
		expressService.clientUpdateTodayOrderStatus(STATUS_CONFIRM, DateUtil.format(new Date(), DateUtil.get8charDateFormat()));
		return Action.SUCCESS;
	}
	
	public String doFetchAllToday(){
		expressService.clientUpdateTodayOrderStatus(STATUS_FETCH, DateUtil.format(new Date(), DateUtil.get8charDateFormat()));
		return Action.SUCCESS;
	}
	
	public String doCompleteAllToday(){
		expressService.clientUpdateTodayOrderStatus(STATUS_COMPLETE, DateUtil.format(new Date(), DateUtil.get8charDateFormat()));
		return Action.SUCCESS;
	}
	
	//Ajax request
	private String orderId;
	private String result;
	public String doCheckStatus(){
		expressService.clientUpdateOrderStatus(STATUS_REJECT, getOrderId());
		setResult("success");
		return Action.SUCCESS;
	}

	
	
	//------------------get and set-----------------------------
	public ExpressService getExpressService() {
		return expressService;
	}

	public void setExpressService(ExpressService expressService) {
		this.expressService = expressService;
	}

	public int getExpressPage() {
		return expressPage;
	}

	public void setExpressPage(int expressPage) {
		this.expressPage = expressPage;
	}

	public Page getExpressListPage() {
		return expressListPage;
	}

	public void setExpressListPage(Page expressListPage) {
		this.expressListPage = expressListPage;
	}

	public List<ExpressOrder> getExpressOrders() {
		return expressOrders;
	}

	public void setExpressOrders(List<ExpressOrder> expressOrders) {
		this.expressOrders = expressOrders;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
