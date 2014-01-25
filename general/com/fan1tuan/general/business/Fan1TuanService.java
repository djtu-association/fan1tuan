package com.fan1tuan.general.business;

import org.springframework.data.mongodb.core.MongoTemplate;


public interface Fan1TuanService {
	public void setTemplate(MongoTemplate template);
	public MongoTemplate getTemplate();
}
