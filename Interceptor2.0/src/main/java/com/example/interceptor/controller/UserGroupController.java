package com.example.interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptor.model.ls.ListUserGroup;
import com.example.interceptor.service.UserGroupService;

@RestController
@RequestMapping("/usergroup")
public class UserGroupController {
	@Autowired
	UserGroupService userGroupService;
	
	@PostMapping("")
	public String addListUserGroup(@RequestBody ListUserGroup ls)
	{
		return userGroupService.addListUserGroup(ls);
	}
	

}
