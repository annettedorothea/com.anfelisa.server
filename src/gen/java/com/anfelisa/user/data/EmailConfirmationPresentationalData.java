package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class EmailConfirmationPresentationalData implements IEmailConfirmationPresentationalData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	
	public EmailConfirmationPresentationalData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.token = token;
		this.userId = userId;
		
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public EmailConfirmationPresentationalData withToken(String token) {
		this.token = token;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public EmailConfirmationPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
