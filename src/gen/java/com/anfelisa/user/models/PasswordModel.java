package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class PasswordModel implements IPasswordModel {

	private String password;
	

	public PasswordModel(
		@JsonProperty("password") String password
	) {
		this.password = password;
	}

	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

/*       S.D.G.       */
