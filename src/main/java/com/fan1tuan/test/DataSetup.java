package com.fan1tuan.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fan1tuan.general.util.Cleaner;
import com.fan1tuan.general.util.Generator;

public class DataSetup {
	public static void main(String[] args){
		String path=System.getProperty("user.dir");
		char sep = File.separatorChar;
		System.out.println(path+sep+"src"+sep+"main"+sep+"webapp"+sep+"WEB-INF"+sep+"applicationContext.xml");
		ApplicationContext ctx=new FileSystemXmlApplicationContext(path+sep+"src"+sep+"main"+sep+"webapp"+sep+"WEB-INF"+sep+"applicationContext.xml");
		Generator generator = (Generator)ctx.getBean("generator");
		Cleaner cleaner = (Cleaner)ctx.getBean("cleaner");

		cleaner.cleanup();
		
		generator.generate();
	}
}
