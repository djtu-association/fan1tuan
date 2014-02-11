package com.fan1tuan.general.pojos.dto;

import java.util.Date;

import com.fan1tuan.general.pojos.EntityObject;
import com.fan1tuan.general.util.DateUtil;

public class DateWrapper extends EntityObject{
	private Date now = new Date();
	private int flag = 0;;
	
	public Date getNearestQuarter(){
		return DateUtil.getNearestQuarter(now);
	}
	
	public Date next(){
		flag++;
		return DateUtil.addMinutesToDate(getNearestQuarter(), flag*15);
	}
	
	public Date nextSleep(){
		return DateUtil.addMinutesToDate(getNearestQuarter(), flag*15);
	}
	
	public void clearFlag(){
		flag = 0;
	}
	
	public Date getNow(){
		return now;
	}
}
