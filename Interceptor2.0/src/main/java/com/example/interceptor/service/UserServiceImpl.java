package com.example.interceptor.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interceptor.model.User;
import com.example.interceptor.repository.UserRepository;
import com.example.interceptor.util.TokenGenerator;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	
	// xem user co phai admin ko
	public Boolean checkIsAdmin(User user) {
		
		return userRepository.checkIsAdmin(user.getUserId());
	}

	@Override
	@Transactional
	// get user by accessToken
	public User findUserbyAccessToken(String accessToken) {

		return userRepository.findUserByAccessToken(accessToken);
	}

	@Override
	@Transactional
	//login dang nhap
	public String checkUserByNamePassWord(User user) {
		// TODO Auto-generated method stub
		User userData = userRepository.checkUserByNamePassWord(user);
		if (userData == null) {
			return "login that bai";

		}
		TokenGenerator token = new TokenGenerator();
		String accessToken = token.generateToken(user.getUsername());
		userData.setAccessToken(accessToken);
		userRepository.update(userData);
		return accessToken;
		
	

	}

	@Override
	@Transactional
	public String save(User user) {
		User userData = userRepository.findUser(user.getUsername());
		if (userData==null) {
			userRepository.save(user);
			return "dang ky thanh cong";
			
		}
		return "tai khoan da ton tai";
	}

}
