package com.fan1tuan.order.pojos;

import java.util.ArrayList;
import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopItem extends EntityObject {
	private ArrayList<DishItem> dishItems;
	private String shopId;
	private String shopName;
	private double sumPrice;
	public ArrayList<DishItem> getDishItems() {
		return dishItems;
	}
	public void setDishItems(ArrayList<DishItem> dishItems) {
		this.dishItems = dishItems;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public ShopItem(ArrayList<DishItem> dishItems, String shopId, double sumPrice) {
		super();
		this.dishItems = dishItems;
		this.shopId = shopId;
		this.sumPrice = sumPrice;
	}
	
	public ShopItem() {}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
