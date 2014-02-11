package com.fan1tuan.test;

import java.util.Date;

import com.fan1tuan.general.util.DateUtil;



public class MainTest {
	public static void main(String[] args){
//		String url = "http://localhost:8080/CarsiLogCenter_new/idpstat.jsp?action=idp.sptopn&greeting=中文哦";
//		System.err.println(StringUtil.decodeURL(StringUtil.encodeURL(url)));
//		
//		System.out.println("Houhou, It's a good day!!!!!");
		
		Date date = DateUtil.addMinutesToDate(DateUtil.getNearestQuarter(new Date()),13);
		
		System.err.println(date.toString());
		
	}
}
