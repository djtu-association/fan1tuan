package com.fan1tuan.user.business.mongoImpl;

import java.util.ArrayList;

import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.UserDao;
import com.fan1tuan.user.business.UserAddressService;
import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.UserAddress;

public class UserAddressServiceImpl implements UserAddressService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addAddresses(String userId,
			ArrayList<UserAddress> addresses) {
		if(addresses != null)
		{
			userDao.updateFirstByParams(userId, UpdateWrapper.instance().addToSet("userAddress", addresses));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAddresses(String userId,
			ArrayList<UserAddress> addresses) {
		if(addresses != null){
			User user = userDao.findOneById(userId);
			user.getUserAddresses().removeAll(addresses);
			userDao.update(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAddresses(String userId,
			ArrayList<UserAddress> addresses) {
		if(addresses != null){
			User user = userDao.findOneById(userId);
			user.setUserAddresses(addresses);
			userDao.update(user);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<UserAddress> findAddresses(String userId) {	
		return userDao.findOneById(userId).getUserAddresses();
		
	}

}
