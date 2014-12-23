package com.fan1tuan.shop.pojos;

import java.util.ArrayList;
import java.util.Date;
import com.fan1tuan.general.pojos.EntityObject;

public class Dish extends EntityObject{
	private String id;
	private String shopId;
	
	private ArrayList<String> rankTagIds;
	private String dishTasteTagId;
	
	private String name;
	private double price;
	private double originPrice;
	private int saleVolume;
	
	private String image;
	private int commentNum;
	private double commentLevel; //now it is sum of the comment level, not the average
	private double avgCommentLevel;
	
	private int status; //0可预定,1不可预订
	private String description;
	
	private Date createTime;
	
	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgCommentLevel() {
		return avgCommentLevel;
	}

	public void setAvgCommentLevel(double avgCommentLevel) {
		this.avgCommentLevel = avgCommentLevel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public ArrayList<String> getRankTagIds() {
		return rankTagIds;
	}

	public void setRankTagIds(ArrayList<String> rankTagIds) {
		this.rankTagIds = rankTagIds;
	}

	public String getDishTasteTagId() {
		return dishTasteTagId;
	}

	public void setDishTasteTagId(String dishTasteTagId) {
		this.dishTasteTagId = dishTasteTagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}

	public int getSaleVolume() {
		return saleVolume;
	}

	public void setSaleVolume(int saleVolume) {
		this.saleVolume = saleVolume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	

	public Dish(String shopId, ArrayList<String> rankTagIds, String dishTasteTagId,
			String name, double price, double originPrice, int saleVolume,
			String image, int commentNum, double commentLevel, double avgCommentLevel, 
			int status, String description) {
		super();
		this.shopId = shopId;
		this.rankTagIds = rankTagIds;
		this.dishTasteTagId = dishTasteTagId;
		this.name = name;
		this.price = price;
		this.originPrice = originPrice;
		this.saleVolume = saleVolume;
		this.image = image;
		this.commentNum = commentNum;
		this.commentLevel = commentLevel;
		this.avgCommentLevel = avgCommentLevel;
		this.status = status;
		this.description = description;
	}
	
	public Dish() {}
}
