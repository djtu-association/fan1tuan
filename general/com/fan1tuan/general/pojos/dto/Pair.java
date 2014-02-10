package com.fan1tuan.general.pojos.dto;

import com.fan1tuan.general.pojos.EntityObject;

public class Pair<T, U> extends EntityObject{
	
	private T cachedData;
	private U viewedData;
	
	public Pair() {
	}

	public Pair(T cachedData, U viewedData){
		this.cachedData = cachedData;
		this.viewedData = viewedData;
	}

	public T getCachedData() {
		return cachedData;
	}

	public void setCachedData(T cachedData) {
		this.cachedData = cachedData;
	}

	public U getViewedData() {
		return viewedData;
	}

	public void setViewedData(U viewedData) {
		this.viewedData = viewedData;
	}
	
	
}
