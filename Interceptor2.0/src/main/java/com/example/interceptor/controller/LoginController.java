package com.example.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptor.model.User;
import com.example.interceptor.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	UserService userService;
	@PostMapping("/login")
	public String login(@RequestBody User user)
	{
		return userService.checkUserByNamePassWord(user);
	}
	
}
