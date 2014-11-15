package com.fan1tuan.user.pojos;

import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class FavoriteDish extends EntityObject{
	private String dishId;
	private Date date;
	private int status;
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
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
	public FavoriteDish(String dishId, Date date, int status) {
		super();
		this.dishId = dishId;
		this.date = date;
		this.status = status;
	}
	
	public FavoriteDish() {}
}
