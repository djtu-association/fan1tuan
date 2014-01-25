package com.fan1tuan.shop.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;

public interface DishClientService extends IFan1TuanService{
	public boolean addDishToShop(Dish dish, String shopId);
	
	public boolean updateDishInfoOfShop(Dish dish, String dishId, String shopId);
	
	public boolean setDishTasteTagId(String dishTasteTag, String dishId);
		
	public Dish getDishOfShop(String dishId, String shopId);
	
	public List<DishComment> getDishCommentsOfDish(String dishId);
	
	public boolean setDishStatus(int status, String dishId);
	
	public boolean removeDishFromShop(String dishId, String shopId);
}
