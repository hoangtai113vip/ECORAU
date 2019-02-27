package com.example.interceptor.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
public class Role implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int groupId;
	private String name;
	private Boolean isAdmin;
	
	public Role() {
	}

	
	


	public Role(int groupId, String name, Boolean isAdmin) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.isAdmin = isAdmin;
	}





	
	public int getRoleId() {
		return this.groupId;
	}

	public void setRoleId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	


	
	

	
	


}