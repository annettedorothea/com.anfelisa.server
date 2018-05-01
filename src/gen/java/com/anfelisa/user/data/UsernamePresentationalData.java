package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UsernamePresentationalData implements IUsernamePresentationalData {
	
	@NotNull
	private String username;
	
	
	public UsernamePresentationalData(
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
	public UsernamePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */
