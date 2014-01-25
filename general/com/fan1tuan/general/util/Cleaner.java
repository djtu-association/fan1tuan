package com.fan1tuan.general.util;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

public class Cleaner {
	private MongoOperations operations;
	public void setTemplate(MongoTemplate mongoTemplate){
		this.operations = mongoTemplate;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)operations;
	}
	
	public boolean cleanup(){
		for(String name : operations.getCollectionNames()){
			try{
				operations.dropCollection(name);
			}catch(Exception exception){
				System.out.println(name + " collection cannot drop! next!");
			}
		}
		
		return true;
	}
}
