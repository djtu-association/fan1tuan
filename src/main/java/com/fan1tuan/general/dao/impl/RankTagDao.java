package com.fan1tuan.general.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.shop.pojos.RankTag;

public class RankTagDao extends Fan1TuanDaoImpl<RankTag>{
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
}
