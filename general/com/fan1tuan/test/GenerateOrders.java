package com.fan1tuan.test;


import java.io.File;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.util.DateUtil;
import com.fan1tuan.order.pojos.Order;

public class GenerateOrders {

	char sep = File.separatorChar;
	ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");
	OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
	
	@Test
	public void test() {
		generte();
	}
	
	public void generte(){
		for(int i=0; i<=100; i++){
			Order order = new Order();
			order.setPrice(i);
			order.setDate(DateUtil.now());
			order.setUserId("111222333");
			order.setShopId("52a72733077b95c86da140f3");
			order.setOrderNo("F1T007");
			order.setStatus(1);
			orderDao.add(order);
		}
	}

}
