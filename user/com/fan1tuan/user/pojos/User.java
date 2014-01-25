package com.fan1tuan.user.pojos;

import java.util.ArrayList;

import com.fan1tuan.general.pojos.EntityObject;

public class User extends EntityObject{
	private String id;
	private String username;
	private String password;
	private String cellphone;
	private String email;
	private String realName;
	private String qq;
	private String image;
	private int level;
	private int credit;
	private ArrayList<FavoriteDish> favoriteDishes;
	private ArrayList<FavoriteShop> favoriteShops;
	private ArrayList<UserAddress> userAddresses;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public ArrayList<FavoriteDish> getFavoriteDishes() {
		return favoriteDishes;
	}
	public void setFavoriteDishes(ArrayList<FavoriteDish> favoriteDishes) {
		this.favoriteDishes = favoriteDishes;
	}
	public ArrayList<FavoriteShop> getFavoriteShops() {
		return favoriteShops;
	}
	public void setFavoriteShops(ArrayList<FavoriteShop> favoriteShops) {
		this.favoriteShops = favoriteShops;
	}
	public ArrayList<UserAddress> getUserAddresses() {
		return userAddresses;
	}
	public void setUserAddresses(ArrayList<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}
	
	
}
