package com.fan1tuan.shop.pojos;

import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;
import com.fan1tuan.general.util.Constants;

public class ShopGeo extends EntityObject{
	private Shop content;
	private double distance;
	private String isLike;
	
	private List<ShopTasteTag> shopTasteTags;
	
	
	
	public List<ShopTasteTag> getShopTasteTags() {
		return shopTasteTags;
	}
	public void setShopTasteTags(List<ShopTasteTag> shopTasteTags) {
		this.shopTasteTags = shopTasteTags;
	}
	public Shop getContent() {
		return content;
	}
	public void setContent(Shop content) {
		this.content = content;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public ShopGeo(){}
	
	public ShopGeo(Shop content, double distance){
		this.content = content;
		this.distance = distance;
		this.isLike = Constants.FALSE;
	}
	public ShopGeo(Shop content,double distance,String isLike){
		this.content = content;
		this.distance = distance;
		this.isLike = Constants.FALSE;
	}
	public String getIsLike() {
		return isLike;
	}
	public void setLike(String isLike) {
		this.isLike = isLike;
	}
	
}
