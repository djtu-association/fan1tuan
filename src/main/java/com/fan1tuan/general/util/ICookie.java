package com.fan1tuan.general.util;

public class ICookie {
	//base
	//public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
	public static final int COOKIE_AGE = 60*60*24*15;//15天
	
	//USER_CACHE的value格式：userId::Cellphone::timestamp,Timestamp是一个long类型的数字串
	public static final String USER_CACHE = "USER_CACHE";//登陆用户
	//AREA_CONFIG的value格式：AreaId::AreaName
	public static final String AREA_CONFIG = "AREA_CACHE";//地区
	//COOKIE SEPRATOR
	public static final String SEPERATOR = "::";
	
}
