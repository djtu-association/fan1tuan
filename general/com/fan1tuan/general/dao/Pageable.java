package com.fan1tuan.general.dao;

import java.util.List;


/*
 * Page Number 从0开始计算，跟数组一个标准
 */

public class Pageable {
	//page的大小
	private int pageSize;
	private int offset;
	//page的页号
	private int pageNumber;
	//共有多少个项目
	private long itemsNum;
	
	private Pageable() {}

	private Pageable(int pageSize, int pageNumber) {
		this();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.offset = this.pageSize * this.pageNumber;
	}

	public static Pageable inPage(int pageNumber, int pageSize){
		return new Pageable(pageSize, pageNumber);
	}
	
	/**
	 * BY JOE
	 * 返回页数
	 * @param object：数组
	 * @param pageSize:每页的数量
	 * @return
	 */
	public static int getPageLength(Object[] object,int pageSize){
		int length = object.length;
		if(length == 0)return 0;
		return (length<pageSize)?1:((length%pageSize==0)?(length/pageSize):(length/pageSize+1));
	}
	
	/**
	 * 返回页数
	 * @param object:集合
	 * @param pageSize：每页的数量
	 * @return
	 */
	public static int getPageLength(List<?> object,int pageSize){
		int length = object.toArray().length;
		if(length == 0)return 0;
		return (length<pageSize)?1:((length%pageSize==0)?(length/pageSize):(length/pageSize+1));
	}
	
	public static long getPageLength(long itemsNum,int pageSize){
		if(itemsNum == 0)return 0;
		return (itemsNum<pageSize)?1:((itemsNum%pageSize==0)?(itemsNum/pageSize):(itemsNum/pageSize+1));
	}
	//----------

	public int getPageNumber() {
		return pageNumber;
	}



	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(long itemsNum) {
		this.itemsNum = itemsNum;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public String toString(){
		return "pageNumber:"+pageNumber+";pageSize:"+pageSize;
	}
}
