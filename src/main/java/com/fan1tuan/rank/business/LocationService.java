package com.fan1tuan.rank.business;

import org.springframework.data.mongodb.core.geo.GeoResults;

import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.shop.pojos.Shop;

public interface LocationService extends IFan1TuanService{
	public GeoResults<Shop> getShopsGeoResults(String areaId);
}
