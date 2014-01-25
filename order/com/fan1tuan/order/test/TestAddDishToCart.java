package com.fan1tuan.order.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.order.business.ShoppingCartService;

public class TestAddDishToCart {

	String path=System.getProperty("user.dir");
	ApplicationContext ctx =new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
	ShoppingCartService shoppingCartService = (ShoppingCartService)ctx.getBean("shoppingCartService");
	
	@Test
	public void test() {
		//add();
		dec();
	}
	
	public void add(){
		//shoppingCartService.addOneDishToCartByUserId("529eea077d0e4556bb69e1c4", "529eea077d0e4556bb69e203");//小辣椒-牛肉堡
		//shoppingCartService.addOneDishToCartByUserId("529eea077d0e4556bb69e1c4", "529eea077d0e4556bb69e205");//小辣椒-土豆煲仔饭
		shoppingCartService.addOneDishToCartByUserId("529eea077d0e4556bb69e1c4", "529eea077d0e4556bb69e21a");//别家-焦糖布丁
	}
	
	public void dec(){
		shoppingCartService.removeOneDishItemByUserId("529eea077d0e4556bb69e1c4", "529eea077d0e4556bb69e21a");
	}

}
