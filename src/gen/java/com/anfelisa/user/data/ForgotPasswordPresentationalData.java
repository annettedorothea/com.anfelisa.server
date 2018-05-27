package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ForgotPasswordPresentationalData implements IForgotPasswordPresentationalData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String language;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	
	public ForgotPasswordPresentationalData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId,
		@JsonProperty("language") String language,
		@JsonProperty("email") String email,
		@JsonProperty("username") String username
	) {
		this.token = token;
		this.userId = userId;
		this.language = language;
		this.email = email;
		this.username = username;
		
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ForgotPasswordPresentationalData withToken(String token) {
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
	public ForgotPasswordPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ForgotPasswordPresentationalData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ForgotPasswordPresentationalData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ForgotPasswordPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */
