package com.fan1tuan.general.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.DishTasteTagDao;
import com.fan1tuan.general.dao.impl.ExpressClientDao;
import com.fan1tuan.general.dao.impl.ExpressOrderDao;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.dao.impl.RankTagDao;
import com.fan1tuan.general.dao.impl.ShopAffairTagDao;
import com.fan1tuan.general.dao.impl.ShopClientDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.general.dao.impl.ShoppingCartDao;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.util.Constants.RankTagUse;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishRec;
import com.fan1tuan.shop.pojos.DishTasteTag;
import com.fan1tuan.shop.pojos.RankTag;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.shop.pojos.ShopAffairTag;
import com.fan1tuan.shop.pojos.ShopClient;
import com.fan1tuan.shop.pojos.ShopSale;
import com.fan1tuan.shop.pojos.ShopTasteTag;
import com.fan1tuan.user.pojos.FavoriteDish;
import com.fan1tuan.user.pojos.FavoriteShop;
import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.UserAddress;

public class Generator {
	public boolean generate() {
		List<Area> areas = generateAreas();
		List<RankTag> rankTags = generateRankTags();
		List<ShopTasteTag> shopTasteTags = generateShopTasteTags();
		List<ShopAffairTag> shopAffairTags = generateShopAffairTags();
		List<ShopClient> shopClients = generateShopClients();
		List<User> users = generateUsers();
		List<Shop> shops = generateShops(50);
		
		
		template.indexOps(Shop.class).ensureIndex(new GeospatialIndex("location"));
		
		areaDao.addMulti(areas);
		rankTagDao.addMulti(rankTags);
		shopTasteTagDao.addMulti(shopTasteTags);
		shopAffairTagDao.addMulti(shopAffairTags);
		shopClientDao.addMulti(shopClients);
		userDao.addMulti(users);
		int i = 0;
		for(Shop shop : shops){
			for(ShopAffairTag shopAffairTag : shopAffairTags){
				if(halfChance()){
					shop.getShopAffairTagIds().add(shopAffairTag.getId());
				}
			}
			shop.getShopTasteTagIds().add(randomElem(shopTasteTags).getId());
			shop.setAvatar((i++)+".jpeg");
		}
		shopDao.addMulti(shops);

		for(Shop shop : shops){
			List<DishTasteTag> dishTasteTags = generateDishTasteTags((int)(Math.random()*8), shop.getId());
			dishTasteTagDao.addMulti(dishTasteTags);
			for(DishTasteTag dishTasteTag : dishTasteTags){
				List<Dish> dishes = generateDishes(((int)(Math.random()*12)+1), dishTasteTag.getId(), shop.getId());
				dishDao.addMulti(dishes);
			}
			fillShopComments(shop.getId(), 20, 15);
		}
		
		
		
		return true;
	}

	public boolean fillShopComments(String shopId, int scale, int perNum){
		List<Dish> dishes = dishDao.findProjectedByParams(CriteriaWrapper.instance().is("shopId", shopId), FieldFilter.instance("id"));
		List<User> users = userDao.findProjectedAll(FieldFilter.instance("id","username"));
		if(dishes==null||dishes.size()==0){
			return false;
		}
		for(int i = 0; i < scale; i++){
			User user = randomElem(users);
			List<DishComment> comments = generateDishComments(perNum, user.getId(), user.getUsername(), randomElem(dishes).getId());
			for(DishComment dishComment : comments){
				dishCommentDao.add(dishComment);
				dishDao.updateFirstByParams(dishComment.getDishId(), UpdateWrapper.instance().inc("commentNum", 1).inc("commentLevel", dishComment.getCommentLevel()));
				shopDao.updateFirstByParams(shopId, UpdateWrapper.instance().inc("commentNum", 1).inc("commentLevel", dishComment.getCommentLevel()));
			}
		}
		for(Dish dish : dishes){
			Dish temp = dishDao.findOneById(dish.getId());
			temp.setAvgCommentLevel((temp.getCommentLevel()==0)?0:NumberUtil.reserveBit(temp.getCommentLevel()/temp.getCommentNum(),1));
			dishDao.update(temp);
		}
		
		Shop shop = shopDao.findOneById(shopId);
		shop.setAvgCommentLevel((shop.getCommentLevel()==0)?0:NumberUtil.reserveBit(shop.getCommentLevel()/shop.getCommentNum(),1));
		shopDao.update(shop);
		
		return true;
	}
	
	public List<Area> generateAreas(){
		Area area = new Area();
		area.setLatitude(38.799963);
		area.setLongtitude(121.163815); //交大航运 121.163815,38.799963
		area.setName("大连交通大学");
		area.setRadius(900);
		
		Area area2 = new Area();
		area2.setLatitude(38.789108); //大连科技大学 
		area2.setLongtitude(121.159629);
		area2.setName("大连科技大学");
		area2.setRadius(800);
		
		Area area3 = new Area();
		area3.setLatitude(38.820374); //大连医科大学 121.322061,38.820374
		area3.setLongtitude(121.322061);
		area3.setName("大连医科大学");
		area3.setRadius(1500);		
		
		Area area4 = new Area();
		area4.setLatitude(38.888651);  //121.537043,38.888651
		area4.setLongtitude(121.537043);
		area4.setName("大连理工大学");
		area4.setRadius(1100);
		
		return Arrays.asList(area, area2, area3, area4);
	}
	
	public List<RankTag> generateRankTags(){
		RankTag rankTag = new RankTag();
		rankTag.setName("每周之星");
		rankTag.setDescription("每周评选出的最佳菜品");
		rankTag.setUse(RankTagUse.DISH.ordinal());
		
		RankTag rankTag2 = new RankTag();
		rankTag2.setName("销量冠军");
		rankTag2.setDescription("这个店铺是周期内的销量冠军");
		rankTag2.setUse(RankTagUse.SHOP.ordinal());
		
		RankTag rankTag3 = new RankTag();
		rankTag3.setName("销量冠军");
		rankTag3.setDescription("这个菜品是店铺中的销量冠军");
		rankTag3.setUse(RankTagUse.DISH.ordinal());
		
		return Arrays.asList(rankTag, rankTag2, rankTag3);
	}
	
	public List<ShopTasteTag> generateShopTasteTags(){
		ShopTasteTag shopTasteTag = new ShopTasteTag();
		shopTasteTag.setDescription("奶茶系列");
		shopTasteTag.setName("奶茶");

		ShopTasteTag shopTasteTag2 = new ShopTasteTag();
		shopTasteTag2.setDescription("中式系列");
		shopTasteTag2.setName("中式");

		ShopTasteTag shopTasteTag3 = new ShopTasteTag();
		shopTasteTag3.setDescription("西式系列");
		shopTasteTag3.setName("西式");

		ShopTasteTag shopTasteTag4 = new ShopTasteTag();
		shopTasteTag4.setDescription("港式系列");
		shopTasteTag4.setName("港式");

		ShopTasteTag shopTasteTag5 = new ShopTasteTag();
		shopTasteTag5.setDescription("烧烤系列");
		shopTasteTag5.setName("烧烤");
		
		ShopTasteTag shopTasteTag6 = new ShopTasteTag();
		shopTasteTag6.setDescription("日式系列");
		shopTasteTag6.setName("日式");

		ShopTasteTag shopTasteTag7 = new ShopTasteTag();
		shopTasteTag7.setDescription("韩式系列");
		shopTasteTag7.setName("韩式");

		ShopTasteTag shopTasteTag8 = new ShopTasteTag();
		shopTasteTag8.setDescription("甜点系列");
		shopTasteTag8.setName("甜点");

		ShopTasteTag shopTasteTag9 = new ShopTasteTag();
		shopTasteTag9.setDescription("汉堡系列");
		shopTasteTag9.setName("汉堡");

		return Arrays.asList(shopTasteTag, shopTasteTag2, shopTasteTag3, shopTasteTag4, shopTasteTag5, shopTasteTag6, shopTasteTag7, shopTasteTag8, shopTasteTag9);
	}
	
	public List<ShopAffairTag> generateShopAffairTags(){
		ShopAffairTag shopAffairTag = new ShopAffairTag();
		shopAffairTag.setDescription("该商家支持随时退");
		shopAffairTag.setName("退");
		
		ShopAffairTag shopAffairTag2 = new ShopAffairTag();
		shopAffairTag2.setDescription("该商家支持开具发票");
		shopAffairTag2.setName("票");
		
		return Arrays.asList(shopAffairTag, shopAffairTag2);
	}
	
	//userId,dishId
	/*
	 * 在添加dishComment之时，请注意联动更新dish和shop的评价
	 */
	public List<DishComment> generateDishComments(int num, String userId, String userName, String dishId){
		
		String[] comments = new String[]{"好评！！！","好好吃！！","这是我吃过的最满意的一顿饭，哈哈","难吃！！",
				"吃完了恶心，大家不要来","是啊是啊，大家不要来啦","这家店不咋地","店老板很热情的","好不好吃，自己来试试",
				"评论真好看","饭菜很好吃~~","真的非常好吃哦！","一级棒！！","棒极啦~~~","good！","都来尝尝老板的手艺把",
				"不吃不知道","一吃吓一跳","自己尝尝，好不好吃啊","整体瞎叫唤，自己来尝尝，真的很好吃！！","不好吃，不会再来啦",
				"不好吃，一股地沟油味道","没有别的话啦，好吃","我觉着不好吃，你们觉着呢"};
		
		ArrayList<DishComment> list = new ArrayList<DishComment>();
		
		int index = 0;
		while(index++ < num){
			DishComment dishComment = new DishComment();
			dishComment.setDate(new Date());
			dishComment.setComment(randomElem(comments));
			dishComment.setCommentLevel((int)(Math.random()*5)+1);
			dishComment.setUserId(userId);
			dishComment.setUserName(userName);
			dishComment.setDishId(dishId);
			list.add(dishComment);
		}
		return list;
	}
	
	//shopId
	public List<DishTasteTag> generateDishTasteTags(int num, String shopId){
		ArrayList<DishTasteTag> list = new ArrayList<DishTasteTag>();
		
		String[] description = new String[]{"这是一个店铺内的菜品口味分类","某个店铺的菜品口味分类"};
		String[] names = new String[]{"炒饭","招牌","特价","送可口可乐","送加多宝","本地特色","套餐","销量冠军","其他"};
		
		int index = 0;
		while(index++ < num){
			DishTasteTag dishTasteTag = new DishTasteTag();
			dishTasteTag.setDescription(randomElem(description));
			dishTasteTag.setName(randomElem(names));
			dishTasteTag.setShopId(shopId);
			list.add(dishTasteTag);
		}
		
		return list;
	}
	
	public List<ShopClient> generateShopClients(){
		ShopClient shopClient = new ShopClient();
		shopClient.setPassword("1234");
		shopClient.setUsername("lihe");
		shopClient.setShopId("");
		
		ShopClient shopClient2 = new ShopClient();
		shopClient2.setPassword("1234");
		shopClient2.setUsername("zrh");
		shopClient2.setShopId("");
		
		ShopClient shopClient3 = new ShopClient();
		shopClient3.setPassword("1234");
		shopClient3.setUsername("lyk");
		shopClient3.setShopId("");
		
		ShopClient shopClient4 = new ShopClient();
		shopClient4.setPassword("1234");
		shopClient4.setUsername("mls");
		shopClient4.setShopId("");
		
		ShopClient shopClient5 = new ShopClient();
		shopClient5.setPassword("1234");
		shopClient5.setUsername("qyf");
		shopClient5.setShopId("");
		
		return Arrays.asList(shopClient, shopClient2, shopClient3, shopClient4, shopClient5);
	}
	
	public List<User> generateUsers(){
		User user = new User();
		user.setCellphone("18876768876");
		user.setCredit(0);
		user.setEmail("47628@qq.com");
		user.setFavoriteDishes(new ArrayList<FavoriteDish>());
		user.setFavoriteShops(new ArrayList<FavoriteShop>());
		user.setImage("");
		user.setLevel(0);
		user.setPassword("1234");
		user.setQq("288912");
		user.setRealName("张三");
		user.setUserAddresses(new ArrayList<UserAddress>());
		user.setUsername("lihe");
		
		User user2 = new User();
		user2.setCellphone("18876763354");
		user2.setCredit(0);
		user2.setEmail("2132141@qq.com");
		user2.setFavoriteDishes(new ArrayList<FavoriteDish>());
		user2.setFavoriteShops(new ArrayList<FavoriteShop>());
		user2.setImage("");
		user2.setLevel(0);
		user2.setPassword("1234");
		user2.setQq("321421");
		user2.setRealName("李四");
		user2.setUserAddresses(new ArrayList<UserAddress>());
		user2.setUsername("zrh");
		
		return Arrays.asList(user, user2);
	}
	
	//dishTasteTagId,shopId
	public List<Dish> generateDishes(int num, String dishTasteTagId, String shopId){
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		
		String[] description = new String[]{"完美的菜","这是汇聚中华美食的完美的菜","这个菜是我们店铺的极品菜"};
		String[] names = new String[]{"扬州炒饭","牛肉堡","好吃的堡","鱼肉炒饭","A套餐",
				"虾堡","牛肉拌饭","土豆煲仔饭","蜂蜜柚子茶","焦糖布丁","筋头巴脑","解馋脱骨凤爪",
				"解馋猪蹄","解馋牛肚丝","解馋牛蹄筋","解馋鸭舌","解馋鸭脖","解馋牛口条","解馋鸡心",
				"麻辣脑花","麻辣黄喉","红烧肉","香辣牛骨髓","麻辣掌中宝","香辣牛肉","麻辣小龙虾",
				"麻辣田螺","麻辣鲍鱼","活剥夏夷贝柱","麻辣虾爬肉","金牌河蟹","麻辣活虾","麻辣鱿鱼",
				"麻辣海撒","麻辣鸟贝","麻辣飞蟹","麻辣籽乌","麻辣夏夷贝","麻辣皮皮虾","麻辣卢沟虾",
				"凉拌嘎巴虾","凉拌花盖","红烧排骨饭","红烧肉饭","辣子鸡丁饭","宫保鸡丁饭","鱼香肉丝饭",
				"茄汁牛腩饭","孜然牛肉饭","红烧鸡块饭","木须肉饭","西红柿鸡蛋饭","韭菜鸡蛋饭","尖椒炒蛋饭",
				"麻婆豆腐饭","烧茄子饭","鱼香茄子饭","肉丝炒饭","火腿蛋炒饭","鲜虾水饺","韭菜海肠","猪肉韭菜鲅鱼",
				"猪肉馄饨","青椒肉丝","香菇滑鸡","狮子头","鱼香肉丝","鱼香鸡蛋","香炒豆腐","乡村花菜 ",
				"西红柿炒蛋","酱香茄子","芸豆土豆丁","咖喱鸡肉","蒜苔炒肉","肉碎酸豆角","咖喱牛肉","卤肉",
				"牛肉炖土豆","手撕肉","蜜汁排骨","日式牛肉","大酱汤","酸菜五花肉","金针肥牛","西红柿牛腩",
				"土豆炖豆腐","小鸡炖蘑菇","麻辣香锅","拌鸡架","蓝莓山药","泡椒蜀汉笋","烤鸡翅","南瓜浓汤"};
		
		int index = 0;
		while(index++ < num){
			Dish dish = new Dish();
			dish.setAvgCommentLevel(0);
			dish.setCommentNum(0);
			dish.setCommentLevel(0);
			dish.setDescription(randomElem(description));
			dish.setDishTasteTagId(dishTasteTagId);
			dish.setImage((int)(Math.random()*68)+".jpeg");
			dish.setName(randomElem(names));
			dish.setOriginPrice(NumberUtil.reserveBit(Math.random()*20+2,1));
			dish.setPrice(NumberUtil.reserveBit(dish.getOriginPrice()*Math.random(), 0));
			dish.setRankTagIds(new ArrayList<String>());
			dish.setSaleVolume((int)(Math.random()*100));
			dish.setShopId(shopId);
			dish.setStatus(0);
			
			dishes.add(dish);
		}
		
		return dishes;
	}
	
	public List<Shop> generateShops(int num){
		ArrayList<Shop> shops = new ArrayList<Shop>();
		String[] cities = new String[]{"大连","济南","成都","广州"};
		String[] districts = new String[]{"中山区","旅顺口区","沙河口区","西岗区","市中区"};
		String[] roads = new String[]{"兴发路","中山路","经三路","纬二路","北陵大街","南京街"};
		
		String[] salutations = new String[]{"亲！","您好！","亲爱的用户！","哈喽！","嗨！"};
		String[] styles = new String[]{"我们的菜很好吃哦~","吃我们家的吧，味道无敌的好！","其他的弱爆了，我们的好！","这里有您不知道的美味~","非常的赞的美食哦~~~快来吧"};
		
		String[] descriptions = new String[]{"我们家的饭很好吃哦","快来吃吧，特色炒饭~","QQ桶饭，全是特色！","来吧来吧，只有你尝不到的！","小辉家的特色，全在这里！！","来吧来吧，我等着你~~"};
		
		List<Area> areas = this.generateAreas();
		
		String[] names = new String[]{"饭醉团火","阿福盖浇饭","小馋猫米粉","无明缘米粉","KHC",
				"上海小吃","小辣椒","西北面食","不差钱炒冷面","私房牛肉饭","杨国福麻辣烫","万里香",
				"美味烤肉饭","淼淼烤肉饭","大熊解馋坊","麻辣道","韩国泡菜","味思美","无名缘米粉",
				"千味牛肉饭店","新阳光快餐","佳乐快餐小炒","鼎易坊快餐","长林小店","懿香阁上海特色",
				"橘子餐厅","百味川菜","美味来快餐","港式小吃","丸子小吃","八哥米线","好再来快餐",
				"八哥米线","锅锅香小吃","香吧嘴麻辣烫","有缘来米粉","食全食美","家常小菜","爱情麻辣烫",
				"台北香肉饭","黄记麻辣百分百","三秦面庄","慕尚快餐","瓦罐营养快餐","泓源美食","蜜秘鸡地",
				"小馆印巷","鲅鱼饺子馆","台湾美食","旺旺美食屋","惠客快餐","咱家灶脚","食全巷","鑫蒙特牛杂",
				"山西辛玉田锅贴","奶茶牧场餐厅","便当屋 配餐","天天美味","民生源","紫藤地瓜坊","瓦房店全羊",
				"排骨精排骨饭","私房小厨","碳火瓦罐"};
		
		int index = 0;
		while(index++ < num){
			Shop shop = new Shop();
			shop.setAddress(randomElem(cities)+randomElem(districts)+randomElem(roads));
			shop.setAnnouncement(randomElem(salutations)+randomElem(styles));
			shop.setCommentNum(0);
			shop.setAvgCommentLevel(0);
			shop.setCommentLevel(0);
			shop.setAvgDeliveryTime((int)(Math.random()*45));
			shop.setAvgPersonCost((int)(Math.random()*25));
			shop.setCellphone("18842628878");
			shop.setDeliveryCharge((int)(Math.random()*10));
			shop.setDescription(randomElem(descriptions));
			shop.setDishRecs(new ArrayList<DishRec>());
			Area area = randomElem(areas);
			shop.setLocation(minimalChange(area.getLongtitude(), area.getLatitude()));
			shop.setName(randomElem(names));
			shop.setOpen(halfChance());
			shop.setCloseTime(DateUtil.getEndOfDay(new Date()));
			shop.setOpenTime(DateUtil.getStartOfDay(new Date()));
			shop.setOrderType((int) (Math.random() * 2));
			shop.setPopularity((int) (Math.random() * 300));
			shop.setRankTagIds(new ArrayList<String>());   //需要添加
			shop.setSaleVolume((int) (Math.random() * 200));
			shop.setShopAffairTagIds(new ArrayList<String>());  //需要添加
			shop.setShopSales(new ArrayList<ShopSale>());
			shop.setShopTasteTagIds(new ArrayList<String>());   //需要添加
			shop.setTelephone("18878765565");
			shop.setType((int)(Math.random()*2));
			shops.add(shop);
		}
		
		return shops;
	}
	
	//userId
	public ShoppingCart generateShoppingCart(String userId){
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setPrice(0);
		shoppingCart.setShopItems(new ArrayList<ShopItem>());
		shoppingCart.setUserId(userId);
		return shoppingCart;
	}
	
	/*
	public List<Order> generateOrders(int num){
		List<Order> orders = new ArrayList<Order>();
		
		int index = 0;
		while(index++ < num){
			Order order = new Order();
			order.setAddress(address);
			order.setCellphone(cellphone);
			order.setChargeType(chargeType);
			order.setDate(date);
			order.setDeliveryTime(deliveryTime);
			order.setDeliveryTime(deliveryTime);
		}
	}
	*/
	
	public double[] minimalChange(double longtitude, double latitude){
		double changeOne = (Math.random()*8/1000);
		double changeTwo = (Math.random()*8/1000);
		if(halfChance()){
			longtitude+=changeOne;
		}else{
			longtitude-=changeOne;
		}
		
		if(halfChance()){
			latitude += changeTwo;
		}else{
			latitude -= changeTwo;
		}
		return new double[]{longtitude, latitude};
	}
	
	public <T> T randomElem(T[] array){
		int index = (int)(Math.random()*array.length);
		return array[index];
	}
	
	public <T> T randomElem(List<T> array){
		int index = (int)(Math.random()*array.size());
		return array.get(index);
	}

	public boolean halfChance(){
		return (((int)(Math.random()*10))%2==0)?true:false;
	}

	private MongoOperations template;
	
	
	public MongoTemplate getTemplate() {
		return (MongoTemplate)template;
	}

	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	private AreaDao areaDao;
	private DishCommentDao dishCommentDao;
	private DishDao dishDao;
	private DishTasteTagDao dishTasteTagDao;
	private ExpressClientDao expressClientDao;
	private ExpressOrderDao expressOrderDao;
	private OrderDao orderDao;
	private RankTagDao rankTagDao;
	private ShopAffairTagDao shopAffairTagDao;
	private ShopClientDao shopClientDao;
	private ShopDao shopDao;
	private ShoppingCartDao shoppingCartDao;
	private ShopTasteTagDao shopTasteTagDao;
	private UserDao userDao;
	

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}

	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public DishTasteTagDao getDishTasteTagDao() {
		return dishTasteTagDao;
	}

	public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
		this.dishTasteTagDao = dishTasteTagDao;
	}

	public ExpressClientDao getExpressClientDao() {
		return expressClientDao;
	}

	public void setExpressClientDao(ExpressClientDao expressClientDao) {
		this.expressClientDao = expressClientDao;
	}

	public ExpressOrderDao getExpressOrderDao() {
		return expressOrderDao;
	}

	public void setExpressOrderDao(ExpressOrderDao expressOrderDao) {
		this.expressOrderDao = expressOrderDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public RankTagDao getRankTagDao() {
		return rankTagDao;
	}

	public void setRankTagDao(RankTagDao rankTagDao) {
		this.rankTagDao = rankTagDao;
	}

	public ShopAffairTagDao getShopAffairTagDao() {
		return shopAffairTagDao;
	}

	public void setShopAffairTagDao(ShopAffairTagDao shopAffairTagDao) {
		this.shopAffairTagDao = shopAffairTagDao;
	}

	public ShopClientDao getShopClientDao() {
		return shopClientDao;
	}

	public void setShopClientDao(ShopClientDao shopClientDao) {
		this.shopClientDao = shopClientDao;
	}

	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	public ShopTasteTagDao getShopTasteTagDao() {
		return shopTasteTagDao;
	}

	public void setShopTasteTagDao(ShopTasteTagDao shopTasteTagDao) {
		this.shopTasteTagDao = shopTasteTagDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
