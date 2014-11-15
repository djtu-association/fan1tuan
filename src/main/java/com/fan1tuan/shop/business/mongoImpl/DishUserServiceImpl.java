package com.fan1tuan.shop.business.mongoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.DishTasteTagDao;
import com.fan1tuan.general.dao.impl.RankTagDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.util.CollectionUtil;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.shop.business.DishUserService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;


public class DishUserServiceImpl implements DishUserService{
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
	
	//change the template to Daos
	private DishDao dishDao;
	private RankTagDao rankTagDao;
	private DishCommentDao dishCommentDao;
	private ShopDao shopDao;
	private DishTasteTagDao dishTasteTagDao;

	public DishTasteTagDao getDishTasteTagDao() {
		return dishTasteTagDao;
	}

	public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
		this.dishTasteTagDao = dishTasteTagDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public RankTagDao getRankTagDao() {
		return rankTagDao;
	}

	public void setRankTagDao(RankTagDao rankTagDao) {
		this.rankTagDao = rankTagDao;
	}

	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}

	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	
	
	
	@Override
	public Dish getDish(String dishId) {
		//return template.findById(dishId, Dish.class);
		return dishDao.findOneById(dishId);
		//throw new RuntimeException("error");
	}

	@Override
	public List<RankTag> getDishRankTags(List<String> dishRankTagIds) {
		//Set<String> tagIds = this.transformListToSet(dishRankTagIds);
		//return template.find(new Query(where("id").in(tagIds)), RankTag.class);
		return rankTagDao.findByParams(CriteriaWrapper.instance().in("id", CollectionUtil.transformListToSet(dishRankTagIds)));
	}

	@Override
	public List<RankTag> getDishRankTags(String dishId) {
		//List<String> dishRankTagIds = this.getPartOfObject(dishId, new String[]{"id","rankTagIds"}, Dish.class).getRankTagIds();
		//return this.getDishRankTags(dishRankTagIds);
		return this.getDishRankTags(dishDao.findOneProjectedById(dishId, FieldFilter.instance("id","rankTagIds")).getRankTagIds());
	}

	@Override
	public DishTasteTag getDishTasteTag(String dishId) {
		//String tagId = this.getPartOfObject(dishId, new String[]{"id","dishTasteTagId"}, Dish.class).getDishTasteTagId();
		//return template.findById(tagId, DishTasteTag.class);
		return dishTasteTagDao.findOneById(dishDao.findOneProjectedById(dishId, FieldFilter.instance("id","dishTasteTagId")).getDishTasteTagId());
	}

	@Override
	public List<DishComment> getDishComments(String dishId) {
		//return template.find(new Query(where("dishId").is(dishId)), DishComment.class);
		return dishCommentDao.findByParams(CriteriaWrapper.instance().is("dishId", dishId));
	}

	
	/*
	 * This method is multiple-phase commit, be careful
	 * (non-Javadoc)
	 * @see com.fan1tuan.shop.business.DishUserService#submitCommentOfDish(com.fan1tuan.shop.pojos.DishComment)
	 */
	@Override
	public boolean submitCommentOfDish(DishComment comment, String dishId, String shopId) {
		//first
		comment.setDishId(dishId);
		//template.insert(comment);
		dishCommentDao.add(comment);
		
		//second
		//template.updateFirst(new Query(where("id").is(dishId)), new Update().inc("commentNum", 1).inc("commentLevel", comment.getCommentLevel()), Dish.class);
		dishDao.updateFirstByParams(dishId, UpdateWrapper.instance().inc("commentNum", 1).inc("commentLevel", comment.getCommentLevel()));
		//third
		//template.updateFirst(new Query(where("id").is(shopId)), new Update().inc("commentNum", 1).inc("commentLevel", comment.getCommentLevel()), Shop.class);
		shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().inc("commentNum", 1).inc("commentLevel", comment.getCommentLevel()));
		
		return true;
	}
	
	@Override
	public boolean isDishExist(String dishId){
		//Dish dish = this.getPartOfObject(dishId, new String[]{"id"}, Dish.class);
		//return dish!=null;
		Dish dish = dishDao.findOneProjectedById(dishId, FieldFilter.instance("id"));
		return dish!=null;
	}

	@Override
	public List<DishComment> getDishCommentsInPageInOrder(String dishId,
			Pageable pageable, Sortable sortable) {
		return dishCommentDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("dishId", dishId), pageable, sortable);
	}

	@Override
	public List<DishComment> getDishCommentsInPage(String dishId,
			Pageable pageable) {
		return this.getDishCommentsInPageInOrder(dishId, pageable, Sortable.instance("date", Constants.Sort.DESC.ordinal()));
	}

	@Override
	public double getDishPriceByDishId(String dishId) {
		return dishDao.findOneProjectedById(dishId, FieldFilter.instance("id","price")).getPrice();
	}

	@Override
	public Map<String, Integer> getSimpleDishComments(String dishId) {
		
		List<DishComment> dishComments = dishCommentDao.findProjectedByParams(CriteriaWrapper.instance().is("dishId", dishId), FieldFilter.instance("commentLevel"));
		
		Map<String, Integer> comment = new HashMap<String, Integer>();
		
		comment.put("5", 0);
		comment.put("4", 0);
		comment.put("3", 0);
		comment.put("2", 0);
		comment.put("1", 0);
		
		
		for(DishComment dishComment : dishComments){
			String level = dishComment.getCommentLevel()+"";
			Integer key = comment.get(level);
			if(key==null){
				key = 0;
			}
			++key;
			comment.put(level, key);
		}
		return comment;
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
	
	
	
	
	
}
