package com.fan1tuan.general.ui.core.filter;

import java.io.IOException;
import java.util.TimeZone;

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

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
 
public class RequestFilter implements Filter {
    @SuppressWarnings("unused")
	private FilterConfig filterConfig;
    private static String TZ_NAME = "timezoneOffset";
 
    static Logger logger = LogManager.getLogger("com.fan1tuan.general.request");
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
 
    /**
     * Sample filter that populates the MDC on every request.
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
    	MapMessage mapMessage = new MapMessage();
    	
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        mapMessage.put("ipAddress", request.getRemoteAddr());
        HttpSession session = request.getSession(false);
        TimeZone timeZone = null;
        if (session != null) {
            // Something should set this after authentication completes
            String loginId = (String)session.getAttribute("LoginId");
            if (loginId != null) {
                mapMessage.put("loginId", loginId);
            }
            // This assumes there is some javascript on the user's page to create the cookie.
            if (session.getAttribute(TZ_NAME) == null) {
                if (request.getCookies() != null) {
                    for (Cookie cookie : request.getCookies()) {
                        if (TZ_NAME.equals(cookie.getName())) {
                            int tzOffsetMinutes = Integer.parseInt(cookie.getValue());
                            timeZone = TimeZone.getTimeZone("GMT");
                            timeZone.setRawOffset((int)(tzOffsetMinutes * DateUtils.MILLIS_PER_MINUTE));
                            request.getSession().setAttribute(TZ_NAME, tzOffsetMinutes);
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                    }
                }
            }
        }
        mapMessage.put("hostname", servletRequest.getServerName());
        mapMessage.put("locale", servletRequest.getLocale().getDisplayName());
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        mapMessage.put("timezone", timeZone.getDisplayName());
        mapMessage.put("requestURL", request.getMethod()+":"+request.getRequestURI());
        logger.info(mapMessage);
        filterChain.doFilter(servletRequest, servletResponse);
    }
 
    public void destroy() {
    }
}