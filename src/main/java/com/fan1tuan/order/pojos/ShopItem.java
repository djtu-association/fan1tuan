package com.fan1tuan.order.pojos;

import java.util.ArrayList;
import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopItem extends EntityObject {
	private ArrayList<DishItem> dishItems;
	private String shopId;
	private String shopName;
	private String shopAvatar;
	private double sumPrice;
	
	//新加字段，为了保证起送价限制与店铺的事务标签提醒
	private double deliveryCharge;
	private List<String> shopAffairTagIds;

	public String getShopAvatar() {
		return shopAvatar;
	}
	public void setShopAvatar(String shopAvatar) {
		this.shopAvatar = shopAvatar;
	}
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
	
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public List<String> getShopAffairTagIds() {
		return shopAffairTagIds;
	}
	public void setShopAffairTagIds(List<String> shopAffairTagIds) {
		this.shopAffairTagIds = shopAffairTagIds;
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
