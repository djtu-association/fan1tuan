package com.fan1tuan.shop.pojos;

import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class DishComment  extends EntityObject{
	private String id;
	private String userId;
	private String userName;
	private String dishId;
	private String comment;
	private int commentLevel;
	private Date date;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DishComment(String userId, String dishId, String comment, int commentLevel,
			Date date) {
		super();
		this.userId = userId;
		this.comment = comment;
		this.commentLevel = commentLevel;
		this.date = date;
		this.dishId = dishId;
	}
	
	public DishComment() {}
}
