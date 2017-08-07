package com.xiaoyb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyb.dao.UserDao;
import com.xiaoyb.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

	public User findUserByLoginName(String username) {
		System.out.println("findUserByLoginName call!");
		return userDao.findUserByLoginName(username);
	}

}
