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
	
	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}

	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

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

	@Override
	public boolean addShop(Shop shop, String clientId) {
		//template.insert(shop);
		shopDao.add(shop);
		ShopClient client = this.getShopClient(clientId);
		//System.out.println(shop.getId());
		ArrayList<String> shopIds = client.getShopIds();
		if(shopIds==null){
			shopIds = new ArrayList<String>();
			client.setShopIds(shopIds);
		}
		client.getShopIds().add(shop.getId());
		
		shopClientDao.update(client);
		return true;
	}

	@Override
	public boolean login(String username, String password) {
		//Query query = new Query(where("username").is(username).and("shopClient.password").is(password));
		//query.fields().include("id");
		//ShopClient client = template.findOne(query, ShopClient.class);
		
		ShopClient client = shopClientDao.findOneByParams(CriteriaWrapper.instance().is("username", username).is("password", password));
		return client!=null;
	}

	
	
	@Override
	public boolean openShop(String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//WriteResult wr = template.updateFirst(new Query(where("id").is(shopId)), new Update().set("open", true), Shop.class);
			WriteResult wr = shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("open", true));
			//WriteResult wr2 = template.updateMulti(new Query(where("shopId").is(shopId)), new Update().set("status", 1), Dish.class);
			WriteResult wr2 = dishDao.updateMultiByParams(CriteriaWrapper.instance().is("shopId", shopId), UpdateWrapper.instance().set("status", 1));
			if(wr.getN()>0&&wr2.getN()>0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean closeShop(String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//WriteResult wr = template.updateFirst(new Query(where("id").is(shopId)), new Update().set("open", false), Shop.class);
			WriteResult wr = shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("open", false));
			//WriteResult wr2 = template.updateMulti(new Query(where("shopId").is(shopId)), new Update().set("status", 0), Dish.class);
			WriteResult wr2 = dishDao.updateMultiByParams(CriteriaWrapper.instance().is("shopId", shopId), UpdateWrapper.instance().set("status", 0));
			if(wr.getN()>0&&wr2.getN()>0){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Shop> getClientShops(String clientId) {
		ShopClient client = this.getShopClient(clientId);
		
		//List<Shop> shops = template.find(new Query(where("id").in(client.getShopIds())), Shop.class);
		List<Shop> shops = shopDao.findByParams(CriteriaWrapper.instance().in("id", client.getShopIds()));
		return shops;
	}

	@Override
	public Shop getShopOfClient(String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//Shop shop = template.findById(shopId, Shop.class);
			Shop shop = shopDao.findOneById(shopId);
			return shop;
		}
		return null;
	}

	@Override
	public boolean updateShopInfoOfClient(Shop shop, String shopId,
			String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//template.save(shop);
			shopDao.update(shop);
			return true;
		}
		return false;
	}

	
	@Override
	public boolean addShopAffairTagsToShopOfClient(ArrayList<String> shopAffairTagIds,
			String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			 //Shop shop = this.getPartOfObject(shopId, new String[]{"id,shopAffairTagIds"}, Shop.class);
			Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopAffairTagIds")); 
			ArrayList<String> ids = shop.getShopAffairTagIds();
			 if(ids==null){
				 ids = new ArrayList<String>();
				 shop.setShopAffairTagIds(ids);
			 }
			 shop.getShopAffairTagIds().addAll(shopAffairTagIds);
			 //template.updateFirst(new Query(where("id").is(shopId)), new Update().set("shopAffairTagIds",shop.getShopAffairTagIds()), Shop.class);
			 shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("shopAffairTagIds", shop.getShopAffairTagIds()));
			 return true;
		}
		return false;
	}

	@Override
	public boolean addShopTasteTagsToShopOfClient(ArrayList<String> shopTasteTagIds,
			String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			 //Shop shop = this.getPartOfObject(shopId, new String[]{"id,shopTasteTagIds"}, Shop.class);
			 Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopTasteTagIds"));
			 ArrayList<String> ids = shop.getShopTasteTagIds();
			 if(ids==null){
				 ids = new ArrayList<String>();
				 shop.setShopTasteTagIds(ids);
			 }
			 shop.getShopTasteTagIds().addAll(shopTasteTagIds);
			 //template.updateFirst(new Query(where("id").is(shopId)), new Update().set("shopTasteTagIds",shop.getShopTasteTagIds()), Shop.class);
			 shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("shopTasteTagIds", shop.getShopTasteTagIds()));
			 return true;
		}
		return false;
	}

	@Override
	public boolean removeShopAffairTagsFromShopOfClient(
			ArrayList<String> shopAffairTagIds, String shopId, String clientId) {
		
		if(this.isShopBelongsToClient(shopId, clientId)){
			//Shop shop = this.getPartOfObject(shopId, new String[]{"id,shopAffairTagIds"}, Shop.class);
			Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopAffairTagIds"));
			shop.getShopAffairTagIds().removeAll(shopAffairTagIds);
			//template.updateFirst(new Query(where("id").is(shopId)), new Update().set("shopAffairTagIds",shop.getShopAffairTagIds()), Shop.class);
			shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("shopAffairTagIds", shop.getShopAffairTagIds()));
		}
		
		return false;
	}

	@Override
	public boolean removeShopTasteTagsFromShopOfClient(
			ArrayList<String> shopTasteTagIds, String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//Shop shop = this.getPartOfObject(shopId, new String[]{"id,shopTasteTagIds"}, Shop.class);
			Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopTasteTagIds"));
			shop.getShopTasteTagIds().removeAll(shopTasteTagIds);
			//template.updateFirst(new Query(where("id").is(shopId)), new Update().set("shopTasteTagIds",shop.getShopTasteTagIds()), Shop.class);
			shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("shopTasteTagIds", shop.getShopTasteTagIds()));
			return true;
		}
		return false;
	}

	@Override
	public boolean addDishRecToShopOfClient(DishRec dishRec, String shopId) {
		//Shop shop = this.getPartOfObject(shopId, new String[]{"id, dishRecs"}, Shop.class);
		Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","dishRecs"));
		//Shop shop = template.findOne(new Query(where("_id").is(shopId)), Shop.class);
		//System.out.println("Shop is null?? "+shop==null);
		//System.out.println(shop.getId()+", "+shop.getAddress());
		ArrayList<DishRec> dishRecs = shop.getDishRecs();
		if(dishRecs==null){
			dishRecs = new ArrayList<DishRec>();
			shop.setDishRecs(dishRecs);
		}
		shop.getDishRecs().add(dishRec);
		//template.updateFirst(new Query(where("id").is(shopId)), new Update().set("dishRecs",shop.getDishRecs()), Shop.class);
		shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("dishRecs", shop.getDishRecs()));
		return true;
	}

	@Override
	public boolean addShopSaleToShopOfClient(ShopSale shopSale, String shopId) {
		//Shop shop = this.getPartOfObject(shopId, new String[]{"id, shopSales"}, Shop.class);
		Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopSales"));
		ArrayList<ShopSale> shopSales = shop.getShopSales();
		if(shopSales==null){
			shopSales = new ArrayList<ShopSale>();
			shop.setShopSales(shopSales);
		}
		shop.getShopSales().add(shopSale);
		//template.updateFirst(new Query(where("id").is(shopId)), new Update().set("shopSales",shop.getShopSales()), Shop.class);
		shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().set("shopSales", shop.getShopSales()));
		return true;
	}

	@Override
	public List<DishComment> getDishCommentsOfShopOfClient(String shopId,
			String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//List<Dish> dishes = this.getPartOfObjects("shopId", shopId, new String[]{"id"}, Dish.class);
			List<Dish> dishes = dishDao.findProjectedByParams(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id"));
			ArrayList<String> dishIds = new ArrayList<String>();
			for(Dish dish : dishes){
				dishIds.add(dish.getId());
			}
			return this.getDishCommentsOfShopOfClient(dishIds);
		}
		return null;
	}

	@Override
	public List<DishComment> getDishCommentsOfShopOfClient(ArrayList<String> dishIds) {
		//List<DishComment> comments = template.find(new Query(where("dishId").in(dishIds)), DishComment.class);
		List<DishComment> comments = dishCommentDao.findByParams(CriteriaWrapper.instance().in("dishId", dishIds));
		return comments;
	}

	@Override
	public boolean removeShopOfClient(String shopId, String clientId) {
		if(this.isShopBelongsToClient(shopId, clientId)){
			//template.remove(new Query(where("id").is(shopId)), Shop.class);
			shopDao.delete(shopId);
			ShopClient client = this.getShopClient(clientId);
			client.getShopIds().remove(shopId);
			//template.save(client);
			shopClientDao.update(client);
			return true;
		}
		return false;
	}

	@Override
	public boolean addShopClient(ShopClient client) {
		//template.insert(client);
		shopClientDao.add(client);
		return true;
	}
	
	
	
	
	
	private ShopClient getShopClient(String clientId){
		//return template.findById(clientId, ShopClient.class);
		return shopClientDao.findOneById(clientId);
	}
	
	private boolean isShopBelongsToClient(String shopId, String clientId){
		ShopClient client = this.getShopClient(clientId);
		for(String id : client.getShopIds()){
			if(id.equals(shopId)){
				return true;
			}
		}
		return false;
	}
	/*
	private <T> T getPartOfObject(String id, String[] includedFields, Class<T> theClass){
		Query query = new Query(where("id").is(id));
		
		for(String key : includedFields){
			query.fields().include(key);
		}
		
		//return template.findOne(query, theClass);
	}
	
	private <T> List<T> getPartOfObjects(String key, String value, String[] includedFields, Class<T> theClass){
		Query query = new Query(where(key).is(value));
		for(String item : includedFields){
			query.fields().include(item);
		}
		return template.find(query, theClass);
	}
	*/
	@SuppressWarnings("unused")
	private String[] getExpandedStringArray(String[] original, String[] theNew){
		String[] temp = Arrays.copyOf(original, original.length+theNew.length);
		for(int i = original.length; i < temp.length; i++){
			temp[i] = theNew[i-original.length];
		}
		return temp;
	}
	
	
}
