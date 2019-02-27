package com.example.interceptor.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int userId;
	private String username;
	private String password;
	private Boolean isAdmin;
	private String accessToken;
	
}
