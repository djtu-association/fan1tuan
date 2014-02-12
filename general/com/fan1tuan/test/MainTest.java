package com.fan1tuan.test;

import java.util.Date;

import com.fan1tuan.general.util.StringUtil;



public class MainTest {
	public static void main(String[] args){
//		String url = "http://localhost:8080/CarsiLogCenter_new/idpstat.jsp?action=idp.sptopn&greeting=中文哦";
//		System.err.println(StringUtil.decodeURL(StringUtil.encodeURL(url)));
//		
//		System.out.println("Houhou, It's a good day!!!!!");
		
		
		System.err.println(StringUtil.generateOrderNo("52a5228730044a63597e0cf4", new Date()));
		
	}
}
