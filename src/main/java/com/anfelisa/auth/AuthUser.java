package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	public final static String ADMIN = "ADMIN";
	public final static String AUTHOR = "AUTHOR";
	public final static String STUDENT = "STUDENT";
	
	private String username;
	private String schema;
	private String password;
	private String role;
	
	public AuthUser(String username, String password, String role) {
		super();
		this.username = BasicCredentialsHelper.extractUsernameFromUserName(username);
		this.schema = BasicCredentialsHelper.extractSchemaFromUserName(username);
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

	public String getSchema() {
		return schema;
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

	
}
