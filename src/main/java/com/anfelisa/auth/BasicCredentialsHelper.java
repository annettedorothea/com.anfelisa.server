package com.anfelisa.auth;

import io.dropwizard.auth.basic.BasicCredentials;

public class BasicCredentialsHelper {

	public static boolean isSuperAdmin(BasicCredentials credentials) {
		return (credentials.getUsername().equals("super-admin") && credentials.getPassword().equals("sprueche3:16"));
	}

	public static String extractEmailFromUserName(BasicCredentials credentials) {
		return BasicCredentialsHelper.extractEmailFromUserName(credentials.getUsername());
	}

	public static String extractEmailFromUserName(String username) {
		return username.substring(username.indexOf('_') + 1);
	}

	public static String extractMandatorFromUserName(BasicCredentials credentials) {
		return BasicCredentialsHelper.extractMandatorFromUserName(credentials.getUsername());
	}

	public static String extractMandatorFromUserName(String username) {
		if (username.indexOf('_') > 0) {
			return username.substring(0, username.indexOf('_'));
		} else {
			return username;
		}
	}

}
