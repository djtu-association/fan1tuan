package com.fan1tuan.test;

import com.opensymphony.xwork2.Action;

public class TestAction {
	public String execute(){
		//this.getTestBean().insertDocument("Gao", 18, new String[]{"brightness", "happy"});
		this.setMsg(this.getTestBean().findOne("Gao").toString());
		
		return Action.SUCCESS;
	}
	private String msg;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private TestBean testBean;
	public void setTestBean(TestBean testBean){
		this.testBean = testBean;
	}
	public TestBean getTestBean(){
		return testBean;
	}
}
