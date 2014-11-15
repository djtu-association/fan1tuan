package com.fan1tuan.rank.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.util.Constants.RankAccord;
import com.fan1tuan.general.util.Constants.ShopState;
import com.fan1tuan.general.util.Constants.ShopType;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.shop.pojos.Dish;

public interface DishRankService extends IFan1TuanService{
	public List<Dish> rankDish(ShopType shopType, RankAccord rankAccord, Sort order, ShopState open, String areaId, Pageable pageable);
	public List<Dish> rankDish(String areaId, Pageable pageable);
	
	
	
	/*
	public List<Dish> rankDishWithSaleVolume(int shopType, int order, int open, String areaId, int limit, int skip);
	public List<Dish> rankDishWithCommentLevel(int shopType, int order, int open, String areaId, int limit, int skip);
	*/
	
	public List<Dish> rankDishWithRankTag(List<String> dishRankTagIds, String areaId);
	public List<Dish> rankDishWithRankTag(String dishRankTagId, String areaId);
	public List<Dish> rankDishWithRankTag(String areaId, String... dishRankTagIds);
}
