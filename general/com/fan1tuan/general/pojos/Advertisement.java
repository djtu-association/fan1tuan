package com.fan1tuan.general.pojos;

import java.sql.Date;

public class Advertisement extends EntityObject {
	private String id;
	private String name;
	private String link;
	private String description;
	private String title;
	private String content;
	private String image;
	private Date startDate;
	private Date endDate;
	private double price;//仅对商家投放广告有效
	private int type;//可以是我们自己投放的，也可以商铺投放的
	private int useflag;//是否在使用中，0否，1是
	private int delflag;//删除标志，1未删除
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUseflag() {
		return useflag;
	}
	public void setUseflag(int useflag) {
		this.useflag = useflag;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	
	
}
