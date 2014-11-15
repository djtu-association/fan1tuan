package com.fan1tuan.general.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.user.pojos.User;

public class UserDao extends Fan1TuanDaoImpl<User>{
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
}
