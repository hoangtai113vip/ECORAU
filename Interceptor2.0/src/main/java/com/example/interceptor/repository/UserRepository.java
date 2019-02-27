package com.example.interceptor.repository;

import com.example.interceptor.model.User;

public interface UserRepository {
	User findUserByAccessToken(String accessToken);
	User checkUserByNamePassWord(User user);
	void update(User user);
	void save(User user);
	User findUser(String name);
	Boolean checkIsAdmin(int id);

}
