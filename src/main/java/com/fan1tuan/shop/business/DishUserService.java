package com.fan1tuan.shop.business;

import java.util.List;
import java.util.Map;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;

public interface DishUserService extends /*Fan1TuanService*/IFan1TuanService{
	public Dish getDish(String dishId);
	
	public List<RankTag> getDishRankTags(List<String> dishRankTagIds);
	public List<RankTag> getDishRankTags(String dishId);

	public DishTasteTag getDishTasteTag(String dishId);
	
	public List<DishComment> getDishComments(String dishId);
	public List<DishComment> getDishCommentsInPage(String dishId, Pageable pageable);
	public List<DishComment> getDishCommentsInPageInOrder(String dishId, Pageable pageable, Sortable sortable);
	
	public boolean submitCommentOfDish(DishComment comment, String dishId, String shopId); //don't forget to update the comment info in dish and shop

	public boolean isDishExist(String dishId);
	
	
	public Map<String, Integer> getSimpleDishComments(String dishId);
	
	/*
	 * 零散的便捷方法
	 */
	public double getDishPriceByDishId(String dishId);
	
}
