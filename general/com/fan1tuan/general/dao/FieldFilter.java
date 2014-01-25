package com.fan1tuan.general.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FieldFilter {
private List<String> includedFields = new ArrayList<String>();
	
	private FieldFilter() {
	}
	
	private FieldFilter(String field){
		includedFields.add(field);
	}
	
	/**
	 * 返回单个实体的ParamMapper
	 * @param key
	 * @param value
	 * @return
	 */
	public static FieldFilter instance(String field){
		FieldFilter filter = new FieldFilter(field);
		return filter;
	}
	
	public static FieldFilter instance(Collection<String> fields){
		FieldFilter filter = new FieldFilter();
		filter.addAll(fields);
		return filter;
	}
	
	public static FieldFilter instance(String... fields){
		FieldFilter filter = new FieldFilter();
		filter.addAll(Arrays.asList(fields));
		return filter;
	}
	
	/**
	 * 向ParamMapper添加一个实体
	 * @param key
	 * @param value
	 * @return
	 */
	public FieldFilter add(String field){
		this.includedFields.add(field);
		return this;
	}
	
	public FieldFilter addAll(Collection<String> fields){
		this.includedFields.addAll(fields);
		return this;
	}
	
	public FieldFilter addAll(String... fields){
		this.includedFields.addAll(Arrays.asList(fields));
		return this;
	}
	
	public List<String> getParams(){
		return this.includedFields;
	}
}
