package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailConfirmationData extends AbstractData implements IEmailConfirmationData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	

	public EmailConfirmationData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
		this.username = username;
	}

	public EmailConfirmationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public EmailConfirmationData withToken(String token) {
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
	public EmailConfirmationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public EmailConfirmationData withUsername(String username) {
		this.username = username;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new EmailConfirmationPresentationalData(
			this.token,
			this.userId,
			this.username
		);
	}

}

/*       S.D.G.       */
