package com.anfelisa.auth;

import java.util.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class AceAuthenticator implements Authenticator<BasicCredentials, AuthUser> {

	public Optional<AuthUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if (BasicCredentialsHelper.isSuperAdmin(credentials)) {
			return Optional
					.of(new AuthUser(credentials.getUsername(), credentials.getPassword(), AuthUser.SUPER_ADMIN));
		} else {
			/*String schema = BasicCredentialsHelper.extractMandatorFromUserName(credentials);
			String email = BasicCredentialsHelper.extractEmailFromUserName(credentials);
			User user = UserDao.selectUser(DatabaseService.getDatabaseHandle().getHandle(), schema, email);
			if (user != null && user.getPassword().equals(credentials.getPassword())) {
				return Optional.of(new AuthUser(credentials.getUsername(), credentials.getPassword(), user.getRole()));
			} else {
				return Optional.empty();
			}*/
			return Optional.empty();
		}
	}
}
