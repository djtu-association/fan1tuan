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
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fan1tuan.general.util.CookieUtil;
import com.fan1tuan.general.util.ICookie;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.ISession.LOG_STATUS;
import com.fan1tuan.general.util.SessionUtil;

/**
 * 保存用户登录信息的Cookie不要保存用户名与密码，仅仅保存用户名与时间戳，更改一下以下几个地方：
 * 记录用户登录状态的session的login顶级key添加一个子key，名称为loginType，假登陆为0，真登陆为1。
 * 注意了：currentUser中的字段除了cellphone无需填充，做好以防是null的准备，login中的字段请全部填充。
 * 仅仅在涉及下订单等敏感操作的时候要求loginType必须为1，其余操作为0时也可成功。
 * 登陆时对Cookie的添加操作注意了，不要保存用户密码，仅保留时间戳和用户名
 * @author JOE
 *
 */
public class AutoLoginFilter implements Filter {

	Logger logger;
	FilterConfig filterConfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		//first:check session
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpSession session = request.getSession();		
		Map<String, Object> login_cache = SessionUtil.getLogin(session);
		
		if( SessionUtil.isLoginNull(session) || 
				(login_cache != null && !login_cache.get(ISession.LOGIN_STATUS).equals(LOG_STATUS.LOGIN)) ){
			//second:cookie login
			Cookie[] cookies = request.getCookies();
			logger.trace("SESSION NOT LOGIN, TRY TO FIND COOKIE!");
			if(!CookieUtil.isCookieNull(cookies)){
				Cookie cookie = CookieUtil.getUserCacheCookie(cookies);
				if(cookie!=null){
					logger.trace("COOKIE USER_CACHE VALUE: "+ cookie.getValue());
					String value = cookie.getValue();
					//analyze cookie value,get user cookie "timestamp"
					String[] parts = value.split("::");
					String userId = parts[0];
					String username = parts[1]; //cellphone
					long timestamp = Long.valueOf(parts[2]);
					
					long cookieAge = (System.currentTimeMillis() - timestamp)/1000;
					logger.trace("COOKIE LIFE AGE: "+cookieAge);
					if(cookieAge <= ICookie.COOKIE_AGE){
						//auto login,no need to get DB,set the session.LOG_STATUS to LOG_STATUS.LOGIN
						Map<String, Object> loginStatus = new HashMap<String, Object>();
						loginStatus.put(ISession.LOGIN_STATUS, ISession.LOG_STATUS.LOGIN);
						loginStatus.put(ISession.LOGIN_TYPE, ISession.LOG_TYPE.FALSE);
						loginStatus.put(ISession.LOGIN_TIME, System.currentTimeMillis()+"");
						Map<String, Object> userCache = new HashMap<String, Object>();
						userCache.put(ISession.USER_NAME, username);
						userCache.put(ISession.USER_CELLPHONE, username);
						userCache.put(ISession.USER_ID, userId);
						
						session.setAttribute(ISession.LOGIN, loginStatus);
						session.setAttribute(ISession.USER, userCache);
						logger.trace("AUTO LOGIN SUCCESS!!!");
					}else{
						//cookie out of time,unavailable cookie,clear the user cookie,cookies[i]:ICookie.USER
						cookie.setValue(null);
						logger.trace("SET COOKIE USER_CACHE TO NULL: "+cookie.getValue());
					}
				}else{
					logger.trace("COOKIE_USER_CACHE IS NULL:GIVE UP");
				}

			}else{
				logger.trace("COOKIE IS NULL::GIVE UP AUTO LOGIN");
			}
		}else{
			logger.trace("SESSION LOG_STATUS: "+ (login_cache != null && !login_cache.get(ISession.LOGIN_STATUS).equals(LOG_STATUS.LOGIN)) );
			logger.trace("SESSION LOGIN ALREAY");
		}
		
		
		
		logger.trace("AUTO LOGIN END");
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.logger = LogManager.getLogger();

	}

}
