package com.fan1tuan.rank.business.mongoImpl;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metrics;
import org.springframework.data.mongodb.core.geo.Point;

import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.rank.business.LocationService;
import com.fan1tuan.shop.pojos.Shop;

public class LocationServiceImpl implements LocationService {
	private AreaDao areaDao;
	private ShopDao shopDao;
	
	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	
	@Override
	public GeoResults<Shop> getShopsGeoResults(String areaId) {
		//Point point = createPoint(areaId);
		Circle circle = createCircle(areaId);
		return shopDao.getGeoResults(circle.getCenter(), 3000, Metrics.KILOMETERS);
	}
	
	@SuppressWarnings("unused")
	private Point createPoint(String areaId){
		Area area = areaDao.findOneProjectedById(areaId, FieldFilter.instance("latitude","longtitude"));
		return new Point(area.getLongtitude(), area.getLatitude());
	}
	
	private Circle createCircle(String areaId){
		Area area = areaDao.findOneProjectedById(areaId, FieldFilter.instance("latitude","longtitude","radius"));
		return new Circle(area.getLongtitude(), area.getLatitude(), area.getRadius());
	}
	
}
