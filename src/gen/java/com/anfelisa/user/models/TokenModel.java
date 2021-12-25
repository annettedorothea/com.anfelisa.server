/********************************************************************************
 * generated by de.acegen
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
public class TokenModel implements ITokenModel {

	private String username;

	private String password;

	private String token;


	public TokenModel() {
	}

	public TokenModel(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("token") String token
	) {
		this.username = username;
		this.password = password;
		this.token = token;
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
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

	public ITokenModel deepCopy() {
		ITokenModel copy = new TokenModel();
		copy.setUsername(this.getUsername());
		copy.setPassword(this.getPassword());
		copy.setToken(this.getToken());
		return copy;
	}

}



/******* S.D.G. *******/



