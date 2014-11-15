package com.fan1tuan.order.test;


import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;

public class TestShoppingCart {

	String path=System.getProperty("user.dir");
	ApplicationContext ctx =new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
	ShoppingCartService shoppingCartService = (ShoppingCartService)ctx.getBean("shoppingCartService");
	
	@Test
	public void test() {
		
		
		//removeOneShopItem();
		addOneDishItemToCart();
		//upsertDishItemNumber();
		//decreaseDishItemNumber();
		//removeOneDishItems();
		//saveShoppingCart();
	}
	
	public void saveShoppingCart()
	{
		ShopItem shopItem1 = new ShopItem();
		shopItem1.setShopId("123");
		shopItem1.setSumPrice(8000);
		shopItem1.setDishItems(null);
		
		ShopItem shopItem2 = new ShopItem();
		shopItem2.setShopId("345");
		shopItem2.setSumPrice(8000);
		shopItem2.setDishItems(null);
		
		ArrayList<ShopItem> shopItems = new ArrayList<ShopItem>();
		shopItems.add(shopItem1);
		shopItems.add(shopItem2);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setPrice(100);
		shoppingCart.setUserId("56126378");
		shoppingCart.setShopItems(shopItems);
		
		shoppingCartService.saveShopingCart(shoppingCart);
	}
	
	public void removeOneShopItem()
	{
		shoppingCartService.removeOneShopItemByIdByShopId("5278f8f3b0df82070595a542", "345");
	}
	
	
	//添加一个DishItem到shoppingcart中对应的shopItem
	public void addOneDishItemToCart()
	{
		DishItem dishItem = new DishItem();
		dishItem.setDishId("123");
		dishItem.setDishPrice(100);
		dishItem.setNumber(1);
		
		shoppingCartService.addOneDishItem("0ef8fe9b-3524-444f-8246-1dd4c9d65d05", "123", dishItem);
	}
	
	
	//更变某个DishItem的数量number
	public void upsertDishItemNumber()
	{
		//shoppingCartService.upsertDishitemNumberById("0ef8fe9b-3524-444f-8246-1dd4c9d65d05", "123", "123", 10);
		shoppingCartService.upsertDishItemNumberByUserId("56126378", "123", "123", 0);//传入0时，默认为自增1
	}
	
	public void decreaseDishItemNumber()
	{
		shoppingCartService.decreaseDishItemNumberByIdByShopIdByDishId("0ef8fe9b-3524-444f-8246-1dd4c9d65d05", "123", "123");
	}
	
	//删除一个dishItem
	public void removeOneDishItems()
	{
		shoppingCartService.removeOneDishItemById("0ef8fe9b-3524-444f-8246-1dd4c9d65d05", "123", "123");
	}

}
