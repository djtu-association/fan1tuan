package com.fan1tuan.order.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class DishItem extends EntityObject{
	private String dishImage; // new added

	private String dishId;
	private int number;
	private String dishName;
	private double dishPrice;
	private double dishSum;
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	public DishItem(String dishId, int number, double dishPrice) {
		super();
		this.dishId = dishId;
		this.number = number;
		this.dishPrice = dishPrice;
	}



	public DishItem() {}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getDishSum() {
		return dishSum;
	}
	public void setDishSum(double dishSum) {
		this.dishSum = dishSum;
	}
	public String getDishImage() {
		return dishImage;
	}
	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}
	/*
	@Override
	public boolean equals(Object obj){
		if(this.getDishId().equals(((DishItem)obj).getDishId())){
			return true;
		}
		return false;
	}
	*/
}
