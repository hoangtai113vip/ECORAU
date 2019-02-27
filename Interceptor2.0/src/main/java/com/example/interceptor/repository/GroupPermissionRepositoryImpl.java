package com.example.interceptor.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupPermissionRepositoryImpl implements GroupPermissionRepository {
	@Autowired
	EntityManager em;
	@Override
	public Boolean checkPermission(List<Integer> groupIds, String featureName) {
		List<Integer> perIds = new ArrayList<Integer>();
		TypedQuery<Integer> queryPer = em.createQuery("select p.permissionId "
				+ " from Permission p where p.name=:name",Integer.class)
				.setParameter("name", featureName);
		Integer permissionId = queryPer.getSingleResult();
		for (Integer id : groupIds) {
			TypedQuery<Integer> query = em.createQuery("select gp.permissionId from GroupPermission gp"
					+ " where gp.groupId=:id ",Integer.class)
					.setParameter("id", id);
			List<Integer> permissionIds = query.getResultList();
			perIds.addAll(permissionIds);
		}
		for (Integer id : perIds) {
			if (id==permissionId) {
				
				return true;
			}
		}
		return false;
	}

}
