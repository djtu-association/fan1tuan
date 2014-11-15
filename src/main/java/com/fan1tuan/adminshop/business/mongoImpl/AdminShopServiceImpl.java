package com.fan1tuan.adminshop.business.mongoImpl;

import java.util.List;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.DishTasteTagDao;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopTasteTag;

public class AdminShopServiceImpl implements AdminShopService{

	private ShopDao shopDao;
	private ShopTasteTagDao shopTasteTagDao;
	private OrderDao orderDao;
	private DishDao dishDao;
	private DishTasteTagDao dishTasteTagDao;
	
	@Override
	public List<Shop> getShopsInPage(Pageable pageable) {
		return shopDao.findAllInPageInOrder(pageable, Sortable.instance("createTime", 1));
	}

	@Override
	public void addNewShop(Shop shop) {
		shopDao.add(shop);
	}

	@Override
	public void addNewShopTasteTag(ShopTasteTag shopTasteTag) {
		shopTasteTagDao.add(shopTasteTag);
	}

	@Override
	public void saveShopEdit(Shop shop) {
		if(null != shop.getId() || !shop.getId().equals("")){
			shopDao.update(shop);
		}
	}

	@Override
	public void deleteShopByShopId(String shopId) {
		shopDao.delete(shopId);
	}

	@Override
	public List<Order> getShopOrdersByShopIdInPage(String shopId,Pageable pageable) {
		return orderDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("shopId", shopId), pageable, Sortable.instance("date", 1));
	}

	@Override
	public void deleteShopOrderByOrderId(String orderId) {
		orderDao.delete(orderId);
	}

	@Override
	public List<Dish> getShopDishsByShopIdInPage(String shopId,Pageable pageable) {
		return dishDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("shopId", shopId), pageable, Sortable.instance("createTime", 0));
	}

	@Override
	public void addNewDish(Dish dish) {
		dishDao.add(dish);
	}

	@Override
	public void saveDishEdit(Dish dish) {
		dishDao.update(dish);
	}

	@Override
	public void deleteDishByDishId(String dishId) {
		dishDao.delete(dishId);
	}

	@Override
	public List<DishTasteTag> getDishTasteTagsByShopId(String shopId) {
		return dishTasteTagDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId));
	}

	@Override
	public void addNewDishTasteTag(DishTasteTag dishTasteTag) {
		dishTasteTagDao.add(dishTasteTag);
	}

	@Override
	public void saveDishTasteTagEdit(DishTasteTag dishTasteTag) {
		dishTasteTagDao.update(dishTasteTag);
	}

	@Override
	public void deleteDishTasteTagByTagId(String tagId) {
		dishTasteTagDao.delete(tagId);
	}

	
	//params getters and setters
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public ShopTasteTagDao getShopTasteTagDao() {
		return shopTasteTagDao;
	}

	public void setShopTasteTagDao(ShopTasteTagDao shopTasteTagDao) {
		this.shopTasteTagDao = shopTasteTagDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}
	
	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}
	
	public DishTasteTagDao getDishTasteTagDao() {
		return dishTasteTagDao;
	}
	
	public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
		this.dishTasteTagDao = dishTasteTagDao;
	}

	@Override
	public Shop getOneShopByShopId(String shopId) {
		return shopDao.findOneById(shopId);
	}

	@Override
	public Dish getOneDishByDishId(String dishId) {
		return dishDao.findOneById(dishId);
	}

	@Override
	public long getShopPageCount(int pageSize) {
		return shopDao.getPageCount(CriteriaWrapper.instance(), pageSize);
	}

	@Override
	public long getOrderPageCount(String shopId, int pageSize) {
		return orderDao.getPageCount(CriteriaWrapper.instance().is("shopId", shopId), pageSize);
	}

	@Override
	public long getDishPageCount(String shopId, int pageSize) {
		return dishDao.getPageCount(CriteriaWrapper.instance().is("shopId", shopId), pageSize);
	}

	@Override
	public List<ShopTasteTag> getShopTasteTags() {
		return shopTasteTagDao.findAll();
	}

	@Override
	public void saveShopTasteTagEdit(ShopTasteTag shopTasteTag) {
		shopTasteTagDao.update(shopTasteTag);
	}

	@Override
	public void deleteShopTasteTagByTagId(String tagId) {
		shopTasteTagDao.delete(tagId);
	}
	

}
