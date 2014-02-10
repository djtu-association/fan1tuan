package com.fan1tuan.general.util;


public class Constants {
	
	public static final String TRUE = "true";
	public static final String FALSE = "FALSE";
	
	public static enum OrderStatus{
		PRE_CONFIRM, CONFIRM,  // 0, 1
		SHOP_ACCEPT, SHOP_DELIVERY, USER_ACCEPT, USER_EVALUATE, //2, 3, 4, 5
		USER_DECLINE, // 6
		SHOP_DECLINE; // 7
		public static OrderStatus valueOf(int value){
			switch (value) {
			case 0:
				return PRE_CONFIRM;
			case 1:
				return CONFIRM;
			case 2:
				return SHOP_ACCEPT;
			case 3:
				return SHOP_DELIVERY;
			case 4:
				return USER_ACCEPT;
			case 5:
				return USER_EVALUATE;
			case 6:
				return USER_DECLINE;
			case 7:
				return SHOP_DECLINE;
			default:
				return PRE_CONFIRM;
			}
		}
		
	}
	
	public static enum ChargeType{
		NORMAL/*, ALIPAY*/;
		
		public static ChargeType valueOf(int value){
			switch (value) {
			case 0:
				return NORMAL;
			default:
				return NORMAL;
			}
		}
	}
	
	public static enum ShopState{ 
		ALL, OPEN;
		
		public static ShopState valueOf(int value){
			switch (value) {
			case 0:
				return ALL;
			case 1:
				return OPEN;
			default:
				return ALL;
			}
		}
	}
	public static enum ShopType { 
		RETAIL, REALSTATE, ALL;
		public static ShopType valueOf(int value){
			switch (value) {
			case 0:
				return RETAIL;
			case 1:
				return REALSTATE;
			case 2:
				return ALL;
			default:
				return ALL;
			}
		}
	}
	public static enum OrderType { 
		ONLINE, PHONECALL;
		public static OrderType valueOf(int value){
			switch (value) {
			case 0:
				return ONLINE;
			case 1:
				return PHONECALL;
			default:
				return ONLINE;
			}
		}
	}
	public static enum RankAccord { 
		POPULARITY, SALEVOLUME, COMMENTLEVEL;
		public static RankAccord valueOf(int value){
			switch (value) {
			case 0:
				return POPULARITY;
			case 1:
				return SALEVOLUME;
			case 2:
				return COMMENTLEVEL;
			default:
				return POPULARITY;
			}
		}
	}
	public static enum Sort { 
		ASC, DESC;
		public static Sort valueOf(int value){
			switch (value) {
			case 0:
				return ASC;
			case 1:
				return DESC;
			default:
				return DESC;
			}
		}
	}
	
	public static enum RankTagUse { 
		SHOP, DISH;
		public static RankTagUse valueOf(int value){
			switch (value) {
			case 0:
				return SHOP;
			case 1:
				return DISH;
			default:
				return SHOP;
			}
		}
	}
	
	
	public enum FlagStatus{
		FAIL, NEEDLOGIN, SUCCESS;
		public static FlagStatus valueOf(int flag){
			switch (flag) {
			case 0:
				return FAIL;
			case 1:
				return NEEDLOGIN;
			case 2:
				return SUCCESS;
			default:
				return FAIL;
			}
		}
	}
}
