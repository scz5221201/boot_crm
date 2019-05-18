package com.hzy.core.service;

import com.hzy.core.po.User;

public interface UserService {
	public User findUser(String usercode, String password);
}
