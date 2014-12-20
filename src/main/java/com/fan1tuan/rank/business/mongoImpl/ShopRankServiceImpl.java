package com.fan1tuan.rank.business.mongoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.QueryWrapper;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.general.util.Constants.RankAccord;
import com.fan1tuan.general.util.Constants.ShopState;
import com.fan1tuan.general.util.Constants.ShopType;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.rank.business.ShopRankService;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopGeo;

public class ShopRankServiceImpl implements ShopRankService {
	/*
	private MongoTemplate template;
	public static int ORDERTYPE_ONLINE = 1;
	public static int ORDERTYPE_PHONECALL = 2;
	public static int ORDERTYPE_PREORDER = 3;
	
	public static int SHOPTYPE_ALL = 0;
	public static int SHOPTYPE_REALSTATE = 1;
	public static int SHOPTYPE_RETAIL = 2;
	public static int SHOPTYPE_RESTAURANT = 3;
	
	public static int ORDER_ASC = 0;
	public static int ORDER_DESC = 1;
	
	public static int STATE_ALL = 0;
	public static int STATE_OPEN = 1;
	public static int STATE_CLOSE = 2;
	
	@Override
	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	@Override
	public MongoTemplate getTemplate() {
		return this.template;
	}
	*/
	/*
	 * orderType:1在线,2电话,3餐位
	 * shopType:0全部,1实体店,2摊位,3酒店
	 * shopTasteTagIds:null or ?
	 * shopAffairTagIds:null or ?
	 * order:0升序,1降序
	 * open:0全部,1开门,2关门
	 * (non-Javadoc)
	 * @see com.fan1tuan.rank.business.ShopRankService#rankShopWithPopularityWithOrderTypeWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinArea(int, int, java.util.List, java.util.List, int, boolean, java.lang.String)
	 */
	/*
	@Override
	public List<Shop> rankShopWithPopularityWithOrderTypeWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(
			int orderType, int shopType, List<String> shopTasteTagIds,
			List<String> shopAffairTagIds, int order, int open,
			String areaId,int limit, int skip) {
		Circle circle = this.makeCircleWithArea(areaId);
		
		Criteria criteria = Criteria.where("orderType").is(orderType);
		
		if(shopType!=SHOPTYPE_ALL){
			criteria.and("type").is(shopType);
		}
		
		if(shopTasteTagIds!=null){
			criteria.and("shopTasteTagIds").all(shopTasteTagIds);
		}
		
		if(shopAffairTagIds!=null){
			criteria.and("shopAffairTagIds").all(shopAffairTagIds);
		}
		
		if(open!=STATE_ALL){
			if(open==STATE_OPEN){
				criteria.and("open").is(true);
			}else{
				criteria.and("open").is(false);
			}
		}
		criteria.and("location").within(circle);
		
		Sort.Order sortOrder;
		if(order==ORDER_ASC){
			sortOrder = new Sort.Order(Sort.Direction.ASC, "popularity");
		}else{
			sortOrder = new Sort.Order(Sort.Direction.DESC, "popularity");
		}
		Query query = new Query(criteria).with(new Sort(sortOrder)).skip(skip).limit(limit);
		
		return template.find(query, Shop.class);
	}

	@Override
	public List<Shop> rankShopWithSaleVolumeWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(
			int shopType, List<String> shopTasteTagIds,
			List<String> shopAffairTagIds, int order, int open,
			String areaId,int limit, int skip) {
		return this.rankOnlineShopByAccording("saleVolume", shopType, shopTasteTagIds, shopAffairTagIds, order, open, areaId, limit, skip);
	}

	@Override
	public List<Shop> rankShopWithCommentLevelWithTypeWithShopTasteTagsWithShopAffairTagsInOrderIsOpenWithinAreaWithLimitAndSkip(
			int shopType, List<String> shopTasteTagIds,
			List<String> shopAffairTagIds, int order, int open,
			String areaId,int limit, int skip) {
		return this.rankOnlineShopByAccording("avgCommentLevel", shopType, shopTasteTagIds, shopAffairTagIds, order, open, areaId,limit, skip);
	}
	*/
	
	private AreaDao areaDao;
	private ShopDao shopDao;
	
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	public AreaDao getAreaDao() {
		return areaDao;
	}
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	
	@Override
	public List<Shop> rankPhoneCallShop(ShopType shopType,
			List<String> shopTasteTagIds, RankAccord accord,
			com.fan1tuan.general.util.Constants.Sort order, String areaId,
			Pageable pageable) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance()
				.is("orderType", Constants.OrderType.PHONECALL.ordinal())
				.all("shopTasteTagIds", shopTasteTagIds)
				.withinSphere("location", makeCircleWithArea(areaId));
		
		if(shopType != ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		
		Sortable sortable = null;
		if(accord == Constants.RankAccord.POPULARITY){
			sortable = Sortable.instance("popularity", order.ordinal());
		} else {
			sortable = Sortable.instance("popularity", order.ordinal());
		}
		pageable.setItemsNum(shopDao.getCount(criteriaWrapper));
		return shopDao.findByParamsInPageInOrder(criteriaWrapper, pageable, sortable);
	}

	@Override
	public List<Shop> rankOnlineShop(ShopType shopType,
			List<String> shopTasteTagIds, List<String> shopAffairTagIds,
			RankAccord accord, com.fan1tuan.general.util.Constants.Sort order,
			ShopState open, String areaId, Pageable pageble) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance()
				.is("orderType", Constants.OrderType.ONLINE.ordinal())
				.all("shopTasteTagIds", shopTasteTagIds)
				.all("shopAffairTagIds", shopAffairTagIds)
				.withinSphere("location", makeCircleWithArea(areaId));
		Sortable sortable = null;
		
		if(open == ShopState.OPEN){
			criteriaWrapper.is("open", true);
		}
		
		if(shopType != ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		
		if(accord == RankAccord.COMMENTLEVEL){
			sortable = Sortable.instance("avgCommentLevel", order.ordinal());
		}else if(accord == RankAccord.POPULARITY){
			sortable = Sortable.instance("popularity", order.ordinal());
		}else if(accord == RankAccord.SALEVOLUME){
			sortable = Sortable.instance("saleVolume", order.ordinal());
		}else{
			sortable = Sortable.instance("popularity", order.ordinal());
		}
		
		pageble.setItemsNum(shopDao.getCount(criteriaWrapper));
		return shopDao.findByParamsInPageInOrder(criteriaWrapper, pageble, sortable);
	}
	
	@Override
	public List<Shop> rankPhoneCallShop(String areaId, Pageable pageable) {
		return this.rankPhoneCallShop(ShopType.ALL, null, RankAccord.POPULARITY, Sort.DESC, areaId, pageable);
	}
	@Override
	public List<Shop> rankOnlineShop(String areaId, Pageable pageable) {
		return this.rankOnlineShop(ShopType.ALL, null, null, RankAccord.POPULARITY, Sort.DESC, ShopState.ALL, areaId, pageable);
	}
	
	@Override
	public List<Shop> rankShopWithRankTag(List<String> shopRankTagIds,
			String areaId) {
		Circle cricle = this.makeCircleWithArea(areaId);
		return shopDao.findByParams(CriteriaWrapper.instance().all("rankTagIds", shopRankTagIds).withinSphere("location", cricle));
	}
	
	
	//new added methods, use geo query 基于地理位置查询
	@Override
	public List<ShopGeo> rankPhoneCallShopGeos(ShopType shopType,
			List<String> shopTasteTagIds, RankAccord accord, Sort order,
			String areaId, Pageable pageable) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance()
				.is("orderType", Constants.OrderType.PHONECALL.ordinal())
				.all("shopTasteTagIds", shopTasteTagIds);
		
		
		if(shopType != ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		
		Sortable sortable;
		if(accord == Constants.RankAccord.POPULARITY){
			sortable = Sortable.instance("popularity", order.ordinal());
		} else {
			sortable = Sortable.instance("popularity", order.ordinal());
		}
		
		Circle circle = makeCircleWithArea(areaId);
		GeoResults<Shop> geoResults = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius().getValue()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, null, pageable).with(sortable.toSort()));
		
		List<ShopGeo> shopGeos = new ArrayList<ShopGeo>();
		for(GeoResult<Shop> geoResult: geoResults){
			shopGeos.add(new ShopGeo(geoResult.getContent(), geoResult.getDistance().getValue()));
		}
		//计算页数，实属无奈，查询需要两次
		GeoResults<Shop> pageCountResults = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius().getValue()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, FieldFilter.instance("id"), null));
		pageable.setItemsNum(pageCountResults.getContent().size());
		
		return shopGeos;
	}
	@Override
	public List<ShopGeo> rankPhoneCallShopGeos(String areaId, Pageable pageable) {
		return this.rankPhoneCallShopGeos(ShopType.ALL, null, RankAccord.POPULARITY, Sort.DESC, areaId, pageable);
	}
	@Override
	public List<ShopGeo> rankOnlineShopGeos(ShopType shopType,
			List<String> shopTasteTagIds, List<String> shopAffairTagIds,
			RankAccord accord, Sort order, ShopState open, String areaId,
			Pageable pageable) {
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance()
				.is("orderType", Constants.OrderType.ONLINE.ordinal())
				.all("shopTasteTagIds", shopTasteTagIds)
				.all("shopAffairTagIds", shopAffairTagIds);
		Sortable sortable = null;

		if(open == ShopState.OPEN){
			criteriaWrapper.is("open", true);
		}
		
		if(shopType != ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		
		if(accord == RankAccord.COMMENTLEVEL){
			sortable = Sortable.instance("avgCommentLevel", order.ordinal());
		}else if(accord == RankAccord.POPULARITY){
			sortable = Sortable.instance("popularity", order.ordinal());
		}else if(accord == RankAccord.SALEVOLUME){
			sortable = Sortable.instance("saleVolume", order.ordinal());
		}else{
			sortable = Sortable.instance("popularity", order.ordinal());
		}

		//pageable.setPageSize(pageable.getPageSize()-1);

		Circle circle = makeCircleWithArea(areaId);
		GeoResults<Shop> geoResults = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius().getValue()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, null, pageable).with(sortable.toSort()));
		List<ShopGeo> shopGeos = new ArrayList<ShopGeo>();
		for(GeoResult<Shop> geoResult: geoResults){
			shopGeos.add(new ShopGeo(geoResult.getContent(), geoResult.getDistance().getValue()));
		}
		//System.out.println("!!!size:"+shopGeos.size()+"\n"+pageable.getPageSize());

		//计算页数，实属无奈，查询需要两次
		GeoResults<Shop> pageCountResults = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius().getValue()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, FieldFilter.instance("id"), null));
		pageable.setItemsNum(pageCountResults.getContent().size());
		
		return shopGeos;
		
	}
	@Override
	public List<ShopGeo> rankOnlineShopGeos(String areaId, Pageable pageable) {
		return this.rankOnlineShopGeos(ShopType.ALL, null, null, RankAccord.POPULARITY, Sort.DESC, ShopState.OPEN, areaId, pageable);

	}


	@Override
	public List<String> transformShopListToShopIdList(List<Shop> shops) {
		List<String> list = new ArrayList<String>();
		for(Shop shop: shops){
			list.add(shop.getId());
		}
		return list;
	}
	
	
	
	private Circle makeCircleWithArea(String areaId){
		Area area = areaDao.findOneById(areaId);
		return new Circle(area.getLongtitude(), area.getLatitude(), area.getRadius());
	}
	/*
	private List<Shop> rankOnlineShopByAccording(String accordingField, int shopType, List<String> shopTasteTagIds,
			List<String> shopAffairTagIds, int order, int open,
			String areaId,int limit, int skip){
		Circle circle = this.makeCircleWithArea(areaId);
		
		Criteria criteria = Criteria.where("orderType").is(ORDERTYPE_ONLINE);
		
		if(shopType!=SHOPTYPE_ALL){
			criteria.and("type").is(shopType);
		}
		
		if(shopTasteTagIds!=null){
			criteria.and("shopTasteTagIds").all(shopTasteTagIds);
		}
		
		if(shopAffairTagIds!=null){
			criteria.and("shopAffairTagIds").all(shopAffairTagIds);
		}
		
		if(open!=STATE_ALL){
			if(open==STATE_OPEN){
				criteria.and("open").is(true);
			}else{
				criteria.and("open").is(false);
			}
		}
		criteria.and("location").within(circle);
		
		Sort.Order sortOrder;
		if(order==ORDER_ASC){
			sortOrder = new Sort.Order(Sort.Direction.ASC, accordingField);
		}else{
			sortOrder = new Sort.Order(Sort.Direction.DESC, accordingField);
		}
		Query query = new Query(criteria).with(new Sort(sortOrder)).skip(skip).limit(limit);
		
		return template.find(query, Shop.class);
	}
	*/
	
	
	

}
