package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UsernameAvailableModel implements IUsernameAvailableModel {

	@NotNull
	private String username;
	
	private Boolean available = false;
	

	public UsernameAvailableModel(
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
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

}

/*       S.D.G.       */
