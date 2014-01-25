package com.fan1tuan.user.business.mongoImpl;

import java.util.ArrayList;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.user.business.UserShopService;
import com.fan1tuan.user.pojos.FavoriteShop;
import com.fan1tuan.user.pojos.User;

public class UserShopServiceImpl implements UserShopService {
	
	private UserDao userDao;

	@Override
	public boolean addFavoriteShops(String userId, ArrayList<FavoriteShop> shops) {
		if(shops != null){
			userDao.updateFirstByParams(userId, UpdateWrapper.instance().addToSet("favoriteShops", shops));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFavoriteShops(String userId,
			ArrayList<FavoriteShop> shops) {
		if(shops != null){
			User user = userDao.findOneById(userId);
			user.getFavoriteShops().removeAll(shops);
			userDao.update(user);
			return true;
		}	
		return false;
	}

	@Override
	public boolean updateFavoriteShops(String userId,
			ArrayList<FavoriteShop> shops) {
		if(shops != null){
			User user = userDao.findOneById(userId);
			user.setFavoriteShops(shops);
			userDao.update(user);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<FavoriteShop> findFavoriteShops(String userId) {		
		return userDao.findOneById(userId).getFavoriteShops();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
