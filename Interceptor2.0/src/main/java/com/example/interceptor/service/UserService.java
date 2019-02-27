package com.example.interceptor.service;

import org.springframework.stereotype.Service;

import com.example.interceptor.model.User;


public interface UserService  {
	Boolean checkIsAdmin(User user);
	User findUserbyAccessToken(String accessToken);
	String checkUserByNamePassWord(User user);
	String save(User user);
	

}
