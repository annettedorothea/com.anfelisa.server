package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgotPasswordData extends AbstractData implements IForgotPasswordData {
	
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
	

	public ForgotPasswordData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId,
		@JsonProperty("language") String language,
		@JsonProperty("email") String email,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
		this.language = language;
		this.email = email;
		this.username = username;
	}

	public ForgotPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ForgotPasswordData withToken(String token) {
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
	public ForgotPasswordData withUserId(String userId) {
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
	public ForgotPasswordData withLanguage(String language) {
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
	public ForgotPasswordData withEmail(String email) {
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
	public ForgotPasswordData withUsername(String username) {
		this.username = username;
		return this;
	}
	
}

/*       S.D.G.       */
