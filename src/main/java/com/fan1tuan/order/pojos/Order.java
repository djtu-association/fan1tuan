package com.fan1tuan.order.pojos;

import java.util.ArrayList;
import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class Order extends EntityObject {
	private String id;
	private String orderNo;
	private String userId;
	private String shopId;  //用户提供
	private String shopName;
	private String shopAvatar;
	
	private ArrayList<DishItem> dishItems;  //用户提供部分，dishId, number
	
	private Date date;
	private double price; 
	private int status;
	private String address; //用户提供
	private String receiver;// 用户提供
	private Date deliveryTime;//用户提供
	private int chargeType;//用户提供
	private String cellphone;//用户提供
	private String telephone;
	//?
	private String description;
	//用户留言
	private String userRemark;  //用户提供

	public String getShopAvatar() {
		return shopAvatar;
	}
	public void setShopAvatar(String shopAvatar) {
		this.shopAvatar = shopAvatar;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public ArrayList<DishItem> getDishItems() {
		return dishItems;
	}
	public void setDishItems(ArrayList<DishItem> dishItems) {
		this.dishItems = dishItems;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getChargeType() {
		return chargeType;
	}
	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Order(String orderNo, String userId, String shopId,
			ArrayList<DishItem> dishItems, Date date, double price, int status,
			String address, Date deliveryTime, int chargeType,
			String cellphone, String telephone, String description) {
		super();
		this.orderNo = orderNo;
		this.userId = userId;
		this.shopId = shopId;
		this.dishItems = dishItems;
		this.date = date;
		this.price = price;
		this.status = status;
		this.address = address;
		this.deliveryTime = deliveryTime;
		this.chargeType = chargeType;
		this.cellphone = cellphone;
		this.telephone = telephone;
		this.description = description;
	}
	
	public Order() {}
	
}
