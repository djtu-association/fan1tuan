package com.fan1tuan.order.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.dao.impl.ShoppingCartDao;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;

public class GenerateShoppingCart {

	String path=System.getProperty("user.dir");
	ApplicationContext ctx =new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
	ShoppingCartService shoppingCartService = (ShoppingCartService)ctx.getBean("shoppingCartService");
	
	@Test
	public void test() {
		create();
	}
	
	public void create(){
		ShoppingCart shoppingCart = new ShoppingCart();
		
		ShopItem shopItem1 = new ShopItem();
		ShopItem shopItem2 = new ShopItem();
		ShopItem shopItem3 = new ShopItem();
		
		DishItem dishItem1 = new DishItem();
		DishItem dishItem2 = new DishItem();
		DishItem dishItem3 = new DishItem();
		
		dishItem1.setDishId("529eea077d0e4556bb69e203");
		dishItem1.setDishName("JOE");
		dishItem1.setDishPrice(100);
		dishItem1.setNumber(10);
		
		dishItem2.setDishId("529eea077d0e4556bb69e208");
		dishItem2.setDishName("LIHE");
		dishItem2.setDishPrice(200);
		dishItem2.setNumber(20);
		
		dishItem3.setDishId("529eea077d0e4556bb69e215");
		dishItem3.setDishName("YAO");
		dishItem3.setDishPrice(300);
		dishItem3.setNumber(30);
		
		ArrayList<DishItem> dishItems = new ArrayList<DishItem>();
		dishItems.add(dishItem1);
		dishItems.add(dishItem2);
		dishItems.add(dishItem3);
		
		shopItem1.setDishItems(dishItems);
		shopItem1.setShopName("JOE'SHOP");
		shopItem1.setShopId("529eea077d0e4556bb69e1c6");
		shopItem1.setSumPrice(500);
		
		shopItem2.setDishItems(dishItems);
		shopItem2.setShopId("529eea077d0e4556bb69e1c7");
		shopItem2.setShopName("LIHE'SHOP");
		shopItem2.setSumPrice(1000);
		
		shopItem3.setDishItems(dishItems);
		shopItem3.setShopId("529eea077d0e4556bb69e1c8");
		shopItem3.setShopName("YAO'SHOP");
		shopItem3.setSumPrice(1500);
		
		ArrayList<ShopItem> shopItems = new ArrayList<ShopItem>();
		shopItems.add(shopItem1);
		shopItems.add(shopItem2);
		shopItems.add(shopItem3);			
		
		shoppingCart.setShopItems(shopItems);
		shoppingCart.setPrice(1000);
		shoppingCart.setUserId("529eea077d0e4556bb69e1c3");
		
		//shoppingCartService.saveShopingCart(shoppingCart);
		
		//System.out.println(shoppingCartService.convertShoppingCart(shoppingCart));
	}

	public void deal(){
		
		
	}
}
