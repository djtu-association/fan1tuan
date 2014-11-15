package com.fan1tuan.general.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.order.pojos.Sequence;

public class SequenceDao extends Fan1TuanDaoImpl<Sequence> {
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
}
