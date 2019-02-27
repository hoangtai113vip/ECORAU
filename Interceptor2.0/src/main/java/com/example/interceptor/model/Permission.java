package com.example.interceptor.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Permission {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int permissionId;
	private String name;

	
}
