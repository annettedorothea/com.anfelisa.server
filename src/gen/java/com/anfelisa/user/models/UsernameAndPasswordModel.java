package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UsernameAndPasswordModel implements IUsernameAndPasswordModel {

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	


	public UsernameAndPasswordModel(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password
	) {
		this.username = username;
		this.password = password;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
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
