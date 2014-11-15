package com.fan1tuan.user.pojos.dto;

import com.fan1tuan.general.pojos.EntityObject;

/**
 * 相似店铺的推荐
 * @author apple
 *
 */

public class FavoriteShopRec extends EntityObject{
	private String imagePath;
	private String shopId;
	private String shopName;
	private String shopDescription;
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	public String getShopDescription() {
		return shopDescription;
	}
	public void setShopDescription(String shopDescription) {
		this.shopDescription = shopDescription;
	}
	
	
}
