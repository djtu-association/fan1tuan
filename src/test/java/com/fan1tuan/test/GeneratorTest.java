package com.fan1tuan.test;

import java.io.File;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.util.Cleaner;
import com.fan1tuan.general.util.Generator;

public class GeneratorTest {
	@Test
	public void testSaveUser() {
		char sep = File.separatorChar;
		ApplicationContext ctx=new FileSystemXmlApplicationContext("webapp"+sep+"WEB-INF"+sep+"applicationContext.xml");
		Generator generator = (Generator)ctx.getBean("generator");
		Cleaner cleaner = (Cleaner)ctx.getBean("cleaner");

		cleaner.cleanup();
		
		generator.generate();
	}
}
