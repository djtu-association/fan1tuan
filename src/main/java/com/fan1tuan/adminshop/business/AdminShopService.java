package com.fan1tuan.adminshop.business;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopClient;

import java.util.List;

public interface AdminShopService extends IFan1TuanService {
	public ShopClient signin(String username, String password);
	public ShopClient signup(String username, String password);

	public boolean changePassword(String userId, String password, String newPassword);

	// 一个方法，两个功能，升级shop或者创建shop，成功返回shop，失败返回null
	public Shop saveShop(String shopClientId, Shop shop);

	// 同上
	public DishTasteTag saveDishTasteTag(String shopClientId, DishTasteTag dishTasteTag);//判断店铺归属

	public Dish saveDish(String shopClientId, Dish dish);

	public boolean removeDishTasteTag(String shopClientId, String dishTasteId);//判断店铺归属

	public ShopClient fetchShopClient(String shopClientId);
	public Shop fetchShop(String shopClientId, String shopId); //判断店铺归属，然后fetch到
	public List<DishTasteTag> fetchDishTasteTags(String shopClientId, String shopId); // 同上
	public List<Dish> fetchDishes(String shopClientId, String shopId);
	public List<Order> fetchActiveOrders(String shopClientId, String shopId);
	public List<Order> fetchNonActiveOrders(String shopClientId, String shopId);

}
