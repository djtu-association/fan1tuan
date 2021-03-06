package com.fan1tuan.user.business.mongoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.DishCommentDao;
import com.fan1tuan.general.dao.impl.DishDao;
import com.fan1tuan.general.dao.impl.ShopDao;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.general.util.Constants.OrderType;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.ISession.LOG_TYPE;
import com.fan1tuan.order.business.OrderUserService;
import com.fan1tuan.shop.business.ShopUserService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishCommentDto;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.user.business.UserService;
import com.fan1tuan.user.pojos.FavoriteDish;
import com.fan1tuan.user.pojos.FavoriteShop;
import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.dto.FavoriteShopDto;
/**
 * 
 * @author JOE
 * tested
 * 2013年12月2日下午4:38:22
 * session通过参数的形式传到service
 */

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	private ShopDao shopDao;
	private DishDao dishDao;
	
	//service
	private ShopUserService shopUserService;
	private OrderUserService orderUserService;
	private DishCommentDao dishCommentDao;
	
	


	@Override
	public boolean register(User user) {
		if (user != null) {
			userDao.add(user);
			return true;
		}
		return false;

	}
	
	/**
	 * session参数要从action中传进来
	 */
	@Override
	public boolean login(User user,Map<String, Object> session,LOG_TYPE type){
		//登陆完了之后还要更新session，改变用户在线状态
		if (user != null) {
			User currentUser = userDao.findOneByParams(CriteriaWrapper.instance().is("password", user.getPassword()).is("cellphone", user.getCellphone()));
			if( currentUser != null){
				//先保证清空currentUser中的值
				if(session.get(ISession.USER) != null){
					logoff(session);
				}
				//更新session,保存当前登陆用户
				Map<String , Object> userMap = new HashMap<String, Object>();
				userMap.put(ISession.USER_ID, currentUser.getId());
				userMap.put(ISession.USER_NAME, currentUser.getUsername());
				userMap.put(ISession.USER_REALNAME, currentUser.getRealName());
				userMap.put(ISession.USER_EMAIL, currentUser.getEmail());
				userMap.put(ISession.USER_IMAGE, currentUser.getImage());
				userMap.put(ISession.USER_CELLPHONE, currentUser.getCellphone());
				userMap.put(ISession.USER_LEVEL, currentUser.getLevel());
				userMap.put(ISession.USER_CREDIT, currentUser.getCredit());
				userMap.put(ISession.USER_QQ, currentUser.getQq());
				session.put(ISession.USER, userMap);
				
				//更新session，保存当前登陆用户登陆状态
				Map<String, Object> loginStatus = new HashMap<String, Object>();
				loginStatus.put(ISession.LOGIN_TIME, new Date());//设置登陆成功时间
				loginStatus.put(ISession.LOGIN_TYPE, type);//设置登录后的type
				loginStatus.put(ISession.LOGIN_STATUS, ISession.LOG_STATUS.LOGIN);//设置登陆成功状态
				session.put(ISession.LOGIN, loginStatus);
				return true;//登陆成功
			}else{
				return false;//根据password和cellPhone找不到用户
			}
		}else{
			return false;//传入user为空
		}

	}

	@SuppressWarnings({ "unused" })
	@Override
	public boolean logoff(Map<String, Object> session) {
		//从session中判断当前用户是否登陆，然后清除session，flush页面
		if(!session.isEmpty() || session != null){
			//清除session
			session.remove(ISession.USER);
			//此处为注销当前用户，应该删除用户cookie
			//((HashMap<String, Object>)session.get(ISession.LOGIN)).put(ISession.LOGIN_STATUS, ISession.LOG_STATUS.LOGOUT);
			session.remove(ISession.LOGIN);
			return true;
		}
		return false;

	}

	@Override
	public boolean findPassword(User user) {
		// TODO Auto-generated method stub
		if(user != null){
			//这里需要的参数应该用户的“手机号”/“邮箱”
			return true;
		}
		return false;

	}

	@Override
	public boolean updatePassword(User user) {
		return updateUser(user);

	}

	@Override
	public boolean updatePhone(User user) {
		return updateUser(user);
		

	}
	
	@Override
	public boolean isAvailableCellphone(String cellphone) {
		if(userDao.findOneByParams(CriteriaWrapper.instance().is("cellphone", cellphone)) != null){
			return false;
		}
		return true;
	}
	
	public boolean updateUser(User user){
		if(user != null){
			userDao.update(user);//user对象已经设置了新的数据
			return false;//说明cellphone已经被使用
		}
		return true;//实名cellphone还没有被使用
	}
	
	
	@Override
	public boolean addFavouriteShops(String userId, String shopId) {
		//check isExist
		if(userDao.findOneByParams(CriteriaWrapper.instance().is("id", userId).is("favoriteShops.shopId", shopId)) != null){
			return false;//如果结果不为空，则说明此shopId早已添加进favoriteShops中
		}
		//add to DB
		FavoriteShop favoriteShop = new FavoriteShop();
		favoriteShop.setDate(new Date());
		favoriteShop.setShopId(shopId);
		favoriteShop.setStatus(1);
		try {
			userDao.updateFirstByParams(userId, UpdateWrapper.instance().addToSet("favoriteShops", favoriteShop));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean removeFavoriteShops(String userId, String shopId) {
		try {
			for(FavoriteShop favoriteShop : userDao.findOneById(userId).getFavoriteShops()){
				if(favoriteShop != null && favoriteShop.getShopId().equals(shopId))
				userDao.updateFirstByParams(userId, UpdateWrapper.instance().pull("favoriteShops", favoriteShop));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Shop> getFavoriteShops(String userId) {
		List<Shop> shops = new ArrayList<Shop>();
		try {
			for(FavoriteShop favoriteShop : userDao.findOneById(userId).getFavoriteShops()){
				shops.add(shopDao.findOneById(favoriteShop.getShopId()));
			}
			return shops;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addFavouriteDishes(String userId, String dishId) {
		//check isExist
		if(userDao.findOneByParams(CriteriaWrapper.instance().is("id", userId).is("favoriteShops.dishId", dishId)) != null){
			return false;//如果结果不为空，则说明此shopId早已添加进favoriteShops中
		}
		//add to DB
		FavoriteDish favoriteDish = new FavoriteDish();
		favoriteDish.setDate(new Date());
		favoriteDish.setDishId(dishId);
		favoriteDish.setStatus(1);
		try {
			userDao.updateFirstByParams(userId, UpdateWrapper.instance().addToSet("favoriteDishes", favoriteDish));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeFavoriteDishes(String userId, String dishId) {
		try {
			for(FavoriteDish favoriteDish : userDao.findOneById(userId).getFavoriteDishes()){
				if(favoriteDish != null && favoriteDish.getDishId().equals(dishId)){
					userDao.updateFirstByParams(userId, UpdateWrapper.instance().pull("favoriteDishes", favoriteDish));
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Dish> getFavoriteDishes(String userId) {
		List<Dish> dishes = new ArrayList<Dish>();
		try {
			for(FavoriteDish favoriteDish : userDao.findOneById(userId).getFavoriteDishes()){
				dishes.add(dishDao.findOneById(favoriteDish.getDishId()));
			}
			return dishes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Dish> getFavoriteInShop(String userId, String shopId) {
		List<Dish> dishes = new ArrayList<Dish>();
		Dish dish = null;
		try {
			for(FavoriteDish favoriteDish : userDao.findOneById(userId).getFavoriteDishes()){
				dish = dishDao.findOneById(favoriteDish.getDishId());
				if(dish.getShopId().equals(shopId)){
					dishes.add(dish);
				}
			}
			return dishes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	/**
	 * 是否用户收藏店铺
	 */
	@Override
	public boolean isLikeShop(String userId, String shopId) {
		List<FavoriteShop> favoriteShops = userDao.findOneById(userId).getFavoriteShops();
		if(favoriteShops != null){
			for(FavoriteShop favoriteShop : favoriteShops){
				if(favoriteShop.getShopId() != null && favoriteShop.getShopId().equals(shopId)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 是否用户收藏菜品
	 */
	@Override
	public boolean isLikeDish(String userId, String dishId) {
		List<FavoriteDish> favoriteDishs = userDao.findOneById(userId).getFavoriteDishes();
		if(favoriteDishs != null){
			for(FavoriteDish favoriteDish : favoriteDishs){
				if(favoriteDish.getDishId() != null && favoriteDish.getDishId().equals(dishId)){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public User getUser(String userId) {
		return userDao.findOneById(userId);
	}
	
	
	/**
	 * 必须要求传入areaId，因为推荐的店铺不应该超出当前的商圈
	 */
	@Override
	public List<FavoriteShopDto> getFavoriteShopDtos(String userId, String areaId) {		
		List<FavoriteShop> favoriteShops = userDao.findOneById(userId).getFavoriteShops();
		
		if(favoriteShops==null||favoriteShops.size()==0){
			return null;
		}
		
		List<FavoriteShopDto> favoriteShopDtos = new ArrayList<FavoriteShopDto>();
		
		for(FavoriteShop favoriteShop : favoriteShops){
			FavoriteShopDto favoriteShopDto = new FavoriteShopDto();
			
			Shop shop = shopDao.findOneProjectedById(favoriteShop.getShopId(), FieldFilter.instance("id","name","shopTasteTagIds","orderType","description","dishRecs","avatar"));
		
			favoriteShopDto.setDate(favoriteShop.getDate());
			favoriteShopDto.setOrderType(shop.getOrderType());
			favoriteShopDto.setShopId(favoriteShop.getShopId());
			favoriteShopDto.setShopName(shop.getName());
			favoriteShopDto.setShopAvatar(shop.getAvatar());

			favoriteShopDto.setFavoriteShopRecs(shopUserService.getFavoriteShopRecs(shop.getId(), areaId, Pageable.inPage(0, 3)));//3个
			favoriteShopDto.setShopTasteTags(shopUserService.getShopTasteTags(shop.getShopTasteTagIds()));

			favoriteShopDto.setShopRecDishes(shopUserService.getShopRecDishesInShop(shop.getDishRecs(), Pageable.inPage(0, 4)));
			
			if(shop.getOrderType()==OrderType.ONLINE.ordinal()){
				favoriteShopDto.setOnceBoughtDishes(orderUserService.getBoughtDishesInShopByUserId(userId, shop.getId(), Pageable.inPage(0, 4)));
				favoriteShopDto.setTopDishes(shopUserService.getTopSaleDishesInShop(shop.getId(), Pageable.inPage(0, 4)));
			}else{
				favoriteShopDto.setTopDishes(new ArrayList<Dish>());
			}
			
			favoriteShopDtos.add(favoriteShopDto);
			
		}
		
		return favoriteShopDtos;
	}

	/**
	 * <strong>方法用来获取用户的全部的评论</strong>
	 * @param userId 用户的Id
	 */
	@Override
	public List<DishComment> getAllUserComments(String userId, int pageNumber, int pageSize) {
		return dishCommentDao.findByParamsInPageInOrder(CriteriaWrapper.instance().is("userId", userId), Pageable.inPage(pageNumber, pageSize), Sortable.instance("date", Sortable.DESCEND));
	}	

	@Override
	public List<DishCommentDto> getAllUserCommentDtos(String userId,
			int pageNumber, int pageSize) {
		List<DishComment> dishComments = getAllUserComments(userId, pageNumber, pageSize);
		List<DishCommentDto> dishCommentDtos = new ArrayList<DishCommentDto>();
		
		for(DishComment dishComment : dishComments){
			DishCommentDto dishCommentDto = new DishCommentDto();
			dishCommentDto.setDishComment(dishComment);
			Dish dish = dishDao.findOneById(dishComment.getDishId());
			dishCommentDto.setDish(dish);
			dishCommentDtos.add(dishCommentDto);
		}
		
		return dishCommentDtos;
	}

	
	
	//-------------fileds getter and setter

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	public DishDao getDishDao() {
		return dishDao;
	}

	public OrderUserService getOrderUserService() {
		return orderUserService;
	}

	public void setOrderUserService(OrderUserService orderUserService) {
		this.orderUserService = orderUserService;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	

	public ShopDao getShopDao() {
		return shopDao;
	}
	public ShopUserService getShopUserService() {
		return shopUserService;
	}

	public void setShopUserService(ShopUserService shopUserService) {
		this.shopUserService = shopUserService;
	}
	
	

	public DishCommentDao getDishCommentDao() {
		return dishCommentDao;
	}

	public void setDishCommentDao(DishCommentDao dishCommentDao) {
		this.dishCommentDao = dishCommentDao;
	}

	
	
}
