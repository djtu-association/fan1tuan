package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class DishRec  extends EntityObject{
	private String dishId;
	private String description;
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DishRec(String dishId, String description) {
		super();
		this.dishId = dishId;
		this.description = description;
	}
	
	public DishRec() {}
}
