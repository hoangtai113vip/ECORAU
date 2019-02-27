package com.example.interceptor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@Data
@IdClass(GroupPermissionId.class)
public class GroupPermission implements Serializable{
	@Id
	private int groupId;
	@Id
	private int permissionId;
	public GroupPermission(int groupId, int permissionId) {
		super();
		this.groupId = groupId;
		this.permissionId = permissionId;
	}
	
	
	
}
