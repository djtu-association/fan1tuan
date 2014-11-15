package com.fan1tuan.general.webservices;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class Fan1TuanApplication extends PackagesResourceConfig {
	public Fan1TuanApplication(){
		super("com.fan1tuan.general.webservices;"
				+ "com.fan1tuan.order.webservices;"
				+ "com.fan1tuan.rank.webservices;"
				+ "com.fan1tuan.search.webservices;"
				+ "com.fan1tuan.shop.webservices;"
				+ "com.fan1tuan.user.webservices");
	}
}
