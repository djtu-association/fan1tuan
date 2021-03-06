package com.fan1tuan.shop.ui.struts2.core;

import java.util.List;
import java.util.Map;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.shop.business.DishUserService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.user.business.UserService;

public class ShopAjaxAction extends Fan1TuanAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7989008887486497192L;
	
	private DishUserService dishUserService;
	private UserService	 userService;
	
	
	public DishUserService getDishUserService() {
		return dishUserService;
	}

	public void setDishUserService(DishUserService dishUserService) {
		this.dishUserService = dishUserService;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Map<String, Integer> getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(Map<String, Integer> commentLevel) {
		this.commentLevel = commentLevel;
	}

	public List<DishComment> getDishComments() {
		return dishComments;
	}

	public void setDishComments(List<DishComment> dishComments) {
		this.dishComments = dishComments;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean isLikeDish() {
		return likeDish;
	}

	public void setLikeDish(boolean likeDish) {
		this.likeDish = likeDish;
	}

	/**
	 *  ---------------/shop/ajax/ajaxGetDishInfo.f1t -------------
	 */
	 //pageNumber, pageSize
	 //dishId
	//入参
	private String dishId;
	private int pageSize;
	private int pageNumber;
	//出参
	private Dish dish;
	private Map<String, Integer> commentLevel;  //comment分布
	private List<DishComment> dishComments;  
	private boolean likeDish = false;
	public String getDishInfo(){
		Map<String, Object> user_cache = SessionUtil.getUser(session);
		
		if(user_cache!=null){
			String userId = (String)user_cache.get(ISession.USER_ID);
			if(userId!=null && !userId.equals("")){
				likeDish = userService.isLikeDish(userId, dishId);
			}
		}
		
		dish = dishUserService.getDish(dishId);
		commentLevel = dishUserService.getSimpleDishComments(dishId);
		if(pageSize==0){
			pageSize = 10;
			pageNumber = 0;
		}
		Pageable pageable = Pageable.inPage(pageNumber, pageSize);
		dishComments =dishUserService.getDishCommentsInPage(dishId, pageable);
		return  SUCCESS;
	}
	
}
