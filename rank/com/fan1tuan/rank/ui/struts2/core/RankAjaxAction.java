package com.fan1tuan.rank.ui.struts2.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.general.util.Constants.RankAccord;
import com.fan1tuan.general.util.Constants.ShopState;
import com.fan1tuan.general.util.Constants.ShopType;
import com.fan1tuan.general.util.Constants.Sort;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.rank.business.DishRankService;
import com.fan1tuan.rank.business.ShopRankService;
import com.fan1tuan.shop.business.TagService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishGeo;
import com.fan1tuan.shop.pojos.ShopGeo;
import com.fan1tuan.user.business.UserService;
import com.opensymphony.xwork2.Action;

public class RankAjaxAction extends Fan1TuanAction {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1975758627632278290L;
	
	
	//service dao
	private DishRankService dishRankService;
	private ShopRankService shopRankService;
	private TagService tagService;
	private UserService userService;
	
	
	private List<String> shopTasteTagIds;
	private int shopType;
	private int accord;
    private int order;
    private int pNumber;
	private int pSize;
	private int open;
	private String dishRankTName;
	private List<String> shopAffairTagIds;
	
	
	//index init
	private Map<String, Long> pageMap;
	//set area[]
	private String areaId;
	//dto
	private List<ShopGeo> shopGeo;
	private List<DishGeo> dishGeo;
	
	private List<Dish> rankDishList;
	private List<Dish> rankDishListByTag;
	/*
	 * 返回tag排行 例如菜品之星
	 */
	@SuppressWarnings("unchecked")
	public String getDishRankByTag()
	{   
		 areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		 String tagId = tagService.getRankTagByName(dishRankTName).getId();
		 setRankDishListByTag(dishRankService.rankDishWithRankTag(tagId, areaId));
	      
      return Action.SUCCESS;
		
	}
	
	//菜品排行，筛选
	@SuppressWarnings("unchecked")
	public String getDishRank()
	{
		//缺少dishTasteTag
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		Pageable page = Pageable.inPage(pNumber, pSize);
		
		rankDishList = dishRankService.rankDish(ShopType.valueOf(shopType), RankAccord.valueOf(accord), Sort.valueOf(order), ShopState.valueOf(open), areaId, page);
		List<DishGeo> dishGeos = new ArrayList<DishGeo>();
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=rankDishList.size(); i<size; i++){
					dishGeos.add(i, new DishGeo(rankDishList.get(i),Constants.FALSE));
					if(userService.isLikeDish(userId, dishGeos.get(i).getContent().getId())){
						dishGeos.get(i).setLike(Constants.TRUE);
					}else{
						dishGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=rankDishList.size(); i<size; i++){
					dishGeos.add(i, new DishGeo(rankDishList.get(i),Constants.FALSE));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setDishGeo(dishGeos);
		
		long length = Pageable.getPageLength(pNumber, pSize);
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
	    
		return Action.SUCCESS;
	}
	//菜品排行，默认
	@SuppressWarnings("unchecked")
	public String getDishRankDefault()
	{
		pNumber = 0;
		pSize = 12;
		Pageable page = Pageable.inPage(pNumber, pSize);
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);	
		rankDishList = dishRankService.rankDish(areaId, page);
		List<DishGeo> dishGeos = new ArrayList<DishGeo>();
		
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=rankDishList.size(); i<size; i++){
					dishGeos.add(i, new DishGeo(rankDishList.get(i),Constants.FALSE));
					if(userService.isLikeDish(userId, dishGeos.get(i).getContent().getId())){
						dishGeos.get(i).setLike(Constants.TRUE);
					}else{
						dishGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=rankDishList.size(); i<size; i++){
					dishGeos.add(i, new DishGeo(rankDishList.get(i),Constants.FALSE));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDishGeo(dishGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
		return Action.SUCCESS;
	}

	//电话店铺，筛选
	@SuppressWarnings("unchecked")
	public String getPhoneCallShopRank()
	{
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		Pageable page = Pageable.inPage(pNumber, pSize);
		
		List<ShopGeo> shopGeos = shopRankService.rankPhoneCallShopGeos(ShopType.valueOf("shopType"), shopTasteTagIds, RankAccord.valueOf(accord), Sort.valueOf(order), areaId, page);
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=shopGeos.size(); i<size; i++){
					if(userService.isLikeShop(userId, shopGeos.get(i).getContent().getId())){
						shopGeos.get(i).setLike(Constants.TRUE);
					}else{
						shopGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=shopGeos.size(); i<size; i++){
					shopGeos.get(i).setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
		return Action.SUCCESS;
	}
	
	//电话店铺，默认
	@SuppressWarnings("unchecked")
	public String getPhoneCallShopRankDefault()
	{
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		pNumber = 0;
		pSize = 12;	
		
		Pageable page = Pageable.inPage(pNumber, pSize);
		List<ShopGeo> shopGeos = shopRankService.rankPhoneCallShopGeos(areaId, page);
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
		    HashMap<String, String> user = (HashMap<String, String>) session.get(ISession.USER);
		    String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=shopGeos.size(); i<size; i++){
					if(userService.isLikeShop(userId, shopGeos.get(i).getContent().getId())){
						shopGeos.get(i).setLike(Constants.TRUE);
					}else{
						shopGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=shopGeos.size(); i<size; i++){
					shopGeos.get(i).setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
		return Action.SUCCESS;
	}
	
	//店铺排行，筛选
	@SuppressWarnings("unchecked")
	public String getOnlineShopRank()
	{
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		Pageable page = Pageable.inPage(pNumber, pSize);
		List<ShopGeo> shopGeos = shopRankService.rankOnlineShopGeos(ShopType.valueOf(shopType), shopTasteTagIds, shopAffairTagIds, RankAccord.valueOf(accord), Sort.valueOf(order), ShopState.valueOf(open), areaId, page);
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=shopGeos.size(); i<size; i++){
					if(userService.isLikeShop(userId, shopGeos.get(i).getContent().getId())){
						shopGeos.get(i).setLike(Constants.TRUE);
					}else{
						shopGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=shopGeos.size(); i<size; i++){
					shopGeos.get(i).setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
		return Action.SUCCESS;
	}
	
	//店铺排行，默认
	@SuppressWarnings("unchecked")
	public String getOnlineShopRankDefault()
	{   
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		pNumber = 0;
		pSize = 12;
		
		Pageable page = Pageable.inPage(pNumber, pSize);
		List<ShopGeo> shopGeos = shopRankService.rankOnlineShopGeos(areaId, page);
		
		try {
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for(int i=0,size=shopGeos.size(); i<size; i++){
					if(userService.isLikeShop(userId, shopGeos.get(i).getContent().getId())){
						shopGeos.get(i).setLike(Constants.TRUE);
					}else{
						shopGeos.get(i).setLike(Constants.FALSE);
					}
				}
			}else{
				for(int i=0,size=shopGeos.size(); i<size; i++){
					shopGeos.get(i).setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", Long.valueOf(pNumber));
		return Action.SUCCESS;
	}
	
	//getter && setter
	
	public List<Dish> getRankDishListByTag() {
		return rankDishListByTag;
	}
	public void setRankDishListByTag(List<Dish> rankDishListByTag) {
		this.rankDishListByTag = rankDishListByTag;
	}
	public List<DishGeo> getDishGeo() {
		return dishGeo;
	}
	public void setDishGeo(List<DishGeo> dishGeo) {
		this.dishGeo = dishGeo;
	}
	public List<ShopGeo> getShopGeo() {
		return shopGeo;
	}
	public void setShopGeo(List<ShopGeo> shopGeo) {
		this.shopGeo = shopGeo;
	}
	public DishRankService getDishRankService() {
		return dishRankService;
	}
	public void setDishRankService(DishRankService dishRankService) {
		this.dishRankService = dishRankService;
	}
	public ShopRankService getShopRankService() {
		return shopRankService;
	}
	public void setShopRankService(ShopRankService shopRankService) {
		this.shopRankService = shopRankService;
	}
	public TagService getTagService() {
		return tagService;
	}
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<String> getShopTasteTagIds() {
		return shopTasteTagIds;
	}
	public void setShopTasteTagIds(List<String> shopTasteTagIds) {
		this.shopTasteTagIds = shopTasteTagIds;
	}
	public int getShopType() {
		return shopType;
	}
	public void setShopType(int shopType) {
		this.shopType = shopType;
	}
	public int getAccord() {
		return accord;
	}
	public void setAccord(int accord) {
		this.accord = accord;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getpNumber() {
		return pNumber;
	}
	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	public int getpSize() {
		return pSize;
	}
	public void setpSize(int pSize) {
		this.pSize = pSize;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	public String getDishRankTName() {
		return dishRankTName;
	}
	public void setDishRankTName(String dishRankTName) {
		this.dishRankTName = dishRankTName;
	}
	public List<String> getShopAffairTagIds() {
		return shopAffairTagIds;
	}
	public void setShopAffairTagIds(List<String> shopAffairTagIds) {
		this.shopAffairTagIds = shopAffairTagIds;
	}
	public Map<String, Long> getPageMap() {
		return pageMap;
	}
	public void setPageMap(Map<String, Long> pageMap) {
		this.pageMap = pageMap;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public List<Dish> getRankDishList() {
		return rankDishList;
	}
	public void setRankDishList(List<Dish> rankDishList) {
		this.rankDishList = rankDishList;
	}
	
	
	

}
