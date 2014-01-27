package com.fan1tuan.rank.business.mongoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResult;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metrics;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.QueryWrapper;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.Constants.OrderType;
import com.fan1tuan.general.util.Constants.RankAccord;
import com.fan1tuan.general.util.Constants.ShopState;
import com.fan1tuan.general.util.Constants.ShopType;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.rank.business.DishRankService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.Shop;

public class DishRankServiceImpl implements DishRankService {
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

	@Override
	public List<Dish> rankDishWithSaleVolume(int shopType, int order, int open,
			String areaId, int limit, int skip) {
		return this.rankDishAccording("saleVolume", shopType, null, order, open, areaId, limit, skip);
	}

	@Override
	public List<Dish> rankDishWithCommentLevel(int shopType, int order,
			int open, String areaId, int limit, int skip) {
		return this.rankDishAccording("avgCommentLevel", shopType, null, order, open, areaId, limit, skip);
	}
	*/
		
	/*
	private List<Shop> rankOnlineShop(int shopType,
			List<String> shopAffairTagIds, int order, int open,
			String areaId){
		Circle circle = this.makeCircleWithArea(areaId);
		
		Criteria criteria = Criteria.where("orderType").is(ShopRankServiceImpl.ORDERTYPE_ONLINE);
		
		if(shopType!=ShopRankServiceImpl.SHOPTYPE_ALL){
			criteria.and("type").is(shopType);
		}
		
		if(shopAffairTagIds!=null){
			criteria.and("shopAffairTagIds").all(shopAffairTagIds);
		}
		
		if(open!=ShopRankServiceImpl.STATE_ALL){
			if(open==ShopRankServiceImpl.STATE_OPEN){
				criteria.and("open").is(true);
			}else{
				criteria.and("open").is(false);
			}
		}
		criteria.and("location").within(circle);
		
		Query query = new Query(criteria);
		
		query.fields().include("id");
		
		return template.find(query, Shop.class);
	}

	private List<Dish> rankDishAccording(String accordingField, int shopType,
			List<String> shopAffairTagIds, int order, int open,
			String areaId,int limit, int skip){
		List<Shop> simpleShops = this.rankOnlineShop(shopType, shopAffairTagIds, order, open, areaId);
		List<String> shopIds = this.transformShopListToShopIdList(simpleShops);
		
		Criteria criteria = Criteria.where("shopId").in(shopIds);
		
		Sort.Order sortOrder;
		if(order==ShopRankServiceImpl.ORDER_ASC){
			sortOrder = new Sort.Order(Sort.Direction.ASC, accordingField);
		}else{
			sortOrder = new Sort.Order(Sort.Direction.DESC, accordingField);
		}
		
		Query query = new Query(criteria).with(new Sort(sortOrder)).skip(skip).limit(limit);
		
		return template.find(query, Dish.class);
	}
	*/
	
	private AreaDao areaDao;
	private DishDao dishDao;
	private ShopDao shopDao;
	private Logger logger = LogManager.getLogger("com.fan1tuan.general.business.ServiceLogger");
	
	public AreaDao getAreaDao() {
		return areaDao;
	}
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	public DishDao getDishDao() {
		return dishDao;
	}
	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	
	private List<Shop> getSimpleShopsWithinArea(String areaId){
		Circle cricle = this.makeCircleWithArea(areaId);
		return shopDao.findProjectedByParams(CriteriaWrapper.instance().withinSphere("location", cricle), FieldFilter.instance("id"));
	}
	@Override
	public List<Dish> rankDishWithRankTag(List<String> dishRankTagIds,
			String areaId) {
		List<Shop> shops = this.getSimpleShopsWithinArea(areaId);
		List<String> shopIds = this.transformShopListToShopIdList(shops);
		//return template.find(new Query(where("rankTagIds").all(dishRankTagIds).and("shopId").in(shopIds)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().all("rankTagIds", dishRankTagIds).in("shopId", shopIds));
	}
	
	
	
	private Circle makeCircleWithArea(String areaId){
		Area area = areaDao.findOneById(areaId);
		return new Circle(area.getLongtitude(), area.getLatitude(), area.getRadius());
	}
	
	private List<String> transformShopListToShopIdList(List<Shop> shops) {
		List<String> list = new ArrayList<String>();
		for(Shop shop: shops){
			list.add(shop.getId());
		}
		return list;
	}
	
	private List<Shop> getSimpleShops(ShopType shopType, ShopState open, String areaId){
		//CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance().withinSphere("location", makeCircleWithArea(areaId));
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance();

		if(shopType!=ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		if(open==ShopState.OPEN){
			criteriaWrapper.is("open", true);
		}
		
		criteriaWrapper.is("orderType", OrderType.ONLINE.ordinal());
		
		Circle circle = makeCircleWithArea(areaId);
		GeoResults<Shop> shopGeos = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, FieldFilter.instance("id"), null));
		List<Shop> shops = new ArrayList<Shop>();
		for(GeoResult<Shop> geoResult:shopGeos){
			shops.add(geoResult.getContent());
		}
		
		return shops;
	}
	@Override
	public List<Dish> rankDish(String areaId, Pageable pageable) {
		return this.rankDish(ShopType.ALL, RankAccord.SALEVOLUME, Sort.DESC, ShopState.ALL, areaId, pageable);
	}
	@Override
	public List<Dish> rankDish(ShopType shopType, RankAccord rankAccord,
			com.fan1tuan.general.util.Constants.Sort order, ShopState open,
			String areaId, Pageable pageable) {
		
		logger.entry(shopType, rankAccord,
			order, open,
			 areaId,  pageable);
		
		List<Shop> simpleShops = this.getSimpleShops(shopType, open, areaId);
		List<String> shopIdsList = this.transformShopListToShopIdList(simpleShops);
		
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance().in("shopId", shopIdsList);
		Sortable sortable = null;
		if(rankAccord==RankAccord.COMMENTLEVEL){
			sortable = Sortable.instance("avgCommentLevel", order.ordinal());
		}else if(rankAccord==RankAccord.SALEVOLUME){
			sortable = Sortable.instance("saleVolume", order.ordinal());
		}else {
			sortable = Sortable.instance("avgCommentLevel", order.ordinal());
		}
		
		pageable.setItemsNum(dishDao.getCount(criteriaWrapper));
		logger.trace("Count the Sum of the Items:"+pageable.getItemsNum());
		return dishDao.findByParamsInPageInOrder(criteriaWrapper, pageable, sortable);
	}
	@Override
	public List<Dish> rankDishWithRankTag(String dishRankTagId, String areaId) {
		List<Shop> shops = this.getSimpleShopsWithinArea(areaId);
		List<String> shopIds = this.transformShopListToShopIdList(shops);
		//return template.find(new Query(where("rankTagIds").all(dishRankTagIds).and("shopId").in(shopIds)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().all("rankTagIds", dishRankTagId).in("shopId", shopIds));
	}
	@Override
	public List<Dish> rankDishWithRankTag(String areaId,
			String... dishRankTagIds) {
		List<Shop> shops = this.getSimpleShopsWithinArea(areaId);
		List<String> shopIds = this.transformShopListToShopIdList(shops);
		//return template.find(new Query(where("rankTagIds").all(dishRankTagIds).and("shopId").in(shopIds)), Dish.class);
		return dishDao.findByParams(CriteriaWrapper.instance().all("rankTagIds", (Object[])dishRankTagIds).in("shopId", shopIds));
	}
	

}
