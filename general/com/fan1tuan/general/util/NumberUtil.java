package com.fan1tuan.general.util;

public class NumberUtil {
	public static double reserveBit(double number, int i){
		int x = 1;
		for(; i >0; i--){
			x*=10;
		}
		number *= x;
		int temp = (int)number;
		return temp / (double)x;
	}
}
