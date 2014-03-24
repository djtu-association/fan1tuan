package com.fan1tuan.life.ui.struts2.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.DateUtil;
import com.fan1tuan.life.business.ExpressService;
import com.fan1tuan.life.pojos.ExpressOrder;
import com.opensymphony.xwork2.Action;

public class ExpressMainAction extends Fan1TuanAction {
	
	private static final long serialVersionUID = 1L;
	//static final
	private static final int CHECK_PAGESIZE = 20;
	//common-param
	private ExpressService expressService;
	private List<ExpressOrder> expressOrders;
	private String checkPhone;
	
	public String showExpress(){
		return Action.SUCCESS;
	}
	
	public String showExpressCheck(){
		setExpressOrders(expressService.getUserExpressOrders(getCheckPhone(), Pageable.inPage(0, 1)));
		setSuccessTips("手机号:"+getCheckPhone()+" 快递代取订单提交成功");
		return Action.SUCCESS;
	}
	
	//--------------添加新快递单---------------
	private String username;//param-in
	private String cellphone;//param-in
	private String address;//param-in
	private String expressName;//param-in
	private String remark;//param-in
	private String successTips;//param-out
	public String doAddNewOrder() throws Exception{
		ExpressOrder expressOrder = new ExpressOrder();
		expressOrder.setAddress(getAddress());
		expressOrder.setCellphone(getCellphone());
		expressOrder.setExpressName(getExpressName());
		expressOrder.setStatus(1);
		expressOrder.setUsername(getUsername());
		expressOrder.setRemark(getRemark());
		expressOrder.setCreatetime(new Date());
		expressOrder.setDate(DateUtil.format(new Date(), DateUtil.get8charDateFormat()));
		expressService.addNewExpressOrder(expressOrder);
		//set experessOrder
		/*
		ArrayList<ExpressOrder> list = new ArrayList<>();
		list.add(expressOrder);
		setExpressOrders(list);
		//set successTips
		setSuccessTips("手机号:"+getCellphone()+" 快递代取订单提交成功");
		*/
		setCheckPhone(getCellphone());
		return Action.SUCCESS;
	}
	
	
	//------------根据手机号搜索快递单-------------
	private String searchCellPhone;
	public String doSearchOrders(){
		setExpressOrders(expressService.getUserExpressOrders(getSearchCellPhone(), Pageable.inPage(0,CHECK_PAGESIZE)));
		return Action.SUCCESS;
	}

	
	
	
	
	//-----------------get and set-------------
	public ExpressService getExpressService() {
		return expressService;
	}

	public void setExpressService(ExpressService expressService) {
		this.expressService = expressService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public List<ExpressOrder> getExpressOrders() {
		return expressOrders;
	}


	public void setExpressOrders(List<ExpressOrder> expressOrders) {
		this.expressOrders = expressOrders;
	}





	public String getSearchCellPhone() {
		return searchCellPhone;
	}

	public void setSearchCellPhone(String searchCellPhone) {
		this.searchCellPhone = searchCellPhone;
	}

	public String getSuccessTips() {
		return successTips;
	}

	public void setSuccessTips(String successTips) {
		this.successTips = successTips;
	}

	public String getCheckPhone() {
		return checkPhone;
	}

	public void setCheckPhone(String checkPhone) {
		this.checkPhone = checkPhone;
	}

	
	
}
