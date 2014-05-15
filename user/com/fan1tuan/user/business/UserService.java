package com.fan1tuan.user.business;



import java.util.List;
import java.util.Map;

import com.fan1tuan.general.util.ISession.LOG_TYPE;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.DishComment;
import com.fan1tuan.shop.pojos.DishCommentDto;
import com.fan1tuan.shop.pojos.Shop;
import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.dto.FavoriteShopDto;

public interface UserService {
	
	public User getUser(String userId);
	
	public boolean register(User user);

	public boolean login(User user,Map<String, Object> session,LOG_TYPE type);
	
	public boolean logoff(Map<String, Object> session);

	//店铺收藏
	public boolean addFavouriteShops(String userId,String shopId);
	public boolean removeFavoriteShops(String userId,String shopId);
	public List<Shop> getFavoriteShops(String userId);
	public List<FavoriteShopDto> getFavoriteShopDtos(String userId, String areaId);
	//菜品
	public boolean addFavouriteDishes(String userId,String dishId);
	public boolean removeFavoriteDishes(String userId,String dishId);
	public List<Dish> getFavoriteDishes(String userId);
	//查找一个店铺中，用户收藏的菜品
	public List<Dish> getFavoriteInShop(String userId,String shopId);
	
	//获取单个用户的全部comment
	public List<DishComment> getAllUserComments(String userId,int pageNumber, int pageSize);
	public List<DishCommentDto> getAllUserCommentDtos(String userId, int pageNumber, int pageSize);
	
	public boolean findPassword(User user);
	
	public boolean updatePassword(User user);
	
	public boolean updatePhone(User user);
	
	//如果cellphone已经被使用返回false，否则返回true
	public boolean isAvailableCellphone(String cellphone);
	
	
	//是否是用户收藏的店铺shop，是返回true
	public boolean isLikeShop(String userId,String shopId);
	//是否是用户收藏的菜品dish，是返回true
	public boolean isLikeDish(String userId,String dishId);
}
