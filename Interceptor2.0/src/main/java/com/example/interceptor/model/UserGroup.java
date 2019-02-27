package com.example.interceptor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@Data
@IdClass(UserGroup.class)
public class UserGroup implements Serializable{
	
	@Id
	private int userId;
	@Id
	private int groupId;
	
	public UserGroup(int userId, int groupId) {
		super();
		this.userId = userId;
		this.groupId = groupId;
	}
	public UserGroup() {
	}
	
}
