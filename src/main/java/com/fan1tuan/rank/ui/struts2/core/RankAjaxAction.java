package com.fan1tuan.rank.ui.struts2.core;

import java.util.*;

import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.general.util.SessionUtil;
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
	public String getDishRankByTag()
	{   
		 areaId = (String) SessionUtil.getArea(session).get(ISession.AREAID);
		 String tagId = tagService.getRankTagByName(dishRankTName).getId();
		 setRankDishListByTag(dishRankService.rankDishWithRankTag(tagId, areaId));
	     flag = makeFlag(rankDishList);
      return Action.SUCCESS;
		
	}

	/*------------------ /rank/ajax/dishRank.f1t ---------------------*/

	// 入参
	// pNumber -- 页号
	// pSize -- 单页容量
	// shopType -- 店铺类型
	// accord -- 排行依据
	// order -- 递增递减
	// open -- 是否开门
	//
	// 出参
	// dishGeo -- 集合
	// pageMap -- Map

	//菜品排行，筛选
	public String getDishRank()
	{
		//缺少dishTasteTag

		// area的ID
		areaId = (String) SessionUtil.getArea(session).get(ISession.AREAID);
		// 生成page对象
		Pageable page = Pageable.inPage(pNumber, pSize);
				
		rankDishList = dishRankService.rankDish(ShopType.valueOf(shopType), RankAccord.valueOf(accord), Sort.valueOf(order), ShopState.valueOf(open), areaId, page);
		List<DishGeo> dishGeos = new ArrayList<DishGeo>();
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			Map<String, Object> user = SessionUtil.getUser(session);
			String userId = (user == null)?null:(String)user.get(ISession.USER_ID);

			//用户是否登陆，登陆的话标记收藏菜品
			if(userId != null){
				for (Dish aRankDishList : rankDishList) {
					DishGeo geoTemp = new DishGeo(aRankDishList, Constants.FALSE);
					if(userService.isLikeDish(userId, geoTemp.getContent().getId())){
						geoTemp.setLike(Constants.TRUE);
					}else{
						geoTemp.setLike(Constants.FALSE);
					}
					dishGeos.add(geoTemp);
				}
			}else{
				for (Dish aRankDishList : rankDishList) {
					dishGeos.add(new DishGeo(aRankDishList, Constants.FALSE));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		setDishGeo(dishGeos);
		//System.err.println("page items:"+page.getItemsNum()+";pageSize:"+page.getPageSize());

		long length = Pageable.getPageLength(page);
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);


		return Action.SUCCESS;
	}

	/* ----------------- /rank/ajax/dishRankDefault.f1t -------------------*/

	// 入参
	//
	// 出参
	// dishGeo -- 集合
	// pageMap -- Map

	//菜品排行，默认
	public String getDishRankDefault()
	{
		pNumber = 0;
		pSize = 12;
		Pageable page = Pageable.inPage(pNumber, pSize);
		areaId = (String) SessionUtil.getArea(session).get(ISession.AREAID);
		rankDishList = dishRankService.rankDish(areaId, page);

		List<DishGeo> dishGeos = new ArrayList<DishGeo>();
		
		try {
			Map<String, Object> user = SessionUtil.getUser(session);
			String userId = (user == null)?null:(String)user.get(ISession.USER_ID);

			//用户是否登陆，登陆的话标记收藏菜品
			if(userId != null){
				for (Dish aRankDishList : rankDishList) {
					DishGeo geoTemp = new DishGeo(aRankDishList, Constants.FALSE);
					if(userService.isLikeDish(userId, geoTemp.getContent().getId())){
						geoTemp.setLike(Constants.TRUE);
					}else{
						geoTemp.setLike(Constants.FALSE);
					}
					dishGeos.add(geoTemp);
				}
			}else{
				for (Dish aRankDishList : rankDishList) {
					dishGeos.add(new DishGeo(aRankDishList, Constants.FALSE));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDishGeo(dishGeos);
		//System.err.println("page items:"+page.getItemsNum()+";pageSize:"+page.getPageSize());
		long length = Pageable.getPageLength(page);

	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);

		return Action.SUCCESS;
	}

	/* ------------------------ /rank/ajax/phoneCallShopRank.f1t -------------------- */

	// 入参
	// pNumber -- 页号
	// pSize -- 单页容量
	// shopType -- 店铺类型
	// shopTasteTagIds -- taste id 集合
	// accord -- 排行依据
	// order -- 递增递减
	//
	// 出参
	// shopGeo -- 集合
	// pageMap -- Map

	//电话店铺，筛选
	@SuppressWarnings("unchecked")
	public String getPhoneCallShopRank()
	{
		areaId = (String) ((HashMap<String, Object>)session.get(ISession.AREA)).get(ISession.AREAID);
		Pageable page = Pageable.inPage(pNumber, pSize);
		
		List<ShopGeo> shopGeos = shopRankService.rankPhoneCallShopGeos(ShopType.valueOf(shopType), shopTasteTagIds, RankAccord.valueOf(accord), Sort.valueOf(order), areaId, page);
		try {
			//String userId = ((HashMap<String, String>)session.get(ISession.USER)).get(ISession.USER_ID);
			HashMap<String, String> user = (HashMap<String, String>)session.get(ISession.USER);
			String userId = (user == null)?null:user.get(ISession.USER_ID);
			if(userId != null){
				for (ShopGeo shopGeo1 : shopGeos) {
					if (userService.isLikeShop(userId, shopGeo1.getContent().getId())) {
						shopGeo1.setLike(Constants.TRUE);
					} else {
						shopGeo1.setLike(Constants.FALSE);
					}
				}
			}else{
				for (ShopGeo shopGeo1 : shopGeos) {
					shopGeo1.setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);

		long length = Pageable.getPageLength(page);
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);
		return Action.SUCCESS;
	}


	/* ------------------------ /rank/ajax/phoneCallShopRankDefault.f1t -------------------- */

	// 入参
	//
	// 出参
	// shopGeo -- 集合
	// pageMap -- Map

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
				for (ShopGeo shopGeo1 : shopGeos) {
					if (userService.isLikeShop(userId, shopGeo1.getContent().getId())) {
						shopGeo1.setLike(Constants.TRUE);
					} else {
						shopGeo1.setLike(Constants.FALSE);
					}
				}
			}else{
				for (ShopGeo shopGeo1 : shopGeos) {
					shopGeo1.setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);
		long length = Pageable.getPageLength(page.getItemsNum(), page.getPageSize());
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);
		return Action.SUCCESS;
	}

	/* ------------------------ /rank/ajax/onlineShopRank.f1t -------------------- */

	// 入参
	// pNumber -- 页号
	// pSize -- 单页容量
	// shopType -- 店铺类型
	// shopTasteTagIds -- taste id 集合
	// accord -- 排行依据
	// order -- 递增递减
	// open -- 是否开门
	//
	// 出参
	// shopGeo -- 集合
	// pageMap -- Map

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
				for (ShopGeo shopGeo1 : shopGeos) {
					if (userService.isLikeShop(userId, shopGeo1.getContent().getId())) {
						shopGeo1.setLike(Constants.TRUE);
					} else {
						shopGeo1.setLike(Constants.FALSE);
					}
				}
			}else{
				for (ShopGeo shopGeo1 : shopGeos) {
					shopGeo1.setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);

		long length = Pageable.getPageLength(page);
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);

		return Action.SUCCESS;
	}


	/* ------------------------ /rank/ajax/onlineShopRankDefault.f1t -------------------- */

	// 入参
	//
	// 出参
	// shopGeo -- 集合
	// pageMap -- Map

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
				for (ShopGeo shopGeo1 : shopGeos) {
					if (userService.isLikeShop(userId, shopGeo1.getContent().getId())) {
						shopGeo1.setLike(Constants.TRUE);
					} else {
						shopGeo1.setLike(Constants.FALSE);
					}
				}
			}else{
				for (ShopGeo shopGeo1 : shopGeos) {
					shopGeo1.setLike(Constants.FALSE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setShopGeo(shopGeos);

		long length = Pageable.getPageLength(page);
	    pageMap = new HashMap<String, Long>();
	    pageMap.put("length", length);
	    pageMap.put("number", (long) pNumber);

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
		return shopTasteTagIds.size() == 0? null : this.shopTasteTagIds;
	}
	public void setShopTasteTagIds(List<String> shopTasteTagIds) {
		this.shopTasteTagIds = shopTasteTagIds;
		if (shopTasteTagIds != null && shopTasteTagIds.size() == 0) {
			this.shopTasteTagIds = null;
		}
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
	public int getPNumber() {
		return pNumber;
	}
	public void setPNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	public int getPSize() {
		return pSize;
	}
	public void setPSize(int pSize) {
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
