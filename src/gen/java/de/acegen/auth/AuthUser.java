/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package de.acegen.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	private String userId;
	
	private String username;
	
	private String role;
	

	public AuthUser (
		String userId,
		String username,
		String role
	) {
		this.userId = userId;
		this.username = username;
		this.role = role;
	}

	public String getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getName() {
		return "AuthUser";
	}
}



/******* S.D.G. *******/



