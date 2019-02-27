package com.example.interceptor.service;

import java.util.List;

import com.example.interceptor.model.User;
import com.example.interceptor.model.ls.ListUserGroup;

public interface UserGroupService {
	List<Integer> findGroupIdByUser(User user);
	String addListUserGroup(ListUserGroup listUserGroup);
}
