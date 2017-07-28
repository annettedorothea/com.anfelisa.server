package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	public final static String ADMIN = "ADMIN";
	public final static String AUTHOR = "AUTHOR";
	public final static String STUDENT = "STUDENT";

	private String username;
	private String password;
	private String role;
	private boolean premium;

	public AuthUser(String username, String password, String role, boolean premium) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.premium = premium;
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

	public boolean isAuthor() {
		return AUTHOR.equals(this.role);
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

	public boolean isPremium() {
		return premium;
	}
	
	

}
