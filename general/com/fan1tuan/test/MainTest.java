package com.fan1tuan.test;

import com.fan1tuan.general.util.StringUtil;


public class MainTest {
	public static void main(String[] args){
		String url = "http://localhost:8080/CarsiLogCenter_new/idpstat.jsp?action=idp.sptopn&greeting=中文哦";
		System.err.println(StringUtil.decodeURL(StringUtil.encodeURL(url)));
	}
}
