package com.fan1tuan.shop.business.task;

import com.fan1tuan.general.business.Fan1TuanService;

public interface ShopTask extends Fan1TuanService{
	public boolean refreshShopRank(String shopId);
	public boolean refreshDishRank(String dishId);
}
