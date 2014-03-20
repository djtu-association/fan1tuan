package com.fan1tuan.adminshop.ui.struts2.core;

import java.util.List;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.adminshop.util.AdminConstant;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.shop.pojos.Shop;
import com.opensymphony.xwork2.Action;

public class AdminShopMain extends Fan1TuanAction{

	private static final long serialVersionUID = 1L;
	
	//base params
	private String navName = "adminshop";
	//common params
	private AdminShopService adminShopService;
	private List<Shop> shopList;//出参:showShopList doShopAdd
	private String subTitle="";//出参：showShopAdd
	private String shopId;//出参：showShopEdit,doShopDelete
	
	
	//--------------店铺列表-----------------
	public String showShopList(){
		setShopList(adminShopService.getShopsInPage(Pageable.inPage(0, AdminConstant.SHOPLIST_PAGESIZE)));
		return Action.SUCCESS;
	}
	
	//--------------显示添加店铺-------------
	public String showShopAdd(){
		setSubTitle("添加新店铺");
		return Action.SUCCESS;
	}
	
	
	//----------------确认店铺添加-----------
	//入参:doShopAdd,doShopEdit
	private String name;
	private String description;
	private double deliveryCharge;
	private double avgPersonCost;
	private double avgDeliveryTime;
	private String cellphone;
	private int shopType;
	private String opentime;
	private String closetime;
	private String address;
	private double latitude;
	private double longtitude;
	private String avatar;
	//出参-shopList
	public String doShopAdd(){
		Shop shop = new Shop();
		shop.setName(getName());
		shop.setDescription(getDescription());
		shop.setAvgPersonCost(getAvgPersonCost());
		shop.setAvgDeliveryTime(getAvgDeliveryTime());
		shop.setCellphone(getCellphone());
		shop.setType(getShopType());
		shop.setDeliveryCharge(getDeliveryCharge());
		//shop.setOpenTime(getOpentime());
		//shop.setCloseTime(getClosetime());
		shop.setAddress(getAddress());
		double[] location = {getLongtitude(),getLatitude()};
		shop.setLocation(location);
		//
		adminShopService.addNewShop(shop);
		return Action.SUCCESS;
	}
	
	//-----------------显示编辑店铺------------
	private Shop shop;
	public String showShopEdit(){
		
		Shop shop = adminShopService.getOneShopByShopId(getShopId());
		setShop(shop);
		setSubTitle("编辑店铺:"+shop.getName());
		return Action.SUCCESS;
	}
	//------------------确认编辑店铺--------------
	public String doShopEdit(){
		Shop shop = new Shop();
		shop.setId(getShopId());
		shop.setName(getName());
		shop.setDescription(getDescription());
		shop.setAvgPersonCost(getAvgPersonCost());
		shop.setAvgDeliveryTime(getAvgDeliveryTime());
		shop.setCellphone(getCellphone());
		shop.setType(getShopType());
		shop.setDeliveryCharge(getDeliveryCharge());
		//shop.setOpenTime(getOpentime());
		//shop.setCloseTime(getClosetime());
		shop.setAddress(getAddress());
		double[] location = {getLongtitude(),getLatitude()};
		shop.setLocation(location);
		//
		System.out.println("shoptype:"+getShopType());
		adminShopService.saveShopEdit(shop);
		return Action.SUCCESS;
	}
	
	//-------------------删除一个店铺------------
	public String doShopDelete(){
		adminShopService.deleteShopByShopId(getShopId());
		return Action.SUCCESS;
	}
	
	public String showShopOrders(){
		return Action.SUCCESS;
	}
	
	public String doShopOrderDelete(){
		return Action.SUCCESS;
	}

	
	
	
	
	
	//-------------getters and setters------------------

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	
	public AdminShopService getAdminShopService() {
		return adminShopService;
	}
	public void setAdminShopService(AdminShopService adminShopService) {
		this.adminShopService = adminShopService;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgPersonCost() {
		return avgPersonCost;
	}

	public void setAvgPersonCost(double avgPersonCost) {
		this.avgPersonCost = avgPersonCost;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public int getShopType() {
		return shopType;
	}

	public void setType(int shopType) {
		this.shopType = shopType;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public double getAvgDeliveryTime() {
		return avgDeliveryTime;
	}

	public void setAvgDeliveryTime(double avgDeliveryTime) {
		this.avgDeliveryTime = avgDeliveryTime;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	
}
