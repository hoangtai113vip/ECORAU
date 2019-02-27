package com.example.interceptor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interceptor.repository.GroupPermissionRepository;

@Service
@Transactional
public class GroupPermissionServiceImpl implements GroupPermissionService{
	@Autowired
	GroupPermissionRepository groupPermissionRepository;
	@Override
	public Boolean checkPermission(List<Integer> groupIds, String featureName) {
		
		return groupPermissionRepository.checkPermission(groupIds, featureName) ;
	}

}
