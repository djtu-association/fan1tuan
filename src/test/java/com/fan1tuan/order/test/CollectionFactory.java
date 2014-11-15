package com.fan1tuan.order.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;

public class CollectionFactory {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";

	public static String generateString(int length) //参数为返回随机数的长度
	{
	     StringBuffer sb = new StringBuffer();
	     Random random = new Random();
	     for (int i = 0; i < length; i++)
	     {
	    	 sb.append(allChar.charAt(random.nextInt(allChar.length())));
	     }
	    return sb.toString();
	}
	
	public static Order getOrder()
	{
		Order order = new Order();
		Random rd = new Random();
		
		order.setAddress(generateString(10));
		order.setCellphone(generateString(10));
		order.setChargeType(0);
		order.setDate(new Date());
		order.setDeliveryTime(new Date());
		order.setDescription(generateString(20));
		ArrayList<DishItem> items = new ArrayList<DishItem>();
		//items[0] = new DishItem();
		//items[0].setDishId(generateString(10));
		//items[0].setDishPrice(rd.nextInt());
		//items[0].setNumber(rd.nextInt());
		order.setDishItems(items);
		order.setOrderNo(generateString(10));
		order.setPrice(rd.nextInt());
		order.setShopId(generateString(10));
		order.setStatus(0);
		order.setTelephone(generateString(10));
		order.setUserId(generateString(10));
		return order;
	}
}
