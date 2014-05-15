package com.fan1tuan.adminshop.business;

import java.util.List;
import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopTasteTag;

public interface AdminShopService extends IFan1TuanService {
	//获取店铺列表/分页
	public List<Shop> getShopsInPage(Pageable pageable);
	//添加新的店铺
	public void addNewShop(Shop shop);
	//获取店铺口味标签
	public List<ShopTasteTag> getShopTasteTags();
	//添加新的口味标签
	public void addNewShopTasteTag(ShopTasteTag shopTasteTag);
	//保存编辑的口味标签
	public void saveShopTasteTagEdit(ShopTasteTag shopTasteTag);
	//删除一个口味标签
	public void deleteShopTasteTagByTagId(String tagId);
	//获取一个店铺
	public Shop getOneShopByShopId(String shopId);
	//保存编辑后的店铺
	public void saveShopEdit(Shop shop);
	//删除一个店铺：根据shopId
	public void deleteShopByShopId(String shopId);
	//获取店铺订单列表：根据shopId/分页
	public List<Order> getShopOrdersByShopIdInPage(String shopId,Pageable pageable);
	//删除一个店铺订单：根据orderId
	public void deleteShopOrderByOrderId(String orderId);
	//获取菜品列表：根据shopId/分页
	public List<Dish> getShopDishsByShopIdInPage(String shopId,Pageable pageable);
	//添加新的菜品
	public void addNewDish(Dish dish);
	//获取一个菜品
	public Dish getOneDishByDishId(String dishId);
	//保存编辑后的菜品
	public void saveDishEdit(Dish dish);
	//删除一个菜品：根据dishId
	public void deleteDishByDishId(String dishId);
	//获取菜品分类：根据shopId
	public List<DishTasteTag> getDishTasteTagsByShopId(String shopId);
	//添加新的菜品分类
	public void addNewDishTasteTag(DishTasteTag dishTasteTag);
	//保存编辑后的菜品分类
	public void saveDishTasteTagEdit(DishTasteTag dishTasteTag);
	//删除一个菜品分类：根据tagId
	public void deleteDishTasteTagByTagId(String tagId);
	
	//获取分页
	public long getShopPageCount(int pageSize);
	
	public long getOrderPageCount(String shopId,int pageSize);
	
	public long getDishPageCount(String shopId,int pageSize);

}
