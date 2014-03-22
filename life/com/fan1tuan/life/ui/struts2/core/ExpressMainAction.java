package com.fan1tuan.life.ui.struts2.core;

import java.util.List;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.life.business.ExpressService;
import com.fan1tuan.life.pojos.ExpressOrder;
import com.opensymphony.xwork2.Action;

public class ExpressMainAction extends Fan1TuanAction {
	
	private static final long serialVersionUID = 1L;
	//common-param
	private ExpressService expressService;
	private List<ExpressOrder> expressOrders;
	
	public String showExpress(){
		return Action.SUCCESS;
	}
	
	public String showExpressCheck(){
		return Action.SUCCESS;
	}
	
	//--------------添加新快递单---------------
	private String username;//param-in
	private String cellphone;//param-in
	private String address;//param-in
	private String expressName;//param-in
	private String remark;//param-in
	public String doAddNewOrder(){
		ExpressOrder expressOrder = new ExpressOrder();
		expressOrder.setAddress(getAddress());
		expressOrder.setCellphone(getCellphone());
		expressOrder.setExpressName(getExpressName());
		expressOrder.setStatus(1);
		expressOrder.setUsername(getUsername());
		expressOrder.setRemark(getRemark());
		//expressOrder.setCreatetime(DateUtil.now());
		expressService.addNewExpressOrder(expressOrder);
		return Action.SUCCESS;
	}
	
	
	//------------根据手机号搜索快递单-------------
	private String searchCellPhone;
	public String doSearchOrders(){
		setExpressOrders(expressService.getUserExpressOrders(getSearchCellPhone(), Pageable.inPage(0, 10)));
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
	
	
}
