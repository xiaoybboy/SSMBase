package com.xiaoyb.service;

import com.xiaoyb.domain.User;

public interface UserService {
	public User getUserById(int id);

	public User findUserByLoginName(String username);
}
