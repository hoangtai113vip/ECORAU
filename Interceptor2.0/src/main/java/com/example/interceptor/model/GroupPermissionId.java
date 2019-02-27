package com.example.interceptor.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class GroupPermissionId implements Serializable{
	private int groupId;
	private int permissionId;

}
