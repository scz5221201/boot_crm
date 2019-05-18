package com.hzy.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.core.dao.UserDao;
import com.hzy.core.po.User;
import com.hzy.core.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(String usercode, String password) {
		User user=this.userDao.findUser(usercode, password);
		return user;
	}

}
