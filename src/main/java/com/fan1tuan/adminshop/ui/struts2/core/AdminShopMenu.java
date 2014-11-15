package com.fan1tuan.adminshop.ui.struts2.core;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fan1tuan.admin.dto.Page;
import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.adminshop.util.AdminConstant;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.opensymphony.xwork2.Action;

public class AdminShopMenu extends Fan1TuanAction {

	private static final long serialVersionUID = 1L;
	private AdminShopService adminShopService;
	
	//base params
	private String navName = "adminshop";
	//common param
	private String shopId;
	
	//------------show dish list------------------
	private int dishPage;
	private Page dishListPage;
	private List<Dish> dishList;
	public String showDishList(){
		//show dishList
		setDishList(adminShopService.getShopDishsByShopIdInPage(getShopId(), Pageable.inPage((getDishPage()==0?0:getDishPage()-1), AdminConstant.DISHLIST_PAGESIZE)));
		//set page
		Page page = new Page();
		page.setCurrentPage(getDishPage()==0?1:getDishPage());
		page.setPageCount(adminShopService.getDishPageCount(getShopId(), AdminConstant.DISHLIST_PAGESIZE));
		setDishListPage(page);
		//set shopId
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	
	//------------show dish add----------------------
	//shopId:param-in
	//dishTagList:param-out
	public String showDishAdd(){
		setDishTagList(adminShopService.getDishTasteTagsByShopId(getShopId()));
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	
	//------------do dish add-------------------------
	private String name;
	private String description;
	private double price;
	private double originPrice;
	private File image;
	private String imageFileName;
	private String dishTasteTagId;
	//shopId:param-in
	public String doDishAdd() throws IOException{
		Dish dish = new Dish();
		dish.setShopId(getShopId());
		dish.setName(getName());
		dish.setDescription(getDescription());
		dish.setPrice(getPrice());
		dish.setOriginPrice(getOriginPrice());
		dish.setDishTasteTagId(getDescription());
		dish.setDishTasteTagId(getDishTasteTagId());
		dish.setStatus(1);
		dish.setCreateTime(new Date());
		//upload image file
		if(getImage()!=null){
			String destPath = ServletActionContext.getServletContext().getRealPath(AdminConstant.UPLOAD_DISH_PATH);  
	        File dest = new File(destPath, getImageFileName()); //服务器的文件
	        FileUtils.copyFile(image, dest);//完成了文件的拷贝工作 
	        dish.setImage(AdminConstant.IMG_SAVE_PREFFIX+AdminConstant.UPLOAD_DISH_PATH+"/"+imageFileName);
		}
        //end upload file
		adminShopService.addNewDish(dish);
		setShopId(getShopId());//shopId must param-in
		return Action.SUCCESS;
	}
	
	
	//------------show dish edit--------------------
	//shopId:param-in
	private String dishId;//param-in
	private Dish dish;//param-out
	public String showDishEdit(){
		//set dishlist
		setDish(adminShopService.getOneDishByDishId(getDishId()));
		//set dishTasteTag
		setDishTagList(adminShopService.getDishTasteTagsByShopId(getShopId()));
		//set dishId
		setDishId(getDishId());
		return Action.SUCCESS;
	}
	//-----------do dish edit------------------
	public String doDishEdit(){
		//Dish dish = new Dish();
		//dish.setId(getDishId());
		Dish dish = adminShopService.getOneDishByDishId(getDishId());
		dish.setShopId(getShopId());
		dish.setName(getName());
		dish.setDescription(getDescription());
		dish.setPrice(getPrice());
		dish.setOriginPrice(getOriginPrice());
		//dish.setImage(getImage());
		dish.setDishTasteTagId(getDishTasteTagId());
		dish.setStatus(1);
		if(dish.getCreateTime()==null){dish.setCreateTime(new Date());}
		adminShopService.saveDishEdit(dish);
		//set shopId
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	
	//------------do dish delete----------------
	//shopId:param-in
	//dishId:param-in
	public String doDishDelete(){
		adminShopService.deleteDishByDishId(getDishId());
		//set shopid
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	//-----------show dish type add--------------
	//shopId:param-in
	private List<DishTasteTag> DishTagList;
	public String showDishType(){
		setDishTagList(adminShopService.getDishTasteTagsByShopId(getShopId()));
		//set shopId
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	//------------------do dish type add------------
	//shopId:param-in
	private String tagName;//param-in
	private String tagDescription;//param-in
	public String doDishTypeAdd(){
		DishTasteTag dishTasteTag = new DishTasteTag();
		dishTasteTag.setDescription(getTagDescription());
		dishTasteTag.setName(getTagName());
		dishTasteTag.setShopId(getShopId());
		adminShopService.addNewDishTasteTag(dishTasteTag);
		//set shopId
		setShopId(getShopId());
		return Action.SUCCESS;
	}
	
	//菜品分类的编辑页面由页面JS完成
	public String doDishTypeEdit(){
		return Action.SUCCESS;
	}
	
	
	//------------do dish type delete---------------------
	private String tagId;//param-in
	public String doDishTypeDelete(){
		adminShopService.deleteDishTasteTagByTagId(getTagId());
		//set shopid
		setShopId(getShopId());
		return Action.SUCCESS;
	}

	
	
	//--------------get and set--------------------------
	public AdminShopService getAdminShopService() {
		return adminShopService;
	}

	public void setAdminShopService(AdminShopService adminShopService) {
		this.adminShopService = adminShopService;
	}

	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public int getDishPage() {
		return dishPage;
	}

	public void setDishPage(int dishPage) {
		this.dishPage = dishPage;
	}

	public Page getDishListPage() {
		return dishListPage;
	}

	public void setDishListPage(Page dishListPage) {
		this.dishListPage = dishListPage;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public List<DishTasteTag> getDishTagList() {
		return DishTagList;
	}

	public void setDishTagList(List<DishTasteTag> dishTagList) {
		DishTagList = dishTagList;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getDishTasteTagId() {
		return dishTasteTagId;
	}

	public void setDishTasteTagId(String dishTasteTagId) {
		this.dishTasteTagId = dishTasteTagId;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	

}
