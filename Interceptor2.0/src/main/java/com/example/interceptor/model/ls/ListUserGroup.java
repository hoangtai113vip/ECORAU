package com.example.interceptor.model.ls;

import java.util.List;

import lombok.Data;

@Data
public class ListUserGroup {
	List<Integer> userIds;
	List<Integer> groupIds;
}
