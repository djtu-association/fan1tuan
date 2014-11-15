package com.fan1tuan.user.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class UserAddress extends EntityObject{
	private String areaId;
	private String receiver;
	private String detailAddress;
	private String cellphone;
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public UserAddress(String areaId, String receiver, String detailAddress,
			String cellphone) {
		super();
		this.areaId = areaId;
		this.receiver = receiver;
		this.detailAddress = detailAddress;
		this.cellphone = cellphone;
	}
	
	public UserAddress() {}
}
