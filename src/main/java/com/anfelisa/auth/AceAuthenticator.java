package com.anfelisa.auth;

import java.util.Optional;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class AceAuthenticator implements Authenticator<BasicCredentials, AuthUser> {

	private Jdbi jdbi;

	private UserDao userDao = new UserDao();

	public AceAuthenticator(Jdbi jdbi) {
		super();
		this.jdbi = jdbi;
	}

	public Optional<AuthUser> authenticate(BasicCredentials credentials) throws AuthenticationException {
		String username = credentials.getUsername();
		Handle handle = this.jdbi.open();
		try {
			IUserModel user = userDao.selectByUsername(handle, username);
			if (user != null && user.getPassword().equals(credentials.getPassword()) && user.getEmailConfirmed()) {
				return Optional.of(new AuthUser(user.getUserId(), credentials.getUsername(), credentials.getPassword(), user.getRole()));
			} else {
				return Optional.empty();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			handle.close();
		}
	}
}
