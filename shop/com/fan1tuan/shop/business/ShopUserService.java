package com.fan1tuan.shop.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishRec;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopAffairTag;
import com.fan1tuan.shop.pojos.ShopGeo;
import com.fan1tuan.shop.pojos.ShopTasteTag;
import com.fan1tuan.user.pojos.dto.FavoriteShopRec;

public interface ShopUserService extends IFan1TuanService{
	public Shop getShop(String shopId);
	public ShopGeo getShopGeo(String shopId, String areaId);
	
	public String getShopNameById(String shopId);
	
	public List<Dish> getDishMenu(String shopId);
	public Map<String, List<Dish>> getDishMenuByTaste(String shopId);
	
	public List<DishTasteTag> getShopDishesTastes(String shopId);
	public List<DishTasteTag> getShopDishesTastes(ArrayList<String> dishIds);

	public List<Dish> getDishesWithDishTasteTagInShop(String shopId, String dishTasteTagId);
	public List<Dish> getDishesWithDishRankTagInShop(String shopId, String rankTagId);
	public List<Dish> getTopSaleDishesInShop(String shopId, Pageable pageable);
	public List<Dish> getShopRecDishesInShop(String shopId, Pageable pageable);
	public List<Dish> getShopRecDishesInShop(List<DishRec> dishRecs, Pageable pageable);
	
	public List<RankTag> getShopRankTags(List<String> rankTagIds);
	public List<RankTag> getShopRankTags(String shopId);
	
	public List<ShopAffairTag> getShopAffairTags(List<String> shopAffairTagIds);
	public List<ShopAffairTag> getShopAffairTags(String shopId);
	
	public List<ShopTasteTag> getShopTasteTags(List<String> shopTasteTagIds);
	public List<ShopTasteTag> getShopTasteTags(String shopId);
	
	public Map<String, Integer> getSimpleShopComments(String shopId);
	
	public boolean isShopExist(String shopId);
	
	public List<Dish> getTopRecDishesInShop(String shopId);
	
	public String getShopStaticMap(String shopId);
	
	public String[] dealUserFavoriteShops(String userId,List<Shop> shopList);
	
	public boolean increaseShopPopularity(String shopId);
	
	//获取相似的店铺实体，根据传入的tags
	public List<FavoriteShopRec> getFavoriteShopRecs(String shopId, String areaId, Pageable pageable);
}
