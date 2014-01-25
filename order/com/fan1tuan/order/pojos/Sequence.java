package com.fan1tuan.order.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class Sequence extends EntityObject {
	
	private String id;
	private String name;
	private int next_val;
	
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
	public int getNext_val() {
		return next_val;
	}
	public void setNext_val(int next_val) {
		this.next_val = next_val;
	}
	
}
