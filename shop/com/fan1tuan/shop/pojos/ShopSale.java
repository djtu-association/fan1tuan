package com.fan1tuan.shop.pojos;

import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class ShopSale  extends EntityObject{
	private String description;
	private String image;
	private Date startDate;
	private Date endDate;
	private String tips;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public ShopSale(String description, String image, Date startDate,
			Date endDate, String tips) {
		super();
		this.description = description;
		this.image = image;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tips = tips;
	}
	
	public ShopSale() {}
}
