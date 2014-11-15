package com.fan1tuan.shop.business.mongoImpl;

import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.shop.business.DishClientService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.mongodb.WriteResult;

public class DishClientServiceImpl implements DishClientService{
	private DishCommentDao dishCommentDao;
	private DishDao dishDao;
	
	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}
	public DishDao getDishDao() {
		return dishDao;
	}
	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}
	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}
	

	@Override
	public boolean addDishToShop(Dish dish, String shopId) {
		dish.setShopId(shopId);
		dishDao.add(dish);
		return true;
	}

	@Override
	public boolean updateDishInfoOfShop(Dish dish, String dishId, String shopId) {
		if(this.isDishBelongsToShop(dishId, shopId)){
			dish.setId(dishId);
			dishDao.update(dish);
			return true;
		}
		return false;
	}

	@Override
	public boolean setDishTasteTagId(String dishTasteTag, String dishId) {
		WriteResult wr = dishDao.updateFirstByParams(dishId, UpdateWrapper.instance().set("dishTasteTagId", dishTasteTag));
		//WriteResult wr = template.updateFirst(new Query(where("id").is(dishId)), new Update().set("dishTasteTagId", dishTasteTag), Dish.class);
		return this.isChanged(wr);
	}

	@Override
	public Dish getDishOfShop(String dishId, String shopId) {
		if(this.isDishBelongsToShop(dishId, shopId)){
			//return template.findById(dishId, Dish.class);
			return dishDao.findOneById(dishId);
		}
		return null;
	}

	@Override
	public List<DishComment> getDishCommentsOfDish(String dishId) {
		//return template.find(new Query(where("dishId").is(dishId)), DishComment.class);
		return dishCommentDao.findByParams(CriteriaWrapper.instance().is("dishId", dishId));

	}

	@Override
	public boolean setDishStatus(int status, String dishId) {
		//WriteResult wr = template.updateFirst(new Query(where("id").is(dishId)), new Update().set("status", status), Dish.class);
		WriteResult wr  = dishDao.updateFirstByParams(dishId, UpdateWrapper.instance().set("status", status));
		return this.isChanged(wr);
	}

	@Override
	public boolean removeDishFromShop(String dishId, String shopId) {
		if(this.isDishBelongsToShop(dishId, shopId)){
			//template.remove(new Query(where("id").is(dishId)), Dish.class);
			dishDao.delete(dishId);
			return true;
		}
		return false;
	}
	
	
	
	/*
	private <T> T getPartOfObject(String id, String[] includedFields, Class<T> theClass){
		Query query = new Query(where("id").is(id));
		
		for(String key : includedFields){
			query.fields().include(key);
		}
		
		return template.findOne(query, theClass);
	}
	*/
	
	
	private boolean isChanged(WriteResult wr){
		if(wr.getN()>0){
			return true;
		}else{
			return false;
		}
	}
	

	private boolean isDishBelongsToShop(String dishId, String shopId){
		//Dish dish = this.getPartOfObject(dishId, new String[]{"id","shopId"}, Dish.class);
		 Dish dish = dishDao.findOneProjectedById(dishId, FieldFilter.instance("id", "shopId"));
		if(dish.getShopId().equals(shopId)){
			return true;
		}else{
			return false;
		}
	}
	
}
