package com.fan1tuan.general.dao.impl;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoResults;
import org.springframework.data.mongodb.core.geo.Metric;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.fan1tuan.general.dao.NearCriteriaWrapper;
import com.fan1tuan.shop.pojos.Shop;

public class ShopDao extends Fan1TuanDaoImpl<Shop>{
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
	
	
	public GeoResults<Shop> getGeoResults(double x, double y, double distance, Metric metric, Query query){
		NearQuery nearQuery = NearCriteriaWrapper.near(x, y).maxDistance(new Distance(distance, metric)).inMetric(metric).getNearQuery();
		if(query!=null){
			nearQuery.query(query);
		}
		return mongoOperations.geoNear(nearQuery, Shop.class);
	}
	
	public GeoResults<Shop> getGeoResults(Point point, double distance, Metric metric){
		return getGeoResults(point.getX(), point.getY(), distance, metric, null);
	}
	public GeoResults<Shop> getGeoResults(Point point, Distance distance){
		return getGeoResults(point.getX(),  point.getY(), distance.getValue(), distance.getMetric(), null);
	}
	public GeoResults<Shop> getGeoResults(Point point, Distance distance, Query query){
		return getGeoResults(point.getX(),  point.getY(), distance.getValue(), distance.getMetric(), query);
	}
}
