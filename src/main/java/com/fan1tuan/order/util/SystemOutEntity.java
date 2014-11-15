package com.fan1tuan.order.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.fan1tuan.general.pojos.EntityObject;

public class SystemOutEntity {
	
	public static void stoutEntity(Object object)
	{
		if(object instanceof EntityObject)
		{			
			System.out.print(entityToJson(object));
		}
		else if(object instanceof Date)
		{
			System.out.println(((Date) object).getTime());
		}
		else 
		{
			System.out.println(object);
		}
	}
	
	public static void stoutEntity(List<Object> objects)
	{
		if(objects instanceof List)
		{
			for(Object object : objects)
			{
				stoutEntity(object);
			}
		}
		
	}
	
	public static JSONObject entityToJson(Object object)
	{
		JSONObject json = new JSONObject();
		ArrayList<Method> methodList = new ArrayList<Method>();
		ArrayList<String> fieldName = new ArrayList<String>();
		
		Method methods[] = object.getClass().getDeclaredMethods();//  返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。 
		Field fields[] = object.getClass().getDeclaredFields();//  返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段，包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
		
		for(Method method : methods)
		{
			if(method.getName().startsWith("get"))
			{
				methodList.add(method);
			}
		}
		
		for(Field field : fields)
		{
			fieldName.add(field.getName());
		}
		
		try {
			for (int i = 0; i < methodList.size(); i++) {
				Object obj = methodList.get(i).invoke(object, (Object[])null);//第二个参数必须声明为Object[]
				if(obj instanceof EntityObject)
				{
					obj = SystemOutEntity.entityToJson(obj);
				}
				else if(obj instanceof Date)//字段可能存在Date类型
				{
					obj = ((Date) obj).getTime();
				}
				
				
				
				json.put(fieldName.get(i), obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return json;
	}
}
