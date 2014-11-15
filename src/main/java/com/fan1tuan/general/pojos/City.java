package com.fan1tuan.general.pojos;

public class City extends EntityObject{
	private String id;
	private String name;
	private String[] areaIds;
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
	public String[] getAreaIds() {
		return areaIds;
	}
	public void setAreaIds(String[] areaIds) {
		this.areaIds = areaIds;
	}
	public City(String name, String[] areaIds) {
		super();
		this.name = name;
		this.areaIds = areaIds;
	}
	
	public City() {}
}
