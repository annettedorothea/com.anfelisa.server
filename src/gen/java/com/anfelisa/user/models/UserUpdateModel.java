package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserUpdateModel implements IUserUpdateModel {

	@NotNull
	private String username;
	
	@NotNull
	private String email;
	

	public UserUpdateModel(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email
	) {
		this.username = username;
		this.email = email;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

/*       S.D.G.       */
