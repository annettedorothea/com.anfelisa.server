package com.anfelisa.auth;

import java.util.Optional;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class AceAuthenticator implements Authenticator<BasicCredentials, AuthUser> {

	public Optional<AuthUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
		String schema = BasicCredentialsHelper.extractSchemaFromUserName(credentials);
		String username = BasicCredentialsHelper.extractUsernameFromUserName(credentials);
		IUserModel user = UserDao.selectByUsername(DatabaseService.getDatabaseHandle().getHandle(), username, schema);
		if (user != null && user.getPassword().equals(credentials.getPassword())) {
			return Optional.of(new AuthUser(credentials.getUsername(), credentials.getPassword(), user.getRole()));
		} else {
			return Optional.empty();
		}
	}
}
