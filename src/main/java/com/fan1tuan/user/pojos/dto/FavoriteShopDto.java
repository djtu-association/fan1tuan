package com.fan1tuan.user.pojos.dto;

import java.util.Date;
import java.util.List;

import com.fan1tuan.general.pojos.EntityObject;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.ShopTasteTag;

/**
 * 这个类用来为用户界面的店铺收藏提供数据支持
 * @author Li He
 *
 */
public class FavoriteShopDto extends EntityObject{
	private String shopId;
	private String shopName;
	private String shopAvatar;

	private int orderType;
	
	private List<ShopTasteTag> shopTasteTags;
	private List<FavoriteShopRec> favoriteShopRecs;  //3个
	private Date date;
	
	
	private List<Dish> topDishes;  //4个
	private List<Dish> shopRecDishes; //4个
	private List<Dish> onceBoughtDishes; //4个

	public String getShopAvatar() {
		return shopAvatar;
	}

	public void setShopAvatar(String shopAvatar) {
		this.shopAvatar = shopAvatar;
	}

	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
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
	public List<ShopTasteTag> getShopTasteTags() {
		return shopTasteTags;
	}
	public void setShopTasteTags(List<ShopTasteTag> shopTasteTags) {
		this.shopTasteTags = shopTasteTags;
	}
	public List<FavoriteShopRec> getFavoriteShopRecs() {
		return favoriteShopRecs;
	}
	public void setFavoriteShopRecs(List<FavoriteShopRec> favoriteShopRecs) {
		this.favoriteShopRecs = favoriteShopRecs;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Dish> getTopDishes() {
		return topDishes;
	}
	public void setTopDishes(List<Dish> topDishes) {
		this.topDishes = topDishes;
	}
	public List<Dish> getShopRecDishes() {
		return shopRecDishes;
	}
	public void setShopRecDishes(List<Dish> shopRecDishes) {
		this.shopRecDishes = shopRecDishes;
	}
	public List<Dish> getOnceBoughtDishes() {
		return onceBoughtDishes;
	}
	public void setOnceBoughtDishes(List<Dish> onceBoughtDishes) {
		this.onceBoughtDishes = onceBoughtDishes;
	}
	
	
}
