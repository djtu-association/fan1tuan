package com.fan1tuan.search.business;

import java.util.List;

import com.fan1tuan.search.pojos.DishSearchItem;
import com.fan1tuan.search.pojos.ShopSearchItem;

public interface SearchService {
	 public List<ShopSearchItem> searchForKeyword(String keyword, String areaId);
	 
	 public List<ShopSearchItem> searchShopAutoComplete(String keyword, String areaId);
	 public List<DishSearchItem> searchDishAutoComplete(String keyword, String areaId);
	 
}
