package com.fan1tuan.life.pojos;

import java.sql.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class ExpressOrder extends EntityObject{
	
	private String id;
	
	private String userId;
	
	private String instruction;
	
	private String cellphone;
	
	private String address;
	
	private String chargerId;//带领人ID
	
	private String chargerCellphone;//带领人手机
	
	private Date createtime;
	
	private Date completeTime;
	
	private int status;//订单状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
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

	public String getChargerId() {
		return chargerId;
	}

	public void setChargerId(String chargerId) {
		this.chargerId = chargerId;
	}

	public String getChargerCellphone() {
		return chargerCellphone;
	}

	public void setChargerCellphone(String chargerCellphone) {
		this.chargerCellphone = chargerCellphone;
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
	
	public ExpressOrder(String id,String userId,String instruction,String cellphone,String address,
			String chargerId,String chargerCellphone,Date createtime,Date completeTime,int status){
		super();
		this.id = id;
		this.userId = userId;
		this.instruction = instruction;
		this.cellphone = cellphone;
		this.address = address;
		this.chargerId = chargerId;
		this.chargerCellphone = chargerCellphone;
		this.createtime = createtime;
		this.completeTime = completeTime;
		this.status = status;
		
	}
}
