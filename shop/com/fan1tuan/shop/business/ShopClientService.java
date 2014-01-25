package com.fan1tuan.shop.business;

import java.util.ArrayList;
import java.util.List;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishRec;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopClient;
import com.fan1tuan.shop.pojos.ShopSale;

public interface ShopClientService extends  IFan1TuanService{
	public boolean addShop(Shop shop, String clientId);
	public boolean addShopClient(ShopClient client);
	
	public boolean login(String username, String password);
	
	public boolean openShop(String shopId, String clientId);
	public boolean closeShop(String shopId, String clientId);
	
	public List<Shop> getClientShops(String clientId);
	
	public Shop getShopOfClient(String shopId, String clientId); //necessary to check whether the shop belongs to the specific user or not
	
	public boolean updateShopInfoOfClient(Shop shop, String shopId, String clientId);
	
	public boolean addShopAffairTagsToShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId);
	public boolean addShopTasteTagsToShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId);
		
	public boolean removeShopAffairTagsFromShopOfClient(ArrayList<String> shopAffairTagIds, String shopId, String clientId);
	public boolean removeShopTasteTagsFromShopOfClient(ArrayList<String> shopTasteTagIds, String shopId, String clientId);
	
	public boolean addDishRecToShopOfClient(DishRec dishRec, String shopId);//check the dishId in dishRec, belongs to the shop
	public boolean addShopSaleToShopOfClient(ShopSale shopSale, String shopId);
	
	public List<DishComment> getDishCommentsOfShopOfClient(String shopId, String clientId);
	public List<DishComment> getDishCommentsOfShopOfClient(ArrayList<String> dishIds);
	
	public boolean removeShopOfClient(String shopId, String clientId);
	
}
