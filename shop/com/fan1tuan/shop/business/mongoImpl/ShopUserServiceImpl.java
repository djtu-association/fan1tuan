package com.fan1tuan.shop.business.mongoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metrics;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.DishTasteTagDao;
import com.fan1tuan.general.dao.impl.RankTagDao;
import com.fan1tuan.general.dao.impl.ShopAffairTagDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.CollectionUtil;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.shop.business.ShopUserService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopAffairTag;
import com.fan1tuan.shop.pojos.ShopGeo;
import com.fan1tuan.shop.pojos.ShopTasteTag;
import com.fan1tuan.user.pojos.FavoriteShop;
import com.fan1tuan.user.pojos.User;
import com.mongodb.WriteResult;

public class ShopUserServiceImpl implements ShopUserService{
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
	private ShopDao shopDao;
	private DishDao dishDao;
	private UserDao userDao;
	private AreaDao areaDao;
	private ShopAffairTagDao shopAffairTagDao;
	private ShopTasteTagDao shopTasteTagDao;
	private RankTagDao rankTagDao;
	private DishTasteTagDao dishTasteTagDao;
	private DishCommentDao dishCommentDao;
	
	

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
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

	public RankTagDao getRankTagDao() {
		return rankTagDao;
	}

	public void setRankTagDao(RankTagDao rankTagDao) {
		this.rankTagDao = rankTagDao;
	}

	public DishTasteTagDao getDishTasteTagDao() {
		return dishTasteTagDao;
	}

	public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
		this.dishTasteTagDao = dishTasteTagDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Override
	public Shop getShop(String shopId) {
		//return template.findById(shopId, Shop.class);
		return shopDao.findOneById(shopId);
	}

	@Override
	public List<Dish> getDishMenu(String shopId) {
		//return template.find(new Query(where("shopId").is(shopId)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId));
	}
	
	@Override
	public Map<String, List<Dish>> getDishMenuByTaste(String shopId) {
		List<Dish> dishes = this.getDishMenu(shopId);
		HashMap<String, List<Dish>> cat = new HashMap<String, List<Dish>>();
		for(Dish dish : dishes){
			List<Dish> list = cat.get(dish.getDishTasteTagId());
			if(list==null){
				list = new ArrayList<Dish>();
			}
			list.add(dish);
		}
		return cat;
	}

	@Override
	public List<DishTasteTag> getShopDishesTastes(String shopId) {
		//List<Dish> dishes = this.getPartOfObjects("shopId", shopId, new String[]{"id","dishTasteTagId"}, Dish.class);
		List<Dish> dishes = dishDao.findProjectedByParams(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id","dishTasteTagId"));
		Set<String> tagIds = new HashSet<String>();
		for(Dish dish : dishes){
			tagIds.add(dish.getDishTasteTagId());
		}
		//return template.find(new Query(where("id").in(tagIds)), DishTasteTag.class);
		return dishTasteTagDao.findByParams(CriteriaWrapper.instance().in("id", tagIds));
	}

	@Override
	public List<DishTasteTag> getShopDishesTastes(ArrayList<String> dishIds) {
		//Query query = new Query(where("id").in(dishIds));
		//query.fields().include("id").include("dishTasteTagId");
		//List<Dish> dishes = template.find(query, Dish.class);
		List<Dish> dishes = dishDao.findProjectedByParams(CriteriaWrapper.instance().in("id", dishIds), FieldFilter.instance("id","dishTasteTagId"));
		Set<String> tagIds = new HashSet<String>();
		for(Dish dish : dishes){
			tagIds.add(dish.getDishTasteTagId());
		}
		//return template.find(new Query(where("id").in(tagIds)), DishTasteTag.class);
		return dishTasteTagDao.findByParams(CriteriaWrapper.instance().in("id", tagIds));
	}

	@Override
	public List<Dish> getDishesWithDishTasteTagInShop(String shopId,
			String dishTasteTagId) {
		//return template.find(new Query(where("shopId").is(shopId).and("dishTasteTagId").is(dishTasteTagId)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId).is("dishTasteTagId", dishTasteTagId));
	}

	@Override
	public List<Dish> getDishesWithDishRankTagInShop(String shopId,
			String rankTagId) {
		//return template.find(new Query(where("shopId").is(shopId).and("rankTagIds").all(rankTagId)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().is("shopId", shopId).all("rankTagIds", rankTagId));
	}

	@Override
	public List<RankTag> getShopRankTags(List<String> rankTagIds) {
		Set<String> tagIds = CollectionUtil.transformListToSet(rankTagIds);
		//return template.find(new Query(where("id").in(tagIds)), RankTag.class);
		return rankTagDao.findByParams(CriteriaWrapper.instance().in("id", tagIds));
	}

	@Override
	public List<RankTag> getShopRankTags(String shopId) {
		//List<String> rankTagIds = this.getPartOfObject(shopId, new String[]{"id","rankTagIds"}, Shop.class).getRankTagIds();
		List<String> rankTagIds = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","rankTagIds")).getRankTagIds();
		return this.getShopRankTags(rankTagIds);
	}

	@Override
	public List<ShopAffairTag> getShopAffairTags(
			List<String> shopAffairTagIds) {
		Set<String> tagIds = CollectionUtil.transformListToSet(shopAffairTagIds);
		//return template.find(new Query(where("id").in(tagIds)), ShopAffairTag.class);
		return shopAffairTagDao.findByParams(CriteriaWrapper.instance().in("id", tagIds));
	}

	@Override
	public List<ShopAffairTag> getShopAffairTags(String shopId) {
		//List<String> shopAffairTagIds = this.getPartOfObject(shopId, new String[]{"id","shopAffairTagIds"}, Shop.class).getShopAffairTagIds();
		List<String> shopAffairTagIds = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopAffairTagIds")).getShopAffairTagIds();
		return this.getShopAffairTags(shopAffairTagIds);
	}

	@Override
	public List<ShopTasteTag> getShopTasteTags(
			List<String> shopTasteTagIds) {
		Set<String> tagIds = CollectionUtil.transformListToSet(shopTasteTagIds);
		//return template.find(new Query(where("id").in(tagIds)), ShopTasteTag.class);
		return shopTasteTagDao.findByParams(CriteriaWrapper.instance().in("id", tagIds));
	}

	@Override
	public List<ShopTasteTag> getShopTasteTags(String shopId) {
		//List<String> shopTasteTagIds = this.getPartOfObject(shopId, new String[]{"id","shopTasteTagIds"}, Shop.class).getShopTasteTagIds();
		List<String> shopTasteTagIds = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id","shopTasteTagIds")).getShopTasteTagIds();
		return this.getShopTasteTags(shopTasteTagIds);
	}

	@Override
	public boolean isShopExist(String shopId){
		//Shop shop = this.getPartOfObject(shopId, new String[]{"id"}, Shop.class);
		Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("id"));
		return shop!=null;
	}

	@Override
	public Map<String, Integer> getSimpleShopComments(String shopId) {
		List<Dish> dishs = dishDao.findProjectedByParams(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id"));
		List<String> dishIds = new ArrayList<String>();
		for(Dish dish : dishs){
			dishIds.add(dish.getId());
		}
		List<DishComment> dishComments = dishCommentDao.findProjectedByParams(CriteriaWrapper.instance().in("dishId", dishIds), FieldFilter.instance("commentLevel"));
		
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

	/**
	 * 返回当前用户收藏的商铺的数组
	 */
	@Override
	public String[] dealUserFavoriteShops(String userId, List<Shop> shopList) {
		User user = userDao.findOneById(userId);
		if(user.getFavoriteShops() != null){
			ArrayList<String> temp = new ArrayList<String>();
			for(FavoriteShop favoriteShop : user.getFavoriteShops()){
				for(int i=0,size=shopList.size(); i<size; i++){
					if(favoriteShop.getShopId() == shopList.get(i).getId()){
						temp.add(shopList.get(i).getId());
					}
				}
			}
			return temp.toArray(new String[0]);
		}
		return null;	
	}

	@Override
	public List<Dish> getTopRecDishesInShop(String shopId) {
		List<Dish> list = new ArrayList<Dish>();
		list.addAll(dishDao.findProjectedByParamsInPageInOrder(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id","name","price","avgCommentLevel", "commentNum"), Pageable.inPage(0, 1), Sortable.instance("saleVolume", Sort.DESC.ordinal())));
		list.addAll(dishDao.findProjectedByParamsInPageInOrder(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id","name","price","avgCommentLevel", "commentNum"), Pageable.inPage(0, 1), Sortable.instance("avgCommentLevel", Sort.DESC.ordinal())));
		list.addAll(dishDao.findProjectedByParamsInPage(CriteriaWrapper.instance().is("shopId", shopId).in("rankTagIds", rankTagDao.findProjectedAll("id","name")), FieldFilter.instance("id","name","price","avgCommentLevel", "commentNum"), Pageable.inPage(0, 4)));
		return list;
	}

	@Override
	public String getShopStaticMap(String shopId) {
		char sep = '&';
		Shop shop = shopDao.findOneProjectedById(shopId, FieldFilter.instance("location","name"));
		double[] location = shop.getLocation();
		StringBuilder sb = new StringBuilder();
		sb.append("http://api.map.baidu.com/staticimage?");
		//center
		sb.append("center="+location[0]+","+location[1]);
		//zoom
		sb.append(sep+"zoom=16");
		//scale
		sb.append(sep+"scale=1");
		//size
		sb.append(sep+"size=m");
		//markers
		sb.append(sep+"markers="+location[0]+","+location[1]);
		//marker style
		sb.append(sep+"markerStyles=-1,http://localhost:8080/fan1tuan/res/img/marker.png,-1,23,25");
		//label
		sb.append(sep+"labels="+location[0]+","+location[1]);
		//label style
		sb.append(sep+"labelStyles="+shop.getName()+",1,16,0xFFFFFF,0x808000,1");
		
		return sb.toString();
		
	}

	@Override
	public String getShopNameById(String shopId) {
		return shopDao.findOneProjectedById(shopId, FieldFilter.instance("name")).getName();
	}

	@Override
	public ShopGeo getShopGeo(String shopId, String areaId) {
		//System.out.println("shopId:"+shopId+", areaId:"+areaId);
		//CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance().is("id", shopId);
		Circle circle = makeCircleWithArea(areaId);
		GeoResults<Shop> geoResults = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius()/1000, Metrics.KILOMETERS)/*, QueryWrapper.wrap(criteriaWrapper)*/);
		if(geoResults==null){
			return null;
		}
		//System.out.println(geoResults.getContent().size());
		for(GeoResult<Shop> geoResult:geoResults){
			//System.out.println(geoResult.getContent().toJSON()+"\n"+geoResult.getDistance().getValue());
			if(geoResult.getContent().getId().equals(shopId)){
												
				ShopGeo shopGeo = new ShopGeo(geoResult.getContent(), geoResult.getDistance().getValue());
				
				shopGeo.setShopTasteTags(getShopTasteTags(shopId));
				
				return  shopGeo;
			}
		}
				
		return null;

		//return null;
	}

	private Circle makeCircleWithArea(String areaId){
		Area area = areaDao.findOneById(areaId);
		return new Circle(area.getLongtitude(), area.getLatitude(), area.getRadius());
	}

	@Override
	public boolean increaseShopPopularity(String shopId) {
		WriteResult wr = shopDao.updateFirstByParams(CriteriaWrapper.instance().is("id", shopId), UpdateWrapper.instance().inc("popularity", 1));
		if(wr.getN()>0){
			return true;
		}else{
			return false;
		}
	}

	
	
	/*
	private <T> T getPartOfObject(String id, String[] includedFields, Class<T> theClass){
		Query query = new Query(where("id").is(id));
		
		for(String key : includedFields){
			query.fields().include(key);
		}
		
		return template.findOne(query, theClass);
	}
	
	private <T> List<T> getPartOfObjects(String key, String value, String[] includedFields, Class<T> theClass){
		Query query = new Query(where(key).is(value));
		for(String item : includedFields){
			query.fields().include(item);
		}
		return template.find(query, theClass);
	}
	
	@SuppressWarnings("unused")
	private boolean isChanged(WriteResult wr){
		if(wr.getN()>0){
			return true;
		}else{
			return false;
		}
	}
	
	private <T> Set<T> transformListToSet(List<T> list){
		Set<T> set = new HashSet<T>();
		set.addAll(list);
		return set;
	}
	*/
}
