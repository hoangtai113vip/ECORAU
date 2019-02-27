package com.example.interceptor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.interceptor.model.User;
import com.example.interceptor.model.UserGroup;

@Repository
public class UserGroupRepositoryImpl implements UserGroupRepository {

	@Autowired
	EntityManager em;
	@Override
	public List<Integer> findGroupIDbyUser(User user) {
		TypedQuery<Integer> query = em.createQuery("select ur.groupId from UserGroup ur"
									+ " where ur.userId=:userId	",Integer.class)
									.setParameter("userId", user.getUserId());
		List<Integer> lsUserId = query.getResultList();
		return lsUserId;
	}
	@Override
	public void addUserGroup(UserGroup userGroup) {
		em.merge(userGroup);
	
	}
	@Override
	public Boolean findUserGroupByUserIdGroupId(Integer userId, Integer groupId) {
		TypedQuery<UserGroup> query = em.createQuery("select ug from UserGroup ug"
				+ " where ug.userId=:userId and ug.groupId=:groupId	",UserGroup.class)
				.setParameter("userId", userId)
				.setParameter("groupId", groupId);
		UserGroup ug = query.getResultList().stream().findFirst().orElse(null);
		if (ug ==null) {
			return false;
			
		}
		return true;
	}

}
