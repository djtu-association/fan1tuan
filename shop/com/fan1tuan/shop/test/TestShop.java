package com.fan1tuan.shop.test;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.rank.business.ShopRankService;
import com.fan1tuan.shop.pojos.ShopGeo;

@SuppressWarnings("resource")
public class TestShop {
	/*
	@Test
	public void testAddShopClient() {
		char sep = File.separatorChar;
		ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");

		ShopRankService shopRankService = (ShopRankService)ctx.getBean("shopRankService");
		ShopDao shopDao = (ShopDao)ctx.getBean("shopDao");
		
		List<Shop> shops = shopRankService.rankOnlineShop("529cc67c30049538d7d5f1f3", Pageable.inPage(0, 10));
		System.out.println(shops.size());
		for(Shop shop : shops){
			System.out.println(shop.toJSON());
		}		
	}
	*/
	/*
	@Test
	public void testFillDishComments(){
		char sep = File.separatorChar;
		ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");

		Generator generator = (Generator)ctx.getBean("generator");
		
		generator.fillShopComments("529eea077d0e4556bb69e1c7", 7, 20);
		
	}
	*/
	@Test
	public void testGeoMethods(){
		char sep = File.separatorChar;
		ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");

		ShopRankService shopRankService = (ShopRankService)ctx.getBean("shopRankService");
		
		List<ShopGeo> shops = shopRankService.rankOnlineShopGeos("52a5228130044a63597de8e4", Pageable.inPage(0, 50));
		for(ShopGeo geoResult : shops){
			System.out.println(geoResult.getContent().toJSON()+"\n"+geoResult.getDistance());
		}
	}
}
