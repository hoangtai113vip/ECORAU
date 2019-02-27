package com.example.interceptor.repository;

import java.util.List;

import com.example.interceptor.model.User;
import com.example.interceptor.model.UserGroup;

public interface UserGroupRepository {
	List<Integer> findGroupIDbyUser(User user);
	void addUserGroup(UserGroup userGroup);
	Boolean findUserGroupByUserIdGroupId(Integer userId, Integer groupId);

}
