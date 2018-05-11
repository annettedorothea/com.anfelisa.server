package com.anfelisa.user.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UsernameModel implements IUsernameModel {

	@NotNull
	private String username;
	

	public UsernameModel(
		@JsonProperty("username") String username
	) {
		this.username = username;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

/*       S.D.G.       */
