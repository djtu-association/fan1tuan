package com.fan1tuan.general.util;

import javax.servlet.http.Cookie;

/**
 * @author Lihe
 *
 */
public class CookieUtil {
	public static boolean isCookieNull(Cookie[] cookies){
		return cookies == null;
	}
	
	public static Cookie getUserCacheCookie(Cookie[] cookies){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(ICookie.USER_CACHE) && cookie.getValue() != null && !cookie.getValue().equals("")){
				return cookie;
			}
		}
		return null;
	}
	
	public static Cookie getAreaConfigCookie(Cookie[] cookies){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(ICookie.AREA_CONFIG) && cookie.getValue() != null && !cookie.getValue().equals("")){
				return cookie;
			}
		}
		return null;
	}
}
