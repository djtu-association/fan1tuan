package com.fan1tuan.general.ui.struts2.core;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.general.config.Fan1TuanConfig;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants.FlagStatus;
import com.fan1tuan.general.util.StringUtil;
import com.opensymphony.xwork2.Action;

public class InnerAction extends Fan1TuanAction implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3894461312177813563L;

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	/**
	 * -------------/needLogin.f1t & /ajax/ajaxNeedLogin.f1t--------------
	 */
	private String redirect;

	public String needLogin() {
		redirect = (String) ServletActionContext.getRequest().getSession().getAttribute("redirect");

		if (redirect == null || redirect.equals("")) {
			redirect = StringUtil.encodeURL(Fan1TuanConfig
					.getProperty("fan1tuan.home"));
		}

		flag = FlagStatus.NEEDLOGIN.ordinal();
		return Action.SUCCESS;
	}
}
