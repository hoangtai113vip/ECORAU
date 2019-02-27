package com.example.interceptor.service;

import java.util.List;

public interface GroupPermissionService {
	Boolean checkPermission(List<Integer> GroupIds,String featureName);
}
