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
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String password;
	


	public ForgotPasswordModel(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("password") String password
	) {
		this.username = username;
		this.email = email;
		this.name = name;
		this.prename = prename;
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
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getPrename() {
		return this.prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
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
