package com.example.interceptor.repository;

import java.util.List;

public interface GroupPermissionRepository {
	Boolean checkPermission(List<Integer> groupIds, String featureName);

}
