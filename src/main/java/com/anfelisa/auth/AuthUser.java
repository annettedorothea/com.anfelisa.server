package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	public final static String SUPER_ADMIN = "SUPER_ADMIN";
	public final static String ADMIN = "ADMIN";
	public final static String TRAINER = "TRAINER";
	public final static String USER = "USER";
	
	private String email;
	private String mandator;
	private String password;
	private String role;
	
	public AuthUser(String username, String password, String role) {
		super();
		this.email = BasicCredentialsHelper.extractEmailFromUserName(username);
		this.mandator = BasicCredentialsHelper.extractMandatorFromUserName(username);
		this.password = password;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getMandator() {
		return mandator;
	}
	
	public boolean isUser() {
		return USER.equals(this.role);
	}

	public boolean isTrainer() {
		return TRAINER.equals(this.role);
	}
	
	public boolean isAdmin() {
		return ADMIN.equals(this.role);
	}
	
	public String getName() {
		return "AuthUser";
	}

	
}
