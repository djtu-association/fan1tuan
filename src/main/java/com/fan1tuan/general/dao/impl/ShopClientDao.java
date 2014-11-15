package com.fan1tuan.general.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.shop.pojos.ShopClient;

public class ShopClientDao extends Fan1TuanDaoImpl<ShopClient>{
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
}
