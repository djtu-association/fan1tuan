package com.fan1tuan.rank.business.mongoImpl.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Circle;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.RankTagDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.rank.business.task.DishRankTask;
import com.fan1tuan.shop.pojos.Shop;

public class DishRankTaskImpl implements DishRankTask{

	private DishDao dishDao;
	private RankTagDao rankTagDao;
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

	
	
	@Override
	public boolean analyseWeekStarDish(String areaId) {
		List<Shop> shops = shopDao.findProjectedByParams(CriteriaWrapper.instance().withinSphere("location", makeCircleWithArea(areaId)), FieldFilter.instance("id"));
		List<String> shopIds = transformShopListToShopIdList(shops);
		dishDao.updateMultiByParams(CriteriaWrapper.instance().in("shopId", shopIds), Pageable.inPage(0, 4), Sortable.instance("saleVolume", Constants.Sort.DESC.ordinal()), UpdateWrapper.instance().addToSet("rankTagIds", rankTagDao.findOneByParams(CriteriaWrapper.instance().is("name", "每周之星"))));
		return true;
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
