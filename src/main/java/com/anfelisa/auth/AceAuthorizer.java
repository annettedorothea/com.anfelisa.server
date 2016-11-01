package com.anfelisa.auth;

import io.dropwizard.auth.Authorizer;

public class AceAuthorizer implements Authorizer<AuthUser> {

	public boolean authorize(AuthUser user, String role) {
		return user.getRole().equals(role);
	}
}