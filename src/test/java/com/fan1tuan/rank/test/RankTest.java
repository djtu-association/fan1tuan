package com.fan1tuan.rank.test;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.util.Constants.RankAccord;
import com.fan1tuan.general.util.Constants.ShopState;
import com.fan1tuan.general.util.Constants.ShopType;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.rank.business.ShopRankService;
import com.fan1tuan.shop.pojos.ShopGeo;

public class RankTest {
	@Test
	public void testGeoMethods(){
		char sep = File.separatorChar;
		ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");

		ShopRankService shopRankService = (ShopRankService)ctx.getBean("shopRankService");
		
		List<ShopGeo> shopGeos = shopRankService.rankOnlineShopGeos(ShopType.valueOf(2), null, null, RankAccord.valueOf(0), Sort.valueOf(1), ShopState.valueOf(2), "52a72733077b95c86da140d8", Pageable.inPage(0, 10));
		shopGeos = shopRankService.rankOnlineShopGeos(ShopType.ALL, null, null, RankAccord.POPULARITY, Sort.DESC, ShopState.ALL, "52a72733077b95c86da140d8", Pageable.inPage(0, 10));

		
		for(ShopGeo shopGeo : shopGeos){
			System.out.println(shopGeo.getContent().isOpen());
		}
		
	}
}
