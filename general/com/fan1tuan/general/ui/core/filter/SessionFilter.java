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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.ISession.LOG_STATUS;
/**
 * 此类功能为自动启动Session，防止freemarker的null异常
 * @author Lihe
 *
 */
public class SessionFilter implements Filter {
	
	@SuppressWarnings("unused")
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}
	
	@SuppressWarnings({"unchecked" })
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest)req;
		HttpSession httpSession = servletRequest.getSession(true);
		
		Map<String,Object> login_cache = (Map<String,Object>)httpSession.getAttribute(ISession.LOGIN);
		if(login_cache==null){
			login_cache = new HashMap<String,Object>();
			login_cache.put(ISession.LOGIN_STATUS, LOG_STATUS.LOGOUT);
			httpSession.setAttribute(ISession.LOGIN, login_cache);
		}
		
//		Map<String, Object> area_cache = (Map<String, Object>) httpSession.getAttribute(ISession.AREA);
//		if(area_cache==null){
//			area_cache = new HashMap<String,Object>();
//			area_cache.put(ISession.AREAID, null);
//			area_cache.put(ISession.AREANAME, null);
//			httpSession.setAttribute(ISession.AREA, area_cache);
//		}
		
		chain.doFilter(req, res);
	}
	

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
