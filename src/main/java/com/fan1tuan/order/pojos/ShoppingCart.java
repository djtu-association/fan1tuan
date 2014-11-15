package com.fan1tuan.order.pojos;

import java.util.ArrayList;

import com.fan1tuan.general.pojos.EntityObject;

public class ShoppingCart extends EntityObject {
	private String id;
	private String userId;
	private ArrayList<ShopItem> shopItems;
	private double price;
	private int itemNum;//份数
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<ShopItem> getShopItems() {
		return shopItems;
	}
	public void setShopItems(ArrayList<ShopItem> shopItems) {
		this.shopItems = shopItems;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ShoppingCart(String userId, ArrayList<ShopItem> shopItems, double price) {
		super();
		this.userId = userId;
		this.shopItems = shopItems;
		this.price = price;
	}
	
	public ShoppingCart() {}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
}
