package com.fan1tuan.order.business.mongoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.ShoppingCartDao;
import com.fan1tuan.general.util.UUIDGenerator;
import com.fan1tuan.general.util.Constants.ChargeType;
import com.fan1tuan.general.util.Constants.OrderStatus;
import com.fan1tuan.order.business.ShoppingCartService;
import com.fan1tuan.order.pojos.DishItem;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.order.pojos.ShopItem;
import com.fan1tuan.order.pojos.ShoppingCart;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.Shop;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	private ShoppingCartDao shoppingCartDao;	
	private OrderDao orderDao;
	private ShopDao shopDao;
	private DishDao dishDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}
	
	public ShopDao getShopDao() {
		return shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	public DishDao getDishDao() {
		return dishDao;
	}
	
	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}
	
	@Override
	public ShoppingCart getShoppingCartById(String id) {		
		return shoppingCartDao.findOneById(id);
	}

	@Override
	public ShoppingCart getShoppingCartByUserId(String userId) {
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		if(shoppingCart==null){
			shoppingCart = new ShoppingCart();
			shoppingCart.setItemNum(0);
			shoppingCart.setPrice(0);
			shoppingCart.setShopItems(new ArrayList<ShopItem>());
			shoppingCart.setUserId(userId);
			shoppingCartDao.add(shoppingCart);
		}
		return shoppingCart;
	}

	@Override
	public List<ShopItem> getShopItemById(String id) {
		ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
		return shoppingCart.getShopItems();
	}

	@Override
	public List<ShopItem> getShopItemByUserId(String userId) {
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		return shoppingCart.getShopItems();
	}

	@Override
	public List<DishItem> getAllDishItemsById(String id) {	
		return this.getDishItems(shoppingCartDao.findOneById(id),null);
	}

	@Override
	public List<DishItem> getAllDishItemsByUserId(String userId) {
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		return this.getDishItems(shoppingCart,null);
	}
	
	@Override
	public List<DishItem> getDishItemsByIdByShopId(String id,String shopId) {
		return this.getDishItems(shoppingCartDao.findOneById(id),shopId);
	}

	@Override
	public List<DishItem> getDishItemsByUserIdByShopId(String userId,String shopId) {
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		return this.getDishItems(shoppingCart,shopId);
	}

	@Override
	public boolean addOneShopItemToCartById(String id,ShopItem shopItem) {
		try {
			shoppingCartDao.upsert(CriteriaWrapper.instance().is("id", id), UpdateWrapper.instance().addToSet("shopItems", shopItem));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addOneShopItemToCartByUserId(String userId, ShopItem shopItem) {
		try {
			shoppingCartDao.upsert(CriteriaWrapper.instance().is("userId", userId), UpdateWrapper.instance().addToSet("shopItems", shopItem));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean addShopItemsToCartById(String id,ShopItem... shopItems) {
		try {
			shoppingCartDao.upsert(CriteriaWrapper.instance().is("id", id), UpdateWrapper.instance().addToSet("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean addShopItemsToCartByUserId(String userId,ShopItem... shopItems){
		try {
			shoppingCartDao.upsert(CriteriaWrapper.instance().is("userId", userId), UpdateWrapper.instance().addToSet("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeOneShopItemByIdByShopId(String id,String shopId) {
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			for(ShopItem shopItem : shoppingCart.getShopItems())
			{
				if(shopItem!=null && shopItem.getShopId().equals(shopId))
				{
					shoppingCartDao.updateFirstByParams(CriteriaWrapper.instance().is("id", id), UpdateWrapper.instance().pull("shopItems", shopItem));
				}
				break;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeOneShopItemByUserIdByShopId(String userId,String shopId){
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
			for(ShopItem shopItem : shoppingCart.getShopItems())
			{
				if(shopItem!=null && shopItem.getShopId().equals(shopId))
				{
					shoppingCartDao.updateFirstByParams(CriteriaWrapper.instance().is("userId", userId), UpdateWrapper.instance().pull("shopItems", shopItem));
				}
				break;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addOneDishItem(String id,String shopId, DishItem dishItem) {
		try {
			//shoppingCartDao.updateFirstByParams(CriteriaWrapper.instance().is("id", id), UpdateWrapper.instance().push("shopItems.dishItems", dishItem));
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
			if(shopItems.isEmpty() || shopItems == null)
			{
				return false;
			}
			for(ShopItem shopItem : shopItems)
			{
				if(shopItem.getShopId().equals(shopId))
				{
					ArrayList<DishItem> dishItems = shopItem.getDishItems();
					if(dishItems == null)
					{
						dishItems = new ArrayList<DishItem>();
					}
					dishItems.add(dishItem);
					//shopItem.setDishItems(dishItems);
					break;
				}
			}
			shoppingCartDao.updateFirstByParams(id, UpdateWrapper.instance().set("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addDishItems(String id,String shopId, List<DishItem> dishItems) {
		try {
			//shoppingCartDao.updateFirstByParams(CriteriaWrapper.instance().is("id", id), UpdateWrapper.instance().push("shopItems.dishItems", dishItem));
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
			if(shopItems.isEmpty() || shopItems == null)
			{
				return false;
			}
			for(ShopItem shopItem : shopItems)
			{
				if(shopItem.getShopId().equals(shopId))
				{
					ArrayList<DishItem> dishItems2 = shopItem.getDishItems();
					if(dishItems2 == null)
					{
						dishItems2 = new ArrayList<DishItem>();
					}
					dishItems2.addAll(dishItems);
					//shopItem.setDishItems(dishItems2);
					break;
				}
			}
			shoppingCartDao.updateFirstByParams(id, UpdateWrapper.instance().set("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeOneDishItemById(String id,String shopId,String dishId) {
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
			if(shopItems.isEmpty())
			{
				return false;
			}
			for(ShopItem shopItem : shopItems)
			{
				if(shopItem.getShopId().equals(shopId))
				{
					ArrayList<DishItem> dishItems = shopItem.getDishItems();
					if(dishItems.isEmpty()) return false;
					for(DishItem dishItem : dishItems)
					{
						if(dishItem.getDishId().equals(dishId))
						{
							dishItems.remove(dishItem);
							//shopItem.setDishItems(dishItems);
						}
						break;
					}
				}
			}
			shoppingCartDao.updateFirstByParams(id, UpdateWrapper.instance().set("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean upsertDishitemNumberById(String id,String shopId,String dishId,int number) { //number should not be less than 1(even not 0),如果传入的是小于等于0，则默认为自增1（仅本类内和测试用）
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
			if(shopItems.isEmpty() || shopItems == null)
			{
				return false;
			}
			for(ShopItem shopItem : shopItems)
			{
				if(shopItem.getShopId().equals(shopId))
				{
					ArrayList<DishItem> dishItems = shopItem.getDishItems();
					for(DishItem dishItem : dishItems)
					{
						if(dishItem.getDishId().equals(dishId))
						{
							if(number < 1)//如果number为小于等于0，则自增1
							{
								dishItem.setNumber(dishItem.getNumber()+1);
							}
							else {
								dishItem.setNumber(number);
							}							
							shopItem.setDishItems(dishItems);
							//shoppingCart.setShopItems(shopItems);
							break;
						}
					}
				}
			}
			shoppingCartDao.updateFirstByParams(id, UpdateWrapper.instance().set("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean upsertDishItemNumberByUserId(String userId,String shopId,String dishId,int number) {
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
			ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
			if(shopItems.isEmpty() || shopItems == null)
			{
				return false;
			}
			for(ShopItem shopItem : shopItems)
			{
				if(shopItem != null && shopItem.getShopId().equals(shopId))
				{
					ArrayList<DishItem> dishItems = shopItem.getDishItems();
					for(DishItem dishItem : dishItems)
					{
						if(dishItem.getDishId().equals(dishId))
						{
							if(number < 1)//如果number为小于等于0，则自增1
							{
								dishItem.setNumber(dishItem.getNumber()+1);
							}
							else {
								dishItem.setNumber(number);
							}
							shopItem.setDishItems(dishItems);
							//shoppingCart.setShopItems(shopItems);
							break;
						}
					}
				}
			}
			shoppingCartDao.updateFirstByParams(CriteriaWrapper.instance().is("userId", userId), UpdateWrapper.instance().set("shopItems", shopItems));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean increaseDishItemNumberByIdByShopIdByDishId(String id,
			String shopId, String dishId) {
		try {
			this.upsertDishitemNumberById(id, shopId, dishId, 1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean increaseDishItemNumberByUserIdByShopIdByDishId(
			String userId, String shopId, String dishId) {
		try {
			
			this.upsertDishItemNumberByUserId(userId, shopId, dishId, 1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 前提是要保证，shopItem 和DishItem必须存在，否则会出错
	 */
	@Override
	public boolean decreaseDishItemNumberByIdByShopIdByDishId(String id,
			String shopId, String dishId) {
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneById(id);
			for(ShopItem shopItem : shoppingCart.getShopItems())
			{
				if(shopItem.getShopId().equals(shopId))
				{
					for(DishItem dishItem : shopItem.getDishItems())
					{
						if(dishItem.getNumber()>1) //DishItem 的number最小应该是1，也不应该是0，前台也应该这样控制
						{
							this.upsertDishitemNumberById(id, shopId, dishId, dishItem.getNumber()-1);
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean decreaseDishItemNumberByUserIdByShopIdByDishId(String userId,
			String shopId, String dishId) {
		try {
			ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
			for(ShopItem shopItem : shoppingCart.getShopItems())
			{
				if(shopItem.getShopId().equals(shopId))
				{
					for(DishItem dishItem : shopItem.getDishItems())
					{
						if(dishItem.getNumber()>1) //DishItem 的number最小应该是1，也不应该是0，前台也应该这样控制
						{
							this.upsertDishItemNumberByUserId(userId, shopId, dishId, dishItem.getNumber()-1);
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cleanShoppingCartById(String id) {
		try {
			shoppingCartDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cleanShoppingCartByUserId(String userId) {
		try {
			shoppingCartDao.deleteByParams(CriteriaWrapper.instance().is("userId", userId));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean saveShopingCart(ShoppingCart shoppingCart) {
		try {
			if(null != shoppingCart.getId() )
			{
				shoppingCartDao.update(shoppingCart);
			}
			else {
				shoppingCart.setId(UUIDGenerator.generateUUID());
				shoppingCartDao.add(shoppingCart);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 前提是每一个shopItem和DishItem都不能为空，否则会有nullPointerException
	 */
	@Override
	public double getTotalPriceById(String id) {
		double total = 0;
		double single = 0;
		for(ShopItem shopItem : shoppingCartDao.findOneById(id).getShopItems())
		{
			for(DishItem dishItem : shopItem.getDishItems())
			{
				single = dishItem.getDishPrice() * dishItem.getNumber();
				total += single;
			}
		}
		return total;
	}

	@Override
	public double getTotalPriceByUserId(String userId) {
		double total = 0;
		double single = 0;
		for(ShopItem shopItem : shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId)).getShopItems())
		{
			for(DishItem dishItem : shopItem.getDishItems())
			{
				single = dishItem.getDishPrice() * dishItem.getNumber();
				total += single;
			}
		}
		return total;
	}


	
	//传入一个shoppingCart对象，返回对象中的所有DishItems对象
	public List<DishItem> getDishItems(ShoppingCart shoppingCart,String shopId)
	{
		if(null==shopId)
		{
			List<ShopItem> shopItems = shoppingCart.getShopItems();
			List<DishItem> dishItems = new ArrayList<DishItem>();
			for(ShopItem shopItem : shopItems)
			{
				for(DishItem dishItem : shopItem.getDishItems())
				{
					dishItems.add(dishItem);
				}
			}
			return dishItems;
		}
		else {
			return null;
		}
		
	}
	
	
	//add 2013年12月5日下午8:34:21--------------------------
	
	/**
	 * 从删除一个dish
	 * 只需要userId和dishId
	 */
	@Override
	public boolean removeOneDishItemByUserId(String userId, String dishId) {
		
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		//Dish dish = dishDao.findOneById(dishId);
		//如果shoppingCart尚不存在，返回false
		if(shoppingCart == null){
			return false;
		}
		for(ShopItem shopItem : shoppingCart.getShopItems()){
			for(DishItem dishItem : shopItem.getDishItems()){
				
				if(dishItem.getDishId().equals(dishId)){
					ArrayList<DishItem> dishItems = shopItem.getDishItems();
					ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
					shopItems.remove(shopItem);//先删除当前shopItem
					dishItems.remove(dishItem);//先删除当前dishItem
					//如果删除该dishItem后，dishItem空了的话，那么shopItem也不用重新添加
					if(dishItems.isEmpty()){
						shoppingCart.setShopItems(shopItems);
						//更新shoppingCart
						shoppingCart.setItemNum(shoppingCart.getItemNum()-dishItem.getNumber());
						shoppingCart.setPrice(shoppingCart.getPrice()-dishItem.getDishSum());
						shoppingCartDao.update(shoppingCart);
						return true;
					}else {
						shopItem.setDishItems(dishItems);
						shopItem.setSumPrice(shopItem.getSumPrice()-dishItem.getDishSum());
						shopItems.add(shopItem);
						//更新shoppingCart
						shoppingCart.setShopItems(shopItems);
						shoppingCart.setItemNum(shoppingCart.getItemNum()-dishItem.getNumber());
						shoppingCart.setPrice(shoppingCart.getPrice()-dishItem.getDishSum());
						shoppingCartDao.update(shoppingCart);
						return true;
					}					
				}
			}
		}
		return false;
	}


	/**
	 * 添加一个dish到购物车
	 * 只需要userId和dishId
	 */
	@Override
	public boolean addOneDishToCartByUserId(String userId, String dishId) {
		
		//判断shopId是否已经存在，判断dishItem是否已经存在，存在+1
		Dish dish = dishDao.findOneById(dishId);
		//先判断shoppingCart是否已经创建
		ShoppingCart shoppingCart;
		shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		
		//判断当前用户购物车是否为空
		if( shoppingCart != null){
			//遍历shopItem，判断目标shopId是否已经存在
			for(ShopItem shopItem : shoppingCart.getShopItems()){
				ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
				
				//如果shoppingCart中已经存在ShopItem
				if(shopItem.getShopId().equals(dish.getShopId())){
					//先从shopItems中删除当前shopItem
					shopItems.remove(shopItem);
					
					//遍历DishItem，判断dishId是否已经存在
					for(DishItem dishItem : shopItem.getDishItems()){
						ArrayList<DishItem> dishItems = shopItem.getDishItems();
						
						//如果shopItem中已经存在了dishId，则让dishItem数量加1
						if(dishItem.getDishId().equals(dishId)){
							//先从dishItems集合中删除当前dishItem
							dishItems.remove(dishItem);
							//让dishItem的number+1，dishSum加一个dish.getPrice()
							dishItem.setNumber(dishItem.getNumber()+1);
							dishItem.setDishSum(dishItem.getDishSum()+dish.getPrice());
							
							
							dishItems.add(dishItem);//重新把当前dishItem添加到原来dishItems中
							shopItem.setDishItems(dishItems);//重新给shopItem的dishItems赋值
							shopItem.setSumPrice(shopItem.getSumPrice()+dish.getPrice());//重新计算shopItem的sumPrice
							shopItems.add(shopItem);//重新把当前shopItem添加到原来shopItems中
							
							//key step
							shoppingCart.setShopItems(shopItems);//重新给shoppingCart的shopItem赋值
							shoppingCart.setItemNum(shoppingCart.getItemNum()+1);//总数量增加1
							shoppingCart.setPrice(shoppingCart.getPrice()+dish.getPrice());//更新shoppingCart的price
							shoppingCartDao.update(shoppingCart);
							return true;
							
						}			
					}
					//如果shopItem中还没有这个dishId，则新添加dishItem
					{
						ArrayList<DishItem> dishItems = shopItem.getDishItems();
						DishItem dishItem = new DishItem();
						dishItem.setDishId(dishId);
						dishItem.setDishName(dish.getName());
						dishItem.setDishPrice(dish.getPrice());//only one dish now
						dishItem.setDishSum(dish.getPrice());//only one dish now
						dishItem.setNumber(1);//only one dish now
						
						dishItems.add(dishItem);//添加新的dishItem						
						shopItem.setSumPrice(shopItem.getSumPrice()+dish.getPrice());//重新计算shopItem的sumPrice
						shopItem.setDishItems(dishItems);//重新设置shopItem中的DishItem						
						shopItems.add(shopItem);//重新把当前shopItem添加到原来shopItems中
						
						shoppingCart.setShopItems(shopItems);//重新给shoppingCart的shopItem赋值
						shoppingCart.setItemNum(shoppingCart.getItemNum()+1);//总数量增加1
						shoppingCart.setPrice(shoppingCart.getPrice()+dish.getPrice());//更新shoppingCart的Price
						shoppingCartDao.update(shoppingCart);
						return true;
					}					
				}
			}
			//如果shoppingCart中shopId还不存在，则新添加一个shopItem
			{				
				
				ShopItem shopItem = new ShopItem();
				DishItem dishItem = new DishItem();
				ArrayList<ShopItem> shopItems = shoppingCart.getShopItems();
				ArrayList<DishItem> dishItems = new ArrayList<DishItem>();
				
				dishItem.setDishId(dishId);
				dishItem.setDishName(dish.getName());
				dishItem.setDishPrice(dish.getPrice());
				dishItem.setNumber(1);
				dishItem.setDishSum(dish.getPrice());
				dishItems.add(dishItem);
				
				Shop shop = shopDao.findOneById(dish.getShopId());
				
				shopItem.setDishItems(dishItems);
				shopItem.setShopId(dish.getShopId());
				shopItem.setShopName(shop.getName());
				shopItem.setDeliveryCharge(shop.getDeliveryCharge());
				shopItem.setShopAffairTagIds(shop.getShopAffairTagIds());
				shopItem.setSumPrice(dish.getPrice());
				shopItems.add(shopItem);
				
				//key step,更新shoppingCart相关数据
				shoppingCart.setShopItems(shopItems);
				shoppingCart.setItemNum(shoppingCart.getItemNum()+1);
				shoppingCart.setPrice(shoppingCart.getPrice()+dish.getPrice());
				
				shoppingCartDao.update(shoppingCart);
				return true;
			}
			
			
		}else{
			
			//生成一个新的shoppingCart
			shoppingCart = new ShoppingCart();
			DishItem dishItem = new DishItem();
			ShopItem shopItem = new ShopItem();
			ArrayList<ShopItem> shopItems = new ArrayList<ShopItem>();
			ArrayList<DishItem> dishItems = new ArrayList<DishItem>();
			
			//new dishItem
			dishItem.setDishId(dishId);
			dishItem.setDishName(dish.getName());
			dishItem.setDishPrice(dish.getPrice());
			dishItem.setDishSum(dish.getPrice());//only one dish now	
			dishItem.setNumber(1);//only one dish now				
			dishItems.add(dishItem);
			
			//new shopItem
			Shop shop = shopDao.findOneById(dish.getShopId());

			shopItem.setDishItems(dishItems);
			shopItem.setShopId(dish.getShopId());
			shopItem.setShopName(shop.getName());
			shopItem.setDeliveryCharge(shop.getDeliveryCharge());
			shopItem.setShopAffairTagIds(shop.getShopAffairTagIds());
			shopItem.setSumPrice(dish.getPrice());//only one dish now		
			shopItems.add(shopItem);//
			
			//new shoppingCart
			shoppingCart.setItemNum(1);//only one dish now
			shoppingCart.setPrice(dish.getPrice());//only one dish now			
			shoppingCart.setShopItems(shopItems);
			shoppingCart.setUserId(userId);
			shoppingCart.setId(UUIDGenerator.generateUUID());
			
			//add new shoppingCart
			shoppingCartDao.add(shoppingCart);
			return true;
		}
	}
	
	
	//根据shoppingCart和相关信息生成Order
	@Override
	public List<Order> createNewOrders(String userId) {
		
		ShoppingCart shoppingCart = shoppingCartDao.findOneByParams(CriteriaWrapper.instance().is("userId", userId));
		
		List<Order> orders = new ArrayList<Order>();
		for(ShopItem shopItem : shoppingCart.getShopItems()){
			Order order = new Order();
			order.setAddress("");
			order.setCellphone("");
			order.setChargeType(ChargeType.NORMAL.ordinal());
			order.setDate(new Date());
			order.setDeliveryTime(new Date());
			order.setDescription("");
			order.setDishItems(shopItem.getDishItems());
			order.setOrderNo("");
			order.setPrice(shopItem.getSumPrice());
			order.setShopId(shopItem.getShopId());
			order.setShopName(shopItem.getShopName());
			order.setStatus(OrderStatus.PRE_CONFIRM.ordinal());
			order.setTelephone("");
			order.setUserId(userId);
			order.setUserRemark("");
			orders.add(order);
		}
		return orders;
	}

	/**
	 * 根据userId删除当前用户购物车，用于用户注销或者session失效的时候
	 */
	@Override
	public boolean removeShoppingCartByUserId(String userId) {
		if(userId != null){
			shoppingCartDao.deleteByParams(CriteriaWrapper.instance().is("userId", userId));
			return true;
		}
		return false;
	}

	@Override
	public boolean evaluateShoppingCart(String userId) {
		ShoppingCart cart = getShoppingCartByUserId(userId);
		
		for(ShopItem shopItem : cart.getShopItems()){
			if(shopItem.getSumPrice()<shopItem.getDeliveryCharge()){
				return false;
			}
		}
		
		return true;
	}



}
