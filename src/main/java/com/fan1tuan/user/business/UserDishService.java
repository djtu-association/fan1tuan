package com.fan1tuan.user.business;

import java.util.ArrayList;

import com.fan1tuan.user.pojos.FavoriteDish;

public interface UserDishService {
	public boolean addFavoriteDishes(String userId, ArrayList<FavoriteDish> dishes);
	
	public boolean deleteFavoriteDishes(String userId, ArrayList<FavoriteDish> dishes);
	
	public boolean updateFavoriteDishes(String userId, ArrayList<FavoriteDish> dishes);
	
	public ArrayList<FavoriteDish> findAllFavoriteDishes(String userId);
}
