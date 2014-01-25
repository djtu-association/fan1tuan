package com.fan1tuan.general.dao;

import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.Metric;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.NearQuery;

public class NearCriteriaWrapper {
	private NearQuery nearQuery;
	
	private NearCriteriaWrapper(Point point){
		nearQuery = NearQuery.near(point);
	}
	private NearCriteriaWrapper(double x, double y){
		nearQuery = NearQuery.near(x, y);
	}
	private NearCriteriaWrapper(double x, double y, Metric metric){
		nearQuery = NearQuery.near(x, y, metric);
	}
	private NearCriteriaWrapper(Point point, Metric metric){
		nearQuery = NearQuery.near( point, metric);
	}
	
	// --static init method
	public static NearCriteriaWrapper near(Point point){
		return new NearCriteriaWrapper(point);
	}
	public static NearCriteriaWrapper near(double x, double y){
		return new NearCriteriaWrapper(x, y);
	}
	public static NearCriteriaWrapper near(double x, double y, Metric metric){
		return new NearCriteriaWrapper(x, y, metric);
	}
	public static NearCriteriaWrapper near(Point point, Metric metric){
		return new NearCriteriaWrapper(point, metric);
	}
	
	// --convert unit methods
	public NearCriteriaWrapper inKilometers(){
		nearQuery.inKilometers();
		return this;
	}
	public NearCriteriaWrapper inMiles(){
		nearQuery.inMiles();
		return this;
	}
	public NearCriteriaWrapper inMetric(Metric metric){
		nearQuery.in(metric);
		return this;
	}
	
	// --set max distance for Geo points inclusion
	public NearCriteriaWrapper maxDistance(Distance distance){
		nearQuery.maxDistance(distance);
		return this;
	}
	public NearCriteriaWrapper maxDistance(double distance){
		nearQuery.maxDistance(distance);
		return this;
	}
	public NearCriteriaWrapper maxDistance(double distance, Metric metric){
		nearQuery.maxDistance(distance, metric);
		return this;
	}
	
	// --end
	public NearQuery getNearQuery(){
		return nearQuery;
	}
}
