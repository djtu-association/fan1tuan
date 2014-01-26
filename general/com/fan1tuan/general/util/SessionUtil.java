package com.fan1tuan.general.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * @author Lihe
 *
 */
@SuppressWarnings("unchecked")
public class SessionUtil {
	public static boolean isSessionNull(HttpSession session){
		return session == null;
	}
	public static boolean isSessionNull(Map<String, Object> session){
		return session == null;
	}
	
	public static boolean isUserNull(HttpSession session){
		return session.getAttribute(ISession.USER) == null;
	}
	public static boolean isUserNull(Map<String, Object> session){
		return session.get(ISession.USER) == null;
	}
	public static Map<String, Object> getUser(HttpSession session){
		return (Map<String, Object>)session.getAttribute(ISession.USER);
	}
	public static Map<String, Object> getUser(Map<String, Object> session){
		return (Map<String, Object>)session.get(ISession.USER);
	}
	
	public static boolean isLoginNull(HttpSession session){
		return session.getAttribute(ISession.LOGIN) == null;
	}
	public static boolean isLoginNull(Map<String, Object> session){
		return session.get(ISession.LOGIN) == null;
	}
	public static Map<String, Object> getLogin(HttpSession session){
		return (Map<String, Object>)session.getAttribute(ISession.LOGIN);
	}
	public static Map<String, Object> getLogin(Map<String, Object> session){
		return (Map<String, Object>)session.get(ISession.LOGIN);
	}
	
	public static boolean isAreaNull(HttpSession session){
		return session.getAttribute(ISession.AREA) == null;
	}
	public static boolean isAreaNull(Map<String, Object> session){
		return session.get(ISession.AREA) == null;
	}
	public static Map<String, Object> getArea(HttpSession session){
		return (Map<String, Object>)session.getAttribute(ISession.AREA);
	}
	public static Map<String, Object> getArea(Map<String, Object> session){
		return (Map<String, Object>)session.get(ISession.AREA);
	}
	
}
