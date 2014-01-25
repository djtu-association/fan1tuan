package com.fan1tuan.general.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceAspect {

	static Logger logger = LogManager.getLogger("com.fan1tuan.general.business.ServiceLogger");
	
	public boolean booleanAfterThrowingMethod(Exception exception){
		exception.printStackTrace();
		return false;
	}
	
	public Object objectAfterThrowingMethod(Exception exception){
		exception.printStackTrace();
		return null;
	}
	
	public boolean booleanAroundMethod(ProceedingJoinPoint point){
		try{
			logger.entry(point.getArgs());
			logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
			return logger.exit((Boolean)point.proceed(point.getArgs()));
		}catch(Throwable exception){
			logger.catching(exception);
			return logger.exit(false);
		}
	}
	
	public Object objectAroundMethod(ProceedingJoinPoint point){
		try{
			logger.entry(point.getArgs());
			logger.info("In "+point.getTarget().getClass().getName()+" "+point.getSignature().getName());
			return logger.exit(point.proceed(point.getArgs()));
		}catch(Throwable exception){
			logger.catching(exception);
			return logger.exit(null);
		}
	}
	
}
