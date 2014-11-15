package com.fan1tuan.user.business.mongoImpl;

import java.util.ArrayList;

import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.user.business.UserDishService;
import com.fan1tuan.user.pojos.FavoriteDish;
import com.fan1tuan.user.pojos.User;

public class UserDishServiceImpl implements UserDishService {

	private UserDao userDao;
	
	@Override
	public boolean addFavoriteDishes(String userId,
			ArrayList<FavoriteDish> dishes) {
		if(dishes != null){
			userDao.updateFirstByParams(userId, UpdateWrapper.instance().addToSet("favoriteDishes", dishes));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteFavoriteDishes(String userId,
			ArrayList<FavoriteDish> dishes) {
		if(dishes != null){
			User user = userDao.findOneById(userId);
			if(user.getFavoriteDishes().removeAll(dishes)){
				return true;
			}		
		}
		return false;
	}

	@Override
	public boolean updateFavoriteDishes(String userId,
			ArrayList<FavoriteDish> dishes) {
		if(dishes != null){
			User user = userDao.findOneById(userId);
			user.setFavoriteDishes(dishes);
			userDao.update(user);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<FavoriteDish> findAllFavoriteDishes(String userId) {		
		return userDao.findOneById(userId).getFavoriteDishes();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
