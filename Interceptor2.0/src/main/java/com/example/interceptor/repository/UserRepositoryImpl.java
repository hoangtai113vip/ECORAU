package com.example.interceptor.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.interceptor.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	EntityManager em;

	@Override
	public User findUserByAccessToken(String accessToken) {

		TypedQuery<User> query = em.createQuery(" select u from User u where u.accessToken=:accessToken", User.class)
				.setParameter("accessToken", accessToken);
		User user = query.getResultList().stream().findFirst().orElse(null);
		return user;
	}

	@Override
	public User checkUserByNamePassWord(User user) {
		TypedQuery<User> query = em
				.createQuery("select u from User u where u.username=:username" + " and u.password=:password",
						User.class)
				.setParameter("username", user.getUsername()).setParameter("password", user.getPassword());
		User UserData = query.getResultList().stream().findFirst().orElse(null);
		return UserData;

	}

	@Override
	public void update(User user) {
		em.persist(user);

	}

	@Override
	public void save(User user) {
		em.merge(user);

	}

	@Override
	public User findUser(String name) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.username=:username", User.class)
				.setParameter("username", name);

		User UserData = query.getResultList().stream().findFirst().orElse(null);
		return UserData;
	}

	@Override
	public Boolean checkIsAdmin(int id) {
		TypedQuery<Boolean> query = em.createQuery("select r.isAdmin from UserGroup ug"
				+ " Join Role r On ug.groupId = r.groupId where ug.userId =:id",
						Boolean.class)
				.setParameter("id",id);
		List<Boolean> ls = query.getResultList();
		for (Boolean boolean1 : ls) {
			if (boolean1==true) {
				return true;
				
			}
			
		}
		return false;
	}
}
