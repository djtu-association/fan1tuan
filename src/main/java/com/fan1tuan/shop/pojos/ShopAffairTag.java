package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopAffairTag extends EntityObject {
	private String id;
	private String name;
	private String description;
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
	public ShopAffairTag(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public ShopAffairTag() {}
}
