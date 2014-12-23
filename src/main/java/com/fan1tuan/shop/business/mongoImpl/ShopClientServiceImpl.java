package com.fan1tuan.shop.business.mongoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.ShopClientDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.shop.business.ShopClientService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishRec;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopClient;
import com.fan1tuan.shop.pojos.ShopSale;
import com.mongodb.WriteResult;

public class ShopClientServiceImpl implements ShopClientService{
	private ShopClientDao shopClientDao;
	private ShopDao shopDao;
	private DishDao dishDao;
	private DishCommentDao dishCommentDao;

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

	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}

	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}

	@Override
	public boolean addShop(Shop shop, String clientId) {
		return false;
	}

	@Override
	public boolean addShopClient(ShopClient client) {
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		return false;
	}

	@Override
	public boolean openShop(String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean closeShop(String shopId, String clientId) {
		return false;
	}

	@Override
	public List<Shop> getClientShops(String clientId) {
		return null;
	}

	@Override
	public Shop getShopOfClient(String shopId, String clientId) {
		return null;
	}

	@Override
	public boolean updateShopInfoOfClient(Shop shop, String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean addShopAffairTagsToShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean addShopTasteTagsToShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean removeShopAffairTagsFromShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean removeShopTasteTagsFromShopOfClient(ArrayList<String> shopTasteTagIds, String shopId, String clientId) {
		return false;
	}

	@Override
	public boolean addDishRecToShopOfClient(DishRec dishRec, String shopId) {
		return false;
	}

	@Override
	public boolean addShopSaleToShopOfClient(ShopSale shopSale, String shopId) {
		return false;
	}

	@Override
	public List<DishComment> getDishCommentsOfShopOfClient(String shopId, String clientId) {
		return null;
	}

	@Override
	public List<DishComment> getDishCommentsOfShopOfClient(ArrayList<String> dishIds) {
		return null;
	}

	@Override
	public boolean removeShopOfClient(String shopId, String clientId) {
		return false;
	}
}
