package com.fan1tuan.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AdminUtil {
	
	//返回当前北京时间-return:Date
	public static Date getBeijingDatetime(){
		Date d = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		try {
			return sdf.parse(sdf.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
