package com.fan1tuan.general.util;


public class Constants {
	
	public static final String TRUE = "true";
	public static final String FALSE = "FALSE";
	
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
