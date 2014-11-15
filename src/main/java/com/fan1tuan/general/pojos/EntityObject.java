package com.fan1tuan.general.pojos;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

public class EntityObject {
	public static final String GETTER_PREFIX = "get";
	
	
	public JSONObject toJSON(){
		try{
			Method[] methods = getClass().getDeclaredMethods();
			ArrayList<Method> methodList = new ArrayList<Method>();
			ArrayList<String> fieldNameList = new ArrayList<String>();
			for(Method method : methods){
				if(method.getName().startsWith(GETTER_PREFIX)){
					methodList.add(method);
					String fieldName = Character.toLowerCase(method.getName().charAt(GETTER_PREFIX.length()))+method.getName().substring(GETTER_PREFIX.length()+1);
					fieldNameList.add(fieldName);
				}
			}
			
			JSONObject json = new JSONObject();
			
			for(int i = 0; i < methodList.size(); i++){
				Object object = methodList.get(i).invoke(this, (Object[])null);
				if(object instanceof EntityObject){
					object = ((EntityObject)object).toJSON();
				}else if(object instanceof Date){
					object = ((Date)object).getTime();
				}
				
				json.put(fieldNameList.get(i), object);
			}
			
			return json;
			
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}
	/*
	public static void main(String[] args){
		City city = new City();
		city.setAreaIds(new String[]{"04jdkl123", "hfsdkhfk12", "231jkrjew", "43ewffsa"});
		city.setId("fdsjrelkwfa");
		city.setName("济南");
		
		System.err.println(city.toJSON().toString());
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId("fsd92380fsda");
		shoppingCart.setPrice(192321.1);
		
		DishItem dishItem1 = new DishItem();
		dishItem1.setDishId("28490230dsfa");
		dishItem1.setDishPrice(12312);
		dishItem1.setNumber(2);
		
		DishItem dishItem2 = new DishItem();
		dishItem2.setDishId("fdsa221321");
		dishItem2.setDishPrice(321.3);
		dishItem2.setNumber(4);
		
		ShopItem shopItem = new ShopItem();
		shopItem.setDishItems(new DishItem[]{dishItem1, dishItem2});
		shopItem.setShopId("fdsfjalk221");
		shopItem.setSumPrice(321421);
		
		shoppingCart.setUserId("fdsajklqweq");
		shoppingCart.setShopItems(new ShopItem[]{shopItem});
		
		System.err.println(shoppingCart.toJSON());
		
		JSONObject json = new JSONObject();
		json.put("date", new Date().getTime());
		System.err.println(json.toString());
	}
	*/
}
