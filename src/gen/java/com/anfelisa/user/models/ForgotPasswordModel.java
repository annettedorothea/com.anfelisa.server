package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ForgotPasswordModel implements IForgotPasswordModel {

	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	

	public ForgotPasswordModel(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("password") String password
	) {
		this.username = username;
		this.email = email;
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
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
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
