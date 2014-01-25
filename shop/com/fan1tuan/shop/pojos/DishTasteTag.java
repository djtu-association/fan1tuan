package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class DishTasteTag extends EntityObject {
	private String id;
	private String shopId;
	private String name;
	private String description;
	
	
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DishTasteTag(String name, String shopId, String description) {
		super();
		this.name = name;
		this.shopId = shopId;
		this.description = description;
	}
	
	public DishTasteTag() {}
}
