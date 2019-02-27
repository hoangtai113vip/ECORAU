package com.example.interceptor.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interceptor.model.User;
import com.example.interceptor.model.UserGroup;
import com.example.interceptor.model.ls.ListUserGroup;
import com.example.interceptor.repository.UserGroupRepository;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	UserGroupRepository userGroupRepository;
	@Override
	public List<Integer> findGroupIdByUser(User user) {
		
		return userGroupRepository.findGroupIDbyUser(user);
	}
	@Override
	public String addListUserGroup(ListUserGroup listUserGroup) {
		
		List<Integer> usersId = listUserGroup.getUserIds();
		List<Integer> groupsId = listUserGroup.getGroupIds();
		List<UserGroup> lsUserGroup = new ArrayList<UserGroup>();
		for (Integer userId : usersId) {
			for (Integer groupId : groupsId) {
				if (userGroupRepository.findUserGroupByUserIdGroupId(userId, groupId) == true) {
					continue;
				}
				UserGroup userGroup = new UserGroup();

				userGroup.setUserId(userId);
				userGroup.setGroupId(groupId);
				
				lsUserGroup.add(userGroup);
			}

		}
		if (!lsUserGroup.isEmpty()) {
			for (UserGroup userGroup : lsUserGroup) {
				userGroupRepository.addUserGroup(userGroup);
				
			}
			return " thanh cong";
			
		}
	
		return " cac user tren da co quyen";
	}
	
	

}
