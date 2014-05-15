package com.fan1tuan.search.pojos;

import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;

public class DishSearchItem extends EntityObject {
	private String dishId;
	private String dishName;
	
	private List<String> rankTagIds;
	
	private double price;
	private int saleVolume;
	private String image;
	private int commentNum;
	private double commentLevel; //now it is sum of the comment level, not the average
	private double avgCommentLevel;
	
	private int status; //0不可预定,1可预订

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public List<String> getRankTagIds() {
		return rankTagIds;
	}

	public void setRankTagIds(List<String> rankTagIds) {
		this.rankTagIds = rankTagIds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	
	
}
