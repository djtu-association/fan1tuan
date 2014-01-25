package com.fan1tuan.shop.pojos;

import java.util.ArrayList;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopClient  extends EntityObject{
	private String id;
	private String username;
	private String password;
	private ArrayList<String> shopIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<String> getShopIds() {
		return shopIds;
	}
	public void setShopIds(ArrayList<String> shopIds) {
		this.shopIds = shopIds;
	}
	public ShopClient(String username, String password, ArrayList<String> shopIds) {
		super();
		this.username = username;
		this.password = password;
		this.shopIds = shopIds;
	}
	
	public ShopClient() {}
}
