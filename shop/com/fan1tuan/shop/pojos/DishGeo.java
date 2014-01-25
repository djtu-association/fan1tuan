package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class DishGeo extends EntityObject {

	private Dish content;
	private String isLike;
	
	public String getIsLike() {
		return isLike;
	}
	public void setLike(String isLike) {
		this.isLike = isLike;
	}
	public Dish getContent() {
		return content;
	}
	public void setContent(Dish content) {
		this.content = content;
	}
	
	public DishGeo(Dish content,String isLike){
		this.content = content;
		this.isLike = isLike;
	}
	
	public DishGeo(){}
}
