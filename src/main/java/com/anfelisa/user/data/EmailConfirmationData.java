package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailConfirmationData extends AbstractData implements IEmailConfirmationData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public EmailConfirmationData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
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
	

	@Override
	public Object toPresentationalData() {
		return new EmailConfirmationPresentationalData(
			this.token,
			this.userId
		);
	}

}

/*       S.D.G.       */
