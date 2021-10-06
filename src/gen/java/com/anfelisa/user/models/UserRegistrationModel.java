/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UserRegistrationModel implements IUserRegistrationModel {

	private String language;

	private String userId;

	private String username;

	private String password;

	private String email;

	private String role;

	private Boolean emailConfirmed = false;

	private String token;


	public UserRegistrationModel() {
	}

	public UserRegistrationModel(
		@JsonProperty("language") String language,
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("token") String token
	) {
		this.language = language;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.token = token;
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

	public IUserRegistrationModel deepCopy() {
		IUserRegistrationModel copy = new UserRegistrationModel();
		copy.setLanguage(this.getLanguage());
		copy.setUserId(this.getUserId());
		copy.setUsername(this.getUsername());
		copy.setPassword(this.getPassword());
		copy.setEmail(this.getEmail());
		copy.setRole(this.getRole());
		copy.setEmailConfirmed(this.getEmailConfirmed());
		copy.setToken(this.getToken());
		return copy;
	}

}



/******* S.D.G. *******/



