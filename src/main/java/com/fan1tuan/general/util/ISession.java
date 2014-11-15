package com.fan1tuan.general.util;

public class ISession {
	
	public static final String USER = "currentUser";
	public static final String USER_ID = "userId";
	public static final String USER_NAME = "userName";
	public static final String USER_CELLPHONE = "cellphone";
	public static final String USER_EMAIL = "email";
	public static final String USER_REALNAME = "realName";
	public static final String USER_QQ = "qq";
	public static final String USER_IMAGE = "image";
	public static final String USER_LEVEL = "level";
	public static final String USER_CREDIT = "credit";
	
	public static final String LOGIN = "login";
	public static final String LOGIN_TIME = "loginTime";
	public static final String LOGIN_STATUS = "loginStatus";
	public static final String LOGIN_TYPE = "loginType";

	public static enum LOG_STATUS{
		LOGIN(1),LOGOUT(2);
		private int status;
		private LOG_STATUS(int value){
			this.status = value;
		}
		@Override
		public String toString(){
			return String.valueOf(this.status);
		}
	}
	public static enum LOG_TYPE{
		TRUE(1),FALSE(0);
		private int type;
		private LOG_TYPE(int value){
			this.type = value;
		}
		@Override
		public String toString(){
			return String.valueOf(this.type);
		}
	}
	
	public static final String AREA = "area";
	public static final String AREAID = "areaId";
	public static final String AREANAME = "areaName";	
}
