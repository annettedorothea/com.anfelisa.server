package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordData extends AbstractData implements IResetPasswordData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	private String password;
	

	public ResetPasswordData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId,
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
		this.password = password;
	}

	public ResetPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ResetPasswordData withToken(String token) {
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
	public ResetPasswordData withUserId(String userId) {
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
	public ResetPasswordData withPassword(String password) {
		this.password = password;
		return this;
	}
	

}

/*       S.D.G.       */
