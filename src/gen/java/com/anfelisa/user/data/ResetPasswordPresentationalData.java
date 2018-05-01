package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ResetPasswordPresentationalData implements IResetPasswordPresentationalData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	private String password;
	
	
	public ResetPasswordPresentationalData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId,
		@JsonProperty("password") String password
	) {
		this.token = token;
		this.userId = userId;
		this.password = password;
		
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ResetPasswordPresentationalData withToken(String token) {
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
	public ResetPasswordPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ResetPasswordPresentationalData withPassword(String password) {
		this.password = password;
		return this;
	}
	
}

/*       S.D.G.       */
