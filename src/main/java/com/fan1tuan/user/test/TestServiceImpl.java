package com.fan1tuan.user.test;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.util.ISession.LOG_TYPE;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.User;

/**
 * 
 * @author JOE
 *
 */
public class TestServiceImpl {

	//模拟一个session对象，实际上的action是通过request.getSession()获得
	Map<String, Object> session = new HashMap<String, Object>();
	
	//获取ApplicaContext对象
	String path=System.getProperty("user.dir");
	ApplicationContext ctx=new FileSystemXmlApplicationContext(path+"//WebContent//WEB-INF//applicationContext.xml");
	//获取userServiceImpl的bean，要用接口转型，否则出错
	UserService userService = (UserService) ctx.getBean("userServiceImpl");
	
	@Test
	public void test() {
		testLogin();
		//testLogoff();
	}
	
	/**
	 * 测试登陆
	 * 提供user对象，设置username和password
	 */
	public void testLogin(){		
		
		User user = new User();
		user.setPassword("1234");
		user.setCellphone("18876768876");
		if(userService.login(user,session,LOG_TYPE.TRUE)){
			System.out.println("Test Current Session:"+session);
			System.out.println("login success");
		}
	}
	
	/**
	 * 注销用户，直接调用logoff方法
	 */
	public void testLogoff(){
		userService.logoff(session);
		System.out.println(session);
	}

}
