package com.fan1tuan.general.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.ShopItem;

public class CollectionUtil {
	public static <T> Set<T> transformListToSet(List<T> list){
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}
	
	public static ShopItem hasShopItem(ArrayList<ShopItem> shopItems, String shopId){
		for(ShopItem shopItem : shopItems){
			if(shopItem.getShopId().equals(shopId)){
				return shopItem;
			}
		}
		return null;
	}
	
	public static DishItem hasDishItem(ArrayList<DishItem> dishItems, String dishId){
		for(DishItem dishItem : dishItems){
			if(dishItem.getDishId().equals(dishId)){
				return dishItem;
			}
		}
		return null;
	}
}
