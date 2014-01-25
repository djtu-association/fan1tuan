package com.fan1tuan.user.pojos;

import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class FavoriteShop extends EntityObject{
	private String shopId;
	private Date date;
	private int status;//1使用中，0逻辑删除
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public FavoriteShop(String shopId, Date date, int status) {
		super();
		this.shopId = shopId;
		this.date = date;
		this.status = status;
	}
	
	public FavoriteShop() {}
}
