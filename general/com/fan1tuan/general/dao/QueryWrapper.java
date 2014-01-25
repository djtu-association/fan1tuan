package com.fan1tuan.general.dao;

import org.springframework.data.mongodb.core.query.Query;



public class QueryWrapper {

	public static Query wrap(String id){
		return wrap(CriteriaWrapper.instance().is("id", id), null, null);
	}
	
	public static Query wrap(CriteriaWrapper criteriaWrapper){
		return wrap(criteriaWrapper, null, null);
	}
	

	public static Query wrap(FieldFilter fieldFilter){
		return wrap(null, fieldFilter, null);
	}
	
	public static Query wrap(FieldFilter fieldFilter, Pageable pageable){
		return wrap(null, fieldFilter, pageable);
	}
	
	public static Query wrap(CriteriaWrapper criteriaWrapper, FieldFilter fieldFilter, Pageable pageable){
		Query query = null;
		if(criteriaWrapper==null||criteriaWrapper.getCriteria()==null){
			query = new Query();
		}else{
			query = new Query(criteriaWrapper.getCriteria());
		}
		
		if(fieldFilter!=null&&fieldFilter.getParams()!=null){
			for(String field : fieldFilter.getParams()){
				query.fields().include(field);
			}
		}
		
		if(pageable!=null){
			query.skip(pageable.getOffset()).limit(pageable.getPageSize());
		}
		
		return query;

	}
	
}
