package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserModel implements IUserModel {

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed;
	


	public UserModel(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed
	) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
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
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@JsonProperty
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	


}

/*       S.D.G.       */
