package com.fan1tuan.test;
import java.io.File;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.impl.ShopDao;

public class DaoImplTest {

	@Test
	public void test() {
		char sep = File.separatorChar;
		@SuppressWarnings("resource")
		ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent"+sep+"WEB-INF"+sep+"applicationContext.xml");
		ShopDao shopDao = (ShopDao)ctx.getBean("shopDao");
		long count = shopDao.getPageCount(CriteriaWrapper.instance(), 10);
		System.out.println("test count: "+count);
	}

}
