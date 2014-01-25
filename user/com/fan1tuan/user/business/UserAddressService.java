package com.fan1tuan.user.business;

import java.util.ArrayList;

import com.fan1tuan.user.pojos.User;
import com.fan1tuan.user.pojos.UserAddress;

public interface UserAddressService {
	public boolean addAddresses(String userId, ArrayList<UserAddress> addresses);

	public boolean deleteAddresses(String userId, ArrayList<UserAddress> addresses);

	public boolean updateAddresses(String userId, ArrayList<UserAddress> addresses);

	public ArrayList<UserAddress> findAddresses(String UserId);
}
