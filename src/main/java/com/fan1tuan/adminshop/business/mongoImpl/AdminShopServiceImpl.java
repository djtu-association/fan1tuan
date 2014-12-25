package com.fan1tuan.adminshop.business.mongoImpl;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.*;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopClient;

import java.util.List;

public class AdminShopServiceImpl implements AdminShopService{

	private ShopClientDao shopClientDao;
	private ShopDao shopDao;
	private DishDao dishDao;
	private DishTasteTagDao dishTasteTagDao;
	private OrderDao orderDao;

	public ShopClientDao getShopClientDao() {
		return shopClientDao;
	}

	public void setShopClientDao(ShopClientDao shopClientDao) {
		this.shopClientDao = shopClientDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
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

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public ShopClient signin(String username, String password) {
		return shopClientDao.findOneByParams(CriteriaWrapper.instance().is("username", username).is("password", password));
	}

	@Override
	public ShopClient signup(String username, String password) {
		if (shopClientDao.findOneByParams(CriteriaWrapper.instance().is("username", username))!=null) {
			return null;
		}

		ShopClient shopClient = new ShopClient();
		shopClient.setPassword(password);
		shopClient.setShopId("");
		shopClient.setUsername(username);
		shopClientDao.add(shopClient);

		return shopClient;
	}

	@Override
	public boolean changePassword(String userId, String password, String newPassword) {
		ShopClient shopClient  = shopClientDao.findOneById(userId);
		if (shopClient.getPassword().equals(password)) {
			shopClient.setPassword(newPassword);
			shopClientDao.update(shopClient);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Shop saveShop(String shopClientId, Shop shop) {
		if (shop.getId()==null||"".equals(shop.getId())) {
			//save shop
			shopDao.add(shop);
			shopClientDao.updateFirstByParams(CriteriaWrapper.instance().is("id", shopClientId), UpdateWrapper.instance().set("shopId", shop.getId()));
		} else {
			//update shop
			if(isYourShop(shopClientId, shop.getId())) {
				shopDao.update(shop);
			} else {
				return null;
			}
		}
		return shop;
	}

	@Override
	public DishTasteTag saveDishTasteTag(String shopClientId, DishTasteTag dishTasteTag) {
		if (!isYourShop(shopClientId, dishTasteTag.getShopId())) {
			return null;
		}
		if (dishTasteTag.getId()==null || "".equals(dishTasteTag.getId())) {
			// save dish taste tag
			dishTasteTagDao.add(dishTasteTag);
		} else {
			// update ...
			dishTasteTagDao.update(dishTasteTag);
		}
		return dishTasteTag;
	}

	@Override
	public Dish saveDish(String shopClientId, Dish dish) {
		if (!isYourShop(shopClientId, dish.getShopId())) {
			return null;
		}

		if (dish.getId()==null||"".equals(dish.getId())) {
			//save shop
			dishDao.add(dish);
		} else {
			//update shop
			dishDao.update(dish);
		}
		return dish;
	}

	@Override
	public boolean removeDishTasteTag(String shopClientId, String dishTasteId) {
		DishTasteTag dishTasteTag = dishTasteTagDao.findOneById(dishTasteId);
		if (!isYourShop(shopClientId, dishTasteTag.getShopId())) {
			return false;
		}

		dishTasteTagDao.delete(dishTasteId);
		return true;
	}

	@Override
	public ShopClient fetchShopClient(String shopClientId) {
		return shopClientDao.findOneById(shopClientId);
	}

	@Override
	public Shop fetchShop(String shopClientId, String shopId) {
		if (!isYourShop(shopClientId, shopId)) {
			return null;
		}

		return shopDao.findOneById(shopId);
	}

	@Override
	public List<DishTasteTag> fetchDishTasteTags(String shopClientId, String shopId) {
		if (!isYourShop(shopClientId, shopId)) {
			return null;
		}
		return dishTasteTagDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId));
	}

	@Override
	public List<Dish> fetchDishes(String shopClientId, String shopId) {
		if (!isYourShop(shopClientId, shopId)) {
			return null;
		}
		return dishDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId));
	}

	@Override
	public List<Order> fetchActiveOrders(String shopClientId, String shopId) {
		if (!isYourShop(shopClientId, shopId)) {
			return null;
		}
		return orderDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId).lt("status", 4));
	}

	@Override
	public List<Order> fetchNonActiveOrders(String shopClientId, String shopId) {
		if (!isYourShop(shopClientId, shopId)) {
			return null;
		}
		return orderDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId).gte("status", 4));
	}


	private boolean isYourShop(String clientId, String shopId) {
		return shopClientDao.findOneByParams(CriteriaWrapper.instance().is("id", clientId).is("shopId", shopId)) != null;
	}
}
