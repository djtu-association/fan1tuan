package com.fan1tuan.shop.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;
import com.fan1tuan.shop.pojos.ShopAffairTag;
import com.fan1tuan.shop.pojos.ShopTasteTag;

public interface TagService extends IFan1TuanService{
	public boolean addShopTasteTag(ShopTasteTag tag);
	public boolean addShopAffairTag(ShopAffairTag tag);
	
	public boolean addRankTag(RankTag tag);

	
	public ShopTasteTag getShopTasteTag(String id);
	public ShopAffairTag getShopAffairTag(String id);
	public RankTag getRankTag(String id);
	public RankTag getRankTagByName(String name);
	
	/**
	 * 2013年12月3日下午5:03:40
	 * @return
	 */
	//add by zrh
	public List<ShopTasteTag> getShopTasteTag();
	public List<DishTasteTag> getDishTasteTag();
	
	//belongs to shop operation
	public boolean addDishTasteTag(DishTasteTag tag, String shopId);
	public DishTasteTag getDishTasteTag(String id);
	public boolean removeDishTasteTag(String tagId, String shopId);
	//end
	
	//client cannot have access to this method
	public boolean addShopRankTagToShop(String tagId, String shopId);
	
	public boolean removeRankTagForShop(String tagId);
	public boolean removeRankTagForDish(String tagId);
	public boolean removeShopAffairTag(String tagId);
	public boolean removeShopTasteTag(String tagId);
	
}
