package com.fan1tuan.general.ui.struts2.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.ISession.LOG_STATUS;
import com.fan1tuan.general.util.ISession.LOG_TYPE;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.general.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录访问控制，需要登录才可以继续访问用户请求的url，分为以下几种情况：
 * 未登录：用户未登录，这种情况必须要求登录。
 * 假登录：用户处于Cookie登录状态，检测所请求的url是否为敏感用户操作url
 * 真登录：用户处于密码登录状态，可以进行任何用户操作。
 * @author JOE
 *
 */
public class NeedLoginInterceptor extends AbstractInterceptor implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LogManager.getLogger();

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		//first check login status
		ActionContext actionContext = actionInvocation.getInvocationContext();
		Map<String, Object> session = actionContext.getSession();
		
		//check is-ajax request
		String actionNameSpace = actionInvocation.getProxy().getNamespace();
		logger.trace("Requested Action NameSpace is "+actionNameSpace);
		boolean isAjax = actionNameSpace.contains("ajax");
		boolean isUser = actionNameSpace.contains("user");
		boolean isOrder = actionNameSpace.contains("order");
		boolean isUserSecure = actionNameSpace.contains("user")&&actionNameSpace.contains("secure");
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String queryStr = request.getQueryString();
		String requestedFullPath = request.getRequestURL().toString()+(queryStr==null||queryStr.equals("")?"":queryStr);
			
		logger.trace("ajax: "+isAjax);
		logger.trace("user: "+isUser);
		logger.trace("order:"+isOrder);
		logger.trace("userSecure: "+isUserSecure);
		
		//redirect flag
		boolean needRedirect = true;
		
		//check if current uri need (true) login
		
		if(isUser||isOrder){
			Map<String, Object> login_cache = SessionUtil.getLogin(session);
			if(login_cache!=null){
				//check if login
				if(login_cache.get(ISession.LOGIN_STATUS).equals(LOG_STATUS.LOGIN)){
					logger.trace("LOGIN_STATUS :: LOGIN");
					//login already
					if(login_cache.get(ISession.LOGIN_TYPE).equals(LOG_TYPE.TRUE)){
						needRedirect = false;

					}else{
						//it is fake login
						if(!isUserSecure){
							//here need true login
							needRedirect = false;
						}else{
							logger.trace("NEED TRUE LOGIN");
						}
					}
				}
			}
		}else{
			needRedirect = false;
		}
		
		
		
		if(needRedirect){
			session.put("redirect", StringUtil.encodeURL(requestedFullPath));

			logger.trace("REDIRECT PAGE: "+requestedFullPath);
			if(isAjax){
				logger.trace("RETURN AJAX_LOGIN");
				return "global_ajax_login";
			}else{
				logger.trace("RETURN PAGE_LOGIN");
				return "global_page_login";
			}
		}
		
		
		return actionInvocation.invoke();
		
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	


}
