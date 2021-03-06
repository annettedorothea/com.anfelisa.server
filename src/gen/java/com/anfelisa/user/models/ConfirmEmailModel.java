/********************************************************************************
 * generated by de.acegen 1.1.0
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
public class ConfirmEmailModel implements IConfirmEmailModel {

	private String username;

	private String token;

	private String userId;


	public ConfirmEmailModel() {
	}

	public ConfirmEmailModel(
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.username = username;
		this.token = token;
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
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}



/******* S.D.G. *******/



