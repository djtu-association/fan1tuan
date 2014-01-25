package com.fan1tuan.general.dao;

import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

public class NearQueryWrapper {
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper){
		return criteriaWrapper.getNearQuery();
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Pageable pageable){
		return criteriaWrapper.getNearQuery().query(QueryWrapper.wrap(null, pageable));
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Pageable pageable, Sortable sortable){
		return criteriaWrapper.getNearQuery().query(QueryWrapper.wrap(null, pageable).with(sortable.toSort()));
	}
	
	public static NearQuery wrap(NearCriteriaWrapper criteriaWrapper, Query query){
		return criteriaWrapper.getNearQuery().query(query);
	}
}
