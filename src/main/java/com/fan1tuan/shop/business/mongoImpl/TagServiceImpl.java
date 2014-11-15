package com.fan1tuan.shop.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.DishTasteTagDao;
import com.fan1tuan.general.dao.impl.RankTagDao;
import com.fan1tuan.general.dao.impl.ShopAffairTagDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.shop.business.TagService;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;
import com.fan1tuan.shop.pojos.ShopAffairTag;
import com.fan1tuan.shop.pojos.ShopTasteTag;

public class TagServiceImpl implements TagService{
	/*
	private MongoTemplate template;
	
	@Override
	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	@Override
	public MongoTemplate getTemplate() {
		return this.template;
	}
	*/
	private ShopAffairTagDao shopAffairTagDao;
	private ShopTasteTagDao shopTasteTagDao;
	private DishTasteTagDao dishTasteTagDao;
	private RankTagDao rankTagDao;
	private ShopDao shopDao;
	private DishDao dishDao;
	
	
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public ShopAffairTagDao getShopAffairTagDao() {
		return shopAffairTagDao;
	}

	public void setShopAffairTagDao(ShopAffairTagDao shopAffairTagDao) {
		this.shopAffairTagDao = shopAffairTagDao;
	}

	public ShopTasteTagDao getShopTasteTagDao() {
		return shopTasteTagDao;
	}

	public void setShopTasteTagDao(ShopTasteTagDao shopTasteTagDao) {
		this.shopTasteTagDao = shopTasteTagDao;
	}

	public DishTasteTagDao getDishTasteTagDao() {
		return dishTasteTagDao;
	}

	public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
		this.dishTasteTagDao = dishTasteTagDao;
	}

	public RankTagDao getRankTagDao() {
		return rankTagDao;
	}

	public void setRankTagDao(RankTagDao rankTagDao) {
		this.rankTagDao = rankTagDao;
	}

	
	@Override
	public boolean addShopTasteTag(ShopTasteTag tag) {
		//template.insert(tag);
		shopTasteTagDao.add(tag);
		return true;
	}

	@Override
	public boolean addShopAffairTag(ShopAffairTag tag) {
		//template.insert(tag);
		shopAffairTagDao.add(tag);
		return true;
	}

	@Override
	public boolean addRankTag(RankTag tag) {
		//template.insert(tag);
		rankTagDao.add(tag);
		return true;
	}

	@Override
	public ShopTasteTag getShopTasteTag(String id) {
		//return template.findById(id, ShopTasteTag.class);
		return shopTasteTagDao.findOneById(id);
	}

	@Override
	public ShopAffairTag getShopAffairTag(String id) {
		//return template.findById(id, ShopAffairTag.class);
		return shopAffairTagDao.findOneById(id);
	}

	@Override
	public RankTag getRankTag(String id) {
		//return template.findById(id, RankTag.class);
		return rankTagDao.findOneById(id);
	}

	@Override
	public boolean addDishTasteTag(DishTasteTag tag, String shopId) {
		tag.setShopId(shopId);
		//template.insert(tag);
		dishTasteTagDao.add(tag);
		return true;
	}

	@Override
	public DishTasteTag getDishTasteTag(String id) {
		//return template.findById(id, DishTasteTag.class);
		return dishTasteTagDao.findOneById(id);
	}

	@Override
	public boolean removeDishTasteTag(String tagId, String shopId) {
		if(this.isDishTasteTagBelongsToShop(tagId, shopId)){
			//template.updateMulti(new Query(where("shopId").is(shopId).and("dishTasteTagId").is(tagId)), new Update().set("dishTasteTagId", ""), Dish.class);
			dishDao.updateMultiByParams(CriteriaWrapper.instance().is("shopId", shopId).is("dishTasteTagId", tagId), UpdateWrapper.instance().set("dishTasteTagId", ""));
			//template.remove(new Query(where("id").is(tagId)), DishTasteTag.class);
			dishTasteTagDao.delete(tagId);
		}
		return false;
	}

	@Override
	public boolean removeRankTagForShop(String tagId) {
		//template.updateMulti(new Query(where("rankTagIds").all(tagId)), new Update().pull("rankTagIds", tagId), Shop.class);
		shopDao.updateMultiByParams(CriteriaWrapper.instance().all("rankTagIds", tagId), UpdateWrapper.instance().pull("rankTagIds", tagId));
		//template.remove(new Query(where("id").is(tagId)), RankTag.class);
		rankTagDao.delete(tagId);
		return true;
	}

	@Override
	public boolean removeRankTagForDish(String tagId) {
		//template.updateMulti(new Query(where("rankTagIds").all(tagId)), new Update().pull("rankTagIds", tagId), Dish.class);
		dishDao.updateMultiByParams(CriteriaWrapper.instance().all("rankTagIds", tagId), UpdateWrapper.instance().pull("rankTagIds", tagId));
		//template.remove(new Query(where("id").is(tagId)), RankTag.class);
		rankTagDao.delete(tagId);
		return true;
	}
	
	@Override
	public boolean removeShopAffairTag(String tagId) {
		//template.updateMulti(new Query(where("shopAffairTagIds").all(tagId)), new Update().pull("shopAffairTagIds", tagId), Shop.class);
		shopDao.updateMultiByParams(CriteriaWrapper.instance().all("shopAffairTagIds", tagId), UpdateWrapper.instance().pull("shopAffairTagIds", tagId));
		//template.remove(new Query(where("id").is(tagId)), ShopAffairTag.class);
		shopAffairTagDao.delete(tagId);
		return true;
	}

	@Override
	public boolean removeShopTasteTag(String tagId) {
		//template.updateMulti(new Query(where("shopTasteTagIds").all(tagId)), new Update().pull("shopTasteTagIds", tagId), Shop.class);
		shopDao.updateMultiByParams(CriteriaWrapper.instance().all("shopTasteTagIds", tagId), UpdateWrapper.instance().pull("shopTasteTagIds", tagId));
		//template.remove(new Query(where("id").is(tagId)), ShopTasteTag.class);
		shopTasteTagDao.delete(tagId);
		return true;
	}
	

	@Override
	public boolean addShopRankTagToShop(String tagId, String shopId) {
		//template.updateFirst(new Query(where("id").is(shopId)), new Update().push("rankTagIds", tagId), Shop.class);
		shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().push("rankTagIds", tagId));
		return true;
	}

	private boolean isDishTasteTagBelongsToShop(String tagId, String shopId){
		//DishTasteTag tag = template.findById(tagId, DishTasteTag.class);
		DishTasteTag tag = dishTasteTagDao.findOneById(tagId);
		if(tag.getShopId().equals(shopId)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public RankTag getRankTagByName(String name) {
		return rankTagDao.findOneByParams(CriteriaWrapper.instance().is("name", name));
	}

	
	/**
	 * add by @author JOE
	 * 主页选择口味的下拉列表
	 */
	@Override
	public List<ShopTasteTag> getShopTasteTag() {
		return shopTasteTagDao.findAll();
	}

	@Override
	public List<DishTasteTag> getDishTasteTag() {
		return dishTasteTagDao.findAll();
	}

}
