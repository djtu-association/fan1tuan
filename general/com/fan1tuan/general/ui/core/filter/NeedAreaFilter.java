package com.fan1tuan.general.ui.core.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fan1tuan.general.ui.struts2.interceptor.FilterConstant;
import com.fan1tuan.general.util.CookieUtil;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.general.util.StringUtil;

public class NeedAreaFilter implements Filter {

	@SuppressWarnings("unused")
	private FilterConfig filterConfig;
	private Logger logger;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		String queryStr = request.getQueryString();
		String requestFullPath = request.getRequestURL().toString()+(queryStr==null||queryStr.equals("")?"":queryStr);
		
		String URI = request.getRequestURI();
		logger.trace("REQUEST URI :"+URI);
		boolean isRedirect = false;

		if( !URI.equals(FilterConstant.URL_TO_SETAREA) && !URI.equals(FilterConstant.URL_TO_GETAREA))
		{
			HttpServletResponse response = (HttpServletResponse)res;
			HttpSession session = request.getSession();
			Cookie[] cookies = request.getCookies();
			
			boolean cookieFlag = false;
			
			Map<String, Object> areaCache = SessionUtil.getArea(session);
			//first check session
			if(areaCache != null &&  areaCache.get(ISession.AREAID) != null && !areaCache.get(ISession.AREAID).equals("")){
				logger.trace("[IF-ELSE]:SESSION GOT");
				//means session-area exist
				if(!CookieUtil.isCookieNull(cookies)){
					Cookie cookie = CookieUtil.getAreaConfigCookie(cookies);
				
					if(cookie!=null){
						cookieFlag = true;
						logger.trace("SESSION GOT , COOKIE GOT, DO NOTHING AND LET GO");
					}
					
				}
				
				if(!cookieFlag){
					//means the cookie-area is not exist,then set the cookie-area,actually this issue is less rate
					//(session got,cookie loss)
					String areaConfig = (String)areaCache.get(ISession.AREAID)+"::"+(String)areaCache.get(ISession.AREANAME);
					logger.trace("SESSION GOT, COOKIE LOSS, THEN SET COOKIE-AREACONFIG FROM SESSION-AREA");
					
					Cookie cookie = new Cookie(ICookie.AREA_CONFIG, areaConfig);
					response.addCookie(cookie);
					cookieFlag = false;
				}
			}else{
				//means session has no 'AREAID',and check the cookies
				logger.trace("[IF-ELSE]:SESSION LOSS");
				
				if(!CookieUtil.isCookieNull(cookies)){
					Cookie cookie = CookieUtil.getAreaConfigCookie(cookies);
					if(cookie!=null){
						//(session loss,cookie got)
						cookieFlag = true;
					}
				}
				
				if(!cookieFlag){
					//(session loss,cookie loss)
					//sendDirect the url 'setArea.f1t' to reset the cookie
					logger.trace("SESSION LOSS , COOKIE LOSS , REIDRECT TO 'SETAREA.F1T'");
					//
					isRedirect = true;
					response.sendRedirect(FilterConstant.URL_TO_SETAREA+"?redirect="+StringUtil.encodeURL(requestFullPath));
				}else{
					//(session loss,cookie got)
					//set the session-area from cookie-area
					Cookie cookie = CookieUtil.getAreaConfigCookie(cookies);
					logger.trace("SESSION LOSS , COOKIE GOT , SET SESSION-AREA FROM COOKIE-AREA");
					String partial[] = cookie.getValue().split("::");
					if(partial != null && partial.length ==2){
						Map<String, Object> areaMap = new HashMap<String, Object>();
						areaMap.put(ISession.AREAID, partial[0]);
						partial[1] = new String(partial[1].getBytes("ISO8859-1"),"UTF-8");
						areaMap.put(ISession.AREANAME, partial[1]);
						session.setAttribute(ISession.AREA, areaMap);
					}else{
						logger.trace("SESSION LOSS , COOKIE GOT , FAIL TO SET SESSION-AREA");
					}
				}
				
				
				
			}
		}
		
		if(!isRedirect)
			chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		logger = LogManager.getLogger();

	}

}
