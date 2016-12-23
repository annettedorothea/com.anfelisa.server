package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserUpdateModel implements IUserUpdateModel {

	@NotNull
	private String username;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String email;
	
	private String password;
	
	private String language;
	


	public UserUpdateModel(
		@JsonProperty("username") String username,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("password") String password,
		@JsonProperty("language") String language
	) {
		this.username = username;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.password = password;
		this.language = language;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	


}

/*       S.D.G.       */
