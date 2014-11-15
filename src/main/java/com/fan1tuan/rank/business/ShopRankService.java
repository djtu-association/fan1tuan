package com.fan1tuan.rank.business;

import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopGeo;

public interface ShopRankService extends IFan1TuanService{

	
	public List<Shop> rankPhoneCallShop(Constants.ShopType shopType, 
			List<String> shopTasteTagIds, 
			Constants.RankAccord accord, 
			Constants.Sort order, 
			String areaId,
			Pageable pageable);
	public List<Shop> rankPhoneCallShop(String areaId, Pageable pageable);
	
	public List<Shop> rankOnlineShop(Constants.ShopType shopType, 
			List<String> shopTasteTagIds, 
			List<String> shopAffairTagIds, 
			Constants.RankAccord accord, 
			Constants.Sort order, 
			Constants.ShopState open, 
			String areaId, 
			Pageable pageable);
	public List<Shop> rankOnlineShop(String areaId, Pageable pageable);
	
	
	
	//Geo Rank
	public List<ShopGeo> rankPhoneCallShopGeos(Constants.ShopType shopType, 
			List<String> shopTasteTagIds, 
			Constants.RankAccord accord, 
			Constants.Sort order, 
			String areaId,
			Pageable pageable);
	public List<ShopGeo> rankPhoneCallShopGeos(String areaId, Pageable pageable);
	
	public List<ShopGeo> rankOnlineShopGeos(Constants.ShopType shopType, 
			List<String> shopTasteTagIds, 
			List<String> shopAffairTagIds, 
			Constants.RankAccord accord, 
			Constants.Sort order, 
			Constants.ShopState open, 
			String areaId, 
			Pageable pageable);
	public List<ShopGeo> rankOnlineShopGeos(String areaId, Pageable pageable);
	
	/*
	public List<Shop> rankShopWithPopularityWithOrderTypeWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(int orderType, int shopType, 
			List<String> shopTasteTagIds, List<String> shopAffairTagIds, int order, int open, String areaId, int limit, int skip);
	
	public List<Shop> rankShopWithSaleVolumeWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(int shopType, 
			List<String> shopTasteTagIds, List<String> shopAffairTagIds, int order, int open, String areaId, int limit, int skip);
	public List<Shop> rankShopWithCommentLevelWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(int shopType,
			List<String> shopTasteTagIds, List<String> shopAffairTagIds, int order, int open, String areaId, int limit, int skip);
	*/
	public List<Shop> rankShopWithRankTag(List<String> shopRankTagIds, String areaId);
	
	public List<String> transformShopListToShopIdList(List<Shop> shops);
}
