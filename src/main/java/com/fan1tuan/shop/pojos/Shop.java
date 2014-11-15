package com.fan1tuan.shop.pojos;

import java.util.ArrayList;
import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class Shop  extends EntityObject{
	private String id;
	private String name;
	
	private ArrayList<String> rankTagIds;
	private ArrayList<String> shopAffairTagIds;
	private ArrayList<String> shopTasteTagIds;
	
	//实体店或者摊位
	private int type;
	//电话或者在线
	private int orderType;
	private int popularity;
	private int saleVolume;

	
	private String announcement;
	private String description;
	private double deliveryCharge;
	private double avgDeliveryTime;
	private double avgPersonCost;
	private String address;
	private double[] location;
	private String cellphone;
	private String telephone;
	
	private ArrayList<DishRec> dishRecs;
	private ArrayList<ShopSale> shopSales;
	
	
	
	private boolean open;
	private Date openTime;
	private Date closeTime;
	
	private int commentNum; //dish comments
	private double commentLevel; //dish comments now it is sum of the comment level, not the average
	private double avgCommentLevel;
	
	//string path of avatar: img file
	private String avatar;
	
	private Date createTime;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public double getAvgCommentLevel() {
		return avgCommentLevel;
	}
	public void setAvgCommentLevel(double avgCommentLevel) {
		this.avgCommentLevel = avgCommentLevel;
	}
	public int getSaleVolume() {
		return saleVolume;
	}
	public void setSaleVolume(int saleVolume) {
		this.saleVolume = saleVolume;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
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
	public ArrayList<String> getRankTagIds() {
		return rankTagIds;
	}
	public void setRankTagIds(ArrayList<String> rankTagIds) {
		this.rankTagIds = rankTagIds;
	}
	public ArrayList<String> getShopAffairTagIds() {
		return shopAffairTagIds;
	}
	public void setShopAffairTagIds(ArrayList<String> shopAffairTagIds) {
		this.shopAffairTagIds = shopAffairTagIds;
	}
	public ArrayList<String> getShopTasteTagIds() {
		return shopTasteTagIds;
	}
	public void setShopTasteTagIds(ArrayList<String> shopTasteTagIds) {
		this.shopTasteTagIds = shopTasteTagIds;
	}
	
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double[] getLocation() {
		return location;
	}
	public void setLocation(double[] location) {
		this.location = location;
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
	public ArrayList<DishRec> getDishRecs() {
		return dishRecs;
	}
	public void setDishRecs(ArrayList<DishRec> dishRecs) {
		this.dishRecs = dishRecs;
	}
	public ArrayList<ShopSale> getShopSales() {
		return shopSales;
	}
	public void setShopSales(ArrayList<ShopSale> shopSales) {
		this.shopSales = shopSales;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Shop() {}
}
