package com.fan1tuan.user.business;

import java.util.ArrayList;

import com.fan1tuan.user.pojos.FavoriteShop;

public interface UserShopService {
	public boolean addFavoriteShops(String userId, ArrayList<FavoriteShop> shops);
	
	public boolean deleteFavoriteShops(String userId, ArrayList<FavoriteShop> shops);
	
	public boolean updateFavoriteShops(String userId, ArrayList<FavoriteShop> shops);
	
	public ArrayList<FavoriteShop> findFavoriteShops(String userId);
}
