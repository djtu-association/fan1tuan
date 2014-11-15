/**
 *@Author:
 *@Class:
 *@Params:
 */
package com.fan1tuan.order.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;

/**
 * @author JOE
 *
 */
public interface ShoppingCartService extends IFan1TuanService {
	
	ShoppingCart getShoppingCartById(String id);
	
	ShoppingCart getShoppingCartByUserId(String userId);
	
	List<ShopItem> getShopItemById(String id);
	
	List<ShopItem> getShopItemByUserId(String userId);//获取购物车中 的 shopItem
	
	List<DishItem> getAllDishItemsById(String id);
	
	List<DishItem> getAllDishItemsByUserId(String userId);
	
	List<DishItem> getDishItemsByIdByShopId(String id,String shopId);
	
	List<DishItem> getDishItemsByUserIdByShopId(String userId,String shopId);//可能是多个shopId
	
	boolean addOneShopItemToCartById(String id,ShopItem shopItem);
	
	boolean addOneShopItemToCartByUserId(String userId,ShopItem shopItem);
	
	boolean addShopItemsToCartById(String id,ShopItem... shopItems);

	boolean addShopItemsToCartByUserId(String userId,ShopItem... shopItems);
	
	boolean removeOneShopItemByIdByShopId(String id,String shopId);//从购物车删除一个ShopItem（当然也包含了里面的DishItem） use
	
	boolean removeOneShopItemByUserIdByShopId(String userId,String shopId);//?
	
	boolean addOneDishItem(String id,String shopId,DishItem dishItem);//添加一个dishItem到shopItem
	
	boolean addDishItems(String id,String shopId,List<DishItem> dishItems);//添加多个dishItem到购物车对应的商家（shopItem）
	
	boolean removeOneDishItemById(String id,String shopId,String dishId);//从购物车删除一个DishItem use
	
	boolean upsertDishitemNumberById(String id,String shopId,String dishId,int number);//更新DishItem的number 购买单个商品个数
	
	boolean upsertDishItemNumberByUserId(String userId,String shopId,String dishId,int number);//更新DishItem的number
	
	boolean increaseDishItemNumberByIdByShopIdByDishId(String id,String shopId,String dishId);//增加一个DishItem的number（增加1）
	
	boolean increaseDishItemNumberByUserIdByShopIdByDishId(String userId,String shopId,String dishId);
	
	boolean decreaseDishItemNumberByIdByShopIdByDishId(String id,String shopId,String dishId);//DishItem的Number减少1
	
	boolean decreaseDishItemNumberByUserIdByShopIdByDishId(String userId,String shopId,String dishId);
	
	boolean cleanShoppingCartById(String id);//清空购物车
	
	boolean cleanShoppingCartByUserId(String userId);//清空购物车
	
	boolean saveShopingCart(ShoppingCart shoppingCart);//插入/保存购物车
	
	double getTotalPriceById(String id);//获取订单总额
	
	double getTotalPriceByUserId(String userId);
	
	//-------
	/**
	 * 提交订单
	 * @param userId
	 * @param order
	 * @return
	 */
	List<Order> createNewOrders(String userId);//点击提交订单，调用此方法（根据每个商家生个各自对应的订单，即一个商家一个订单）
	
	/**
	 * 根据shopId和dishId删除一个dishItem
	 * @param userId
	 * @param shopId
	 * @param dishId
	 * @return
	 */
	boolean removeOneDishItemByUserId(String userId,String dishId);
	
	/**
	 * 根据dishId添加一个DishItem，先找到shopId，判断shopItem是否已经存在
	 * @return
	 */
	boolean addOneDishToCartByUserId(String userId,String dishId);
	
	/**
	 * 根据userId删除当前用户购物车
	 * @param userId
	 * @return
	 */
	boolean removeShoppingCartByUserId(String userId);
	
	
	boolean evaluateShoppingCart(String userId);
	
}
