package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UsernameAvailablePresentationalData implements IUsernameAvailablePresentationalData {
	
	@NotNull
	private String username;
	
	private Boolean available = false;
	
	
	public UsernameAvailablePresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
	) {
		this.username = username;
		this.available = available;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UsernameAvailablePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public UsernameAvailablePresentationalData withAvailable(Boolean available) {
		this.available = available;
		return this;
	}
	
}

/*       S.D.G.       */
