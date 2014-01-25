package com.fan1tuan.general.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;


public class Sortable {
	public final static int ASCEND = 0;
	public final static int DESCEND = 1;
	
	private Map<String, Integer> sortMap = new HashMap<String, Integer>();
	
	private Sortable(){
		
	}
	
	private Sortable(String field, int sort){
		sortMap.put(field, sort);
	}
	
	public static Sortable instance(String field, int sort){
		Sortable sortable = new Sortable(field, sort);
		return sortable;
	}
	
	public Sortable and(String field, int sort){
		this.sortMap.put(field, sort);
		return this;
	}
	
	public Map<String, Integer> getSortInfo(){
		return sortMap;
	}
	
	public Sort toSort(){
		List<Sort.Order> list = new ArrayList<Sort.Order>();
		
		for(Map.Entry<String, Integer> entry : sortMap.entrySet()){
			Sort.Order order = null;
			if(entry.getValue()==ASCEND){
				order = new Sort.Order(Sort.Direction.ASC, entry.getKey());
			}else{
				order = new Sort.Order(Sort.Direction.DESC, entry.getKey());
			}
			
			list.add(order);
		}
		
		return new Sort(list);
	}
}
