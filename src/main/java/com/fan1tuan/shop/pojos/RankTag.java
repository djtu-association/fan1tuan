package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class RankTag extends EntityObject {
	private String id;
	private String name;
	private String description;
	int use;
	
	
	
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
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
	public RankTag(String name, String description, int use) {
		super();
		this.name = name;
		this.description = description;
		this.use = use;
	}
	
	public RankTag() {}
}
