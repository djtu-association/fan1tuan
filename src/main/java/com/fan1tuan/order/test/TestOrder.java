package com.fan1tuan.order.test;

import org.junit.Test;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.order.business.OrderUserService;
import com.fan1tuan.order.business.mongoImpl.OrderUserServiceImpl;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.order.util.SystemOutEntity;

public class TestOrder {
	
	String path=System.getProperty("user.dir");
	ApplicationContext ctx=new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");		
	//OrderUserService orderUserService = (OrderUserService)ctx.getBean(OrderUserServiceImpl.class);
	OrderUserService orderUserService = (OrderUserService)ctx.getBean("orderUserService");
	
	@Test
	public void testRemoveOrder()
	{
		//orderUserSerivce.dropOrderByOrderId("522aebacf62b3e354bdbe589");
		Order order = CollectionFactory.getOrder();
		orderUserService.saveOrder(order);
		//System.out.println(order);
		SystemOutEntity.stoutEntity(order);
	}
	
	/*
	@Test
	public void testSaveUser() {
		
		String path=System.getProperty("user.dir");
		ApplicationContext ctx=new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
		
		OrderUserService orderUserSerivce = (OrderUserService)ctx.getBean(OrderUserServiceImpl.class);
		orderUserSerivce.saveShopcartToOrder(CollectionFactory.getOrder());
		
		
	}
	
	@Test
	public void testDelDishItem(){
		String path=System.getProperty("user.dir");
		ApplicationContext ctx=new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
		
		OrderUserService orderUserSerivce = (OrderUserService)ctx.getBean(OrderUserServiceImpl.class);
		orderUserSerivce.delDishFromOrder("fdslk43221", "522ee09df62b5bf16f0abd96");
	}
	*/
	
	//add
	/*
	@Test
	public void testAddDishItem()
	{
		
		
		DishItem dishItem = new DishItem();
		dishItem.setDishPrice(20);
		dishItem.setNumber(3);
		
		orderUserSerivce.addDishToOrder(dishItem, "522ee09df62b5bf16f0abd96");
	}
	*/
	//remove
	
	
}
