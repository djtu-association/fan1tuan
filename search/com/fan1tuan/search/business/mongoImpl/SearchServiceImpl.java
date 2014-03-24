package com.fan1tuan.search.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.search.business.SearchService;
import com.fan1tuan.search.pojos.DishSearchItem;
import com.fan1tuan.search.pojos.ShopSearchItem;

public class SearchServiceImpl implements SearchService{

	private DishDao dishDao;
	private ShopDao shopDao;
	
	
	
	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	//-------------------------------------------------------- method below------
	
	@Override
	public List<ShopSearchItem> searchForKeyword(String keyword, String areaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShopSearchItem> searchShopAutoComplete(String keyword,
			String areaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DishSearchItem> searchDishAutoComplete(String keyword,
			String areaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
