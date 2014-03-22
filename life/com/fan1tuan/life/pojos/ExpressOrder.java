package com.fan1tuan.life.pojos;

import java.sql.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class ExpressOrder extends EntityObject{
	
	private String id;
	
	private String clientId;//代取商ExpressClient的ID
	
	private String username;
	
	private String cellphone;
	
	private String address;
	
	private String expressName;//目标快递公司：顺丰等等
	
	private String remark;//用户备注
		
	private Date createtime;
	
	private Date completeTime;
	
	private int status;//订单状态：1等待处理，2等待领取，3已领取，4已完成
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public ExpressOrder(){}
	
	public ExpressOrder(String id,String clientId,String username,String cellphone,String address,
			String expressName,String remark,Date createtime,Date completeTime,int status){
		super();
		this.id = id;
		this.clientId = clientId;
		this.username = username;
		this.cellphone = cellphone;
		this.address = address;
		this.expressName = expressName;
		this.remark = remark;
		this.createtime = createtime;
		this.completeTime = completeTime;
		this.status = status;
		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
