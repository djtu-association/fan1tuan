package com.fan1tuan.general.pojos;

public class Area extends EntityObject{
	private String id;
	private String name;
	private double latitude;
	private double longtitude;
	private double radius;
	
	public Area() {}

	public Area(String name, double latitude, double longtitude, double radius) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.radius = radius;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}
