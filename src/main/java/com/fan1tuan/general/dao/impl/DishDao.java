package com.fan1tuan.general.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.shop.pojos.Dish;

public class DishDao extends Fan1TuanDaoImpl<Dish>{
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
}
