package com.fan1tuan.search.business.mongoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.QueryWrapper;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.search.business.SearchService;
import com.fan1tuan.search.pojos.DishSearchItem;
import com.fan1tuan.search.pojos.ShopSearchItem;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.Shop;
import org.springframework.data.geo.*;

public class SearchServiceImpl implements SearchService{

	private DishDao dishDao;
	private ShopDao shopDao;
	private AreaDao areaDao;

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

	//-------------------------------------------------------- method below------
	
	@Override
	public List<ShopSearchItem> searchForKeyword(String keyword, String areaId) {
		return null;
	}

	@Override
	public List<Shop> searchShopsForKeyword(String keyword, String areaId) {
		List<String> shopIds = transformShopListToShopIdList(getSimpleShops(Constants.ShopType.ALL, Constants.ShopState.ALL, areaId));

		return shopDao.findProjectedByParams(CriteriaWrapper.instance().regex("name", Pattern.compile(".*("+keyword+").*")).in("id", shopIds), FieldFilter.instance("id", "name", "avatar"));
	}

	@Override
	public List<Dish> searchDishesForKeyword(String keyword, String areaId) {
		List<String> shopIds = transformShopListToShopIdList(getSimpleShops(Constants.ShopType.ALL, Constants.ShopState.ALL, areaId));

		return dishDao.findProjectedByParams(CriteriaWrapper.instance().regex("name", Pattern.compile(".*("+keyword+").*")).in("shopId", shopIds), FieldFilter.instance("id", "shopId", "name", "image", "price", "description"));
	}

	@Override
	public List<ShopSearchItem> searchShopAutoComplete(String keyword,
			String areaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DishSearchItem> searchDishAutoComplete(String keyword,
			String areaId) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<Shop> getSimpleShops(Constants.ShopType shopType, Constants.ShopState open, String areaId){
		//CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance().withinSphere("location", makeCircleWithArea(areaId));
		CriteriaWrapper criteriaWrapper = CriteriaWrapper.instance();

		if(shopType!= Constants.ShopType.ALL){
			criteriaWrapper.is("type", shopType.ordinal());
		}
		if(open== Constants.ShopState.OPEN){
			criteriaWrapper.is("open", true);
		}

		criteriaWrapper.is("orderType", Constants.OrderType.ONLINE.ordinal());

		Circle circle = makeCircleWithArea(areaId);
		GeoResults<Shop> shopGeos = shopDao.getGeoResults(circle.getCenter(), new Distance(circle.getRadius().getValue()/1000, Metrics.KILOMETERS), QueryWrapper.wrap(criteriaWrapper, FieldFilter.instance("id"), null));
		List<Shop> shops = new ArrayList<Shop>();
		for(GeoResult<Shop> geoResult:shopGeos){
			shops.add(geoResult.getContent());
		}

		return shops;
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

}
