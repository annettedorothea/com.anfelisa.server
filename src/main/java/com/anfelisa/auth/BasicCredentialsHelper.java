package com.anfelisa.auth;

import io.dropwizard.auth.basic.BasicCredentials;

public class BasicCredentialsHelper {

	public static String extractUsernameFromUserName(BasicCredentials credentials) {
		return BasicCredentialsHelper.extractUsernameFromUserName(credentials.getUsername());
	}

	public static String extractUsernameFromUserName(String username) {
		return username.substring(username.indexOf('_') + 1);
	}

	public static String extractSchemaFromUserName(BasicCredentials credentials) {
		return BasicCredentialsHelper.extractSchemaFromUserName(credentials.getUsername());
	}

	public static String extractSchemaFromUserName(String username) {
		if (username.indexOf('_') > 0) {
			return username.substring(0, username.indexOf('_'));
		} else {
			return username;
		}
	}

}
