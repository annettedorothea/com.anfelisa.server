package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	public final static String ADMIN = "ADMIN";
	public final static String STUDENT = "STUDENT";

	private String userId;
	private String username;
	private String password;
	private String role;

	public AuthUser(String userId, String username, String password, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAdmin() {
		return ADMIN.equals(this.role);
	}

	public boolean isStudent() {
		return STUDENT.equals(this.role);
	}
	
	public String getName() {
		return "AuthUser";
	}

	public String getUserId() {
		return userId;
	}
	
}
