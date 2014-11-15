package com.fan1tuan.search.pojos;

import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopSearchItem extends EntityObject {
	private String shopId;
	private String shopName;

	// 实体店或者摊位
	private int type;
	// 电话或者在线
	private int orderType;

	private boolean open;
	
	private double deliveryCharge;
	private double avgDeliveryTime;
	private double avgPersonCost;
	
	private String cellphone;
	private String telephone;
	
	private int commentNum; //dish comments
	private double commentLevel; //dish comments now it is sum of the comment level, not the average
	private double avgCommentLevel;
	
	//string path of avatar: img file
	private String avatar;

	private List<DishSearchItem> dishSearchItems;
	
	
	
	public List<DishSearchItem> getDishSearchItems() {
		return dishSearchItems;
	}

	public void setDishSearchItems(List<DishSearchItem> dishSearchItems) {
		this.dishSearchItems = dishSearchItems;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public double getAvgDeliveryTime() {
		return avgDeliveryTime;
	}

	public void setAvgDeliveryTime(double avgDeliveryTime) {
		this.avgDeliveryTime = avgDeliveryTime;
	}

	public double getAvgPersonCost() {
		return avgPersonCost;
	}

	public void setAvgPersonCost(double avgPersonCost) {
		this.avgPersonCost = avgPersonCost;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public double getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(double commentLevel) {
		this.commentLevel = commentLevel;
	}

	public double getAvgCommentLevel() {
		return avgCommentLevel;
	}

	public void setAvgCommentLevel(double avgCommentLevel) {
		this.avgCommentLevel = avgCommentLevel;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
