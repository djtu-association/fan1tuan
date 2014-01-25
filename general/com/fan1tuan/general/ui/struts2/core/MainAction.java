package com.fan1tuan.general.ui.struts2.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.fan1tuan.shop.business.DishClientService;
import com.fan1tuan.shop.business.DishUserService;
import com.fan1tuan.user.pojos.User;
import com.opensymphony.xwork2.Action;

public class MainAction implements SessionAware, ApplicationAware, RequestAware{
	
	static Logger logger = LogManager.getLogger();
	
	public String execute(){
		logger.entry();
		
		projectName = "fan1tuan";
		releaseDate = new Date();
		
		shoppingCart = new ShoppingCart();
		shoppingCart.setId("fsd92380fsda");
		shoppingCart.setPrice(192321.1);
		
		DishItem dishItem1 = new DishItem();
		dishItem1.setDishId("28490230dsfa");
		dishItem1.setDishPrice(12312);
		dishItem1.setNumber(2);
		
		DishItem dishItem2 = new DishItem();
		dishItem2.setDishId("fdsa221321");
		dishItem2.setDishPrice(321.3);
		dishItem2.setNumber(4);
		
		ArrayList<DishItem> dishItems = new ArrayList<DishItem>();
		dishItems.add(dishItem1);
		dishItems.add(dishItem2);
		
		ShopItem shopItem = new ShopItem();
		shopItem.setDishItems(dishItems);
		shopItem.setShopId("fdsfjalk221");
		shopItem.setSumPrice(321421);
		
		ArrayList<ShopItem> shopItems = new ArrayList<ShopItem>();
		shopItems.add(shopItem);
		
		shoppingCart.setUserId("fdsajklqweq");
		shoppingCart.setShopItems(shopItems);

		/*
		Dish dish = new Dish();
		dish.setName("宫保鸡丁");
		dish.setDescription("好吃的宫保鸡丁");
		dishClientService.addDishToShop(dish, "fdsafas324fdsa");
		*/
		tags = new ArrayList<String>();
		tags.add("开心");
		tags.add("愉快");
		tags.add("fsdjka11");
		
		dishList = new ArrayList<DishItem>();
		dishList.add(dishItem1);
		dishList.add(dishItem2);
		
		dishSet = new HashSet<DishItem>();
		dishSet.add(dishItem1);
		dishSet.add(dishItem2);
		
		dishMap = new HashMap<String, DishItem>();
		dishMap.put("我的最爱", dishItem1);
		dishMap.put("我的收藏", dishItem2);
		
		map = new HashMap<String, String>();
		map.put("Hello", "不错嘛");
		map.put("你好", "nice");
		
		
		User user = new User();
		user.setId("fdsajkdlasfa");
		user.setUsername("李赫");
		request.put("user", user);
		session.put("user", user);
		application.put("user", user);
			
		dishUserService.getDish("fhjfj");
		
		logger.fatal("MainAction Complete!");
		
		return logger.exit(Action.SUCCESS);
	}
	
	/*
	 * 无需让spring托管struts Action，Spring bean会以bean name为依据自动注入
	 * 注入bean类型请写接口类型，不要写实现类类型，而且，注入在action里的，仅仅允许为Service，不要注入Dao
	 */
	private DishClientService dishClientService;
	private DishUserService dishUserService;
	public DishUserService getDishUserService() {
		return dishUserService;
	}
	public void setDishUserService(DishUserService dishUserService) {
		this.dishUserService = dishUserService;
	}
	public DishClientService getDishClientService() {
		return dishClientService;
	}
	public void setDishClientService(DishClientService dishClientService) {
		this.dishClientService = dishClientService;
	}
	

	/*
	 * 与前台交互的逻辑实例变量
	 */
	private String projectName;
	private Date releaseDate;
	private ShoppingCart shoppingCart;
	private ArrayList<String> tags;
	private ArrayList<DishItem> dishList;
	private HashSet<DishItem> dishSet;
	private HashMap<String, DishItem> dishMap;
	private HashMap<String, String> map;
	
	public ArrayList<DishItem> getDishList() {
		return dishList;
	}
	public void setDishList(ArrayList<DishItem> dishList) {
		this.dishList = dishList;
	}
	public HashSet<DishItem> getDishSet() {
		return dishSet;
	}
	public void setDishSet(HashSet<DishItem> dishSet) {
		this.dishSet = dishSet;
	}
	public HashMap<String, DishItem> getDishMap() {
		return dishMap;
	}
	public void setDishMap(HashMap<String, DishItem> dishMap) {
		this.dishMap = dishMap;
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	/*
	 * 以此来使Action有机会修改与获取Session, Application, Request中的Attribute
	 * 三个map的set方法需要如此实现，struts2的Interceptor可以注入所需的map
	 */
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@Override
	public void setApplication(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setSession(Map<String, Object> application) {
		this.application = application;
	}
	
	
}
