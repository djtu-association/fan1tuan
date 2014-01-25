package com.fan1tuan.life.pojos;

import java.sql.Date;

import com.fan1tuan.general.pojos.EntityObject;

public class ExpressClient extends EntityObject {
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String area;
	
	private String address;
	
	private String cellphone;
	
	private Date serverTimeOn;
	
	private Date serverTimeOff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getServerTimeOn() {
		return serverTimeOn;
	}

	public void setServerTimeOn(Date serverTimeOn) {
		this.serverTimeOn = serverTimeOn;
	}

	public Date getServerTimeOff() {
		return serverTimeOff;
	}

	public void setServerTimeOff(Date serverTimeOff) {
		this.serverTimeOff = serverTimeOff;
	}
	
	public ExpressClient(String id,String username,String password,String area,String address,String cellphone,
			Date serverTimeOn,Date serverTimeOff){
		this.id = id;
		this.username = username;
		this.password = password;
		this.area = area;
		this.address = address;
		this.cellphone = cellphone;
		this.serverTimeOn = serverTimeOn;
		this.serverTimeOff = serverTimeOff;
	}

}
