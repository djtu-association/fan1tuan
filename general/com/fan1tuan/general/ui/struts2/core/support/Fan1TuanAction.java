package com.fan1tuan.general.ui.struts2.core.support;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.general.util.Constants.FlagStatus;
import com.opensymphony.xwork2.ActionSupport;

public class Fan1TuanAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9222299393208478548L;
	//维持session
	protected Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	
	//维持flag，json返回必须有一个flag标识符，代表请求状态
	protected int flag;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	protected int makeFlag(boolean result){
		if(result){
			return FlagStatus.SUCCESS.ordinal();
		}else{
			return FlagStatus.FAIL.ordinal();
		}
	}
	
	protected int makeFlag(Object result){
		if(result!=null){
			return FlagStatus.SUCCESS.ordinal();
		}else{
			return FlagStatus.FAIL.ordinal();
		}
	}
	
}
