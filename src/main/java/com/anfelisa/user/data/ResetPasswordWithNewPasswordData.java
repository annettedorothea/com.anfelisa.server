package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordWithNewPasswordData extends AbstractData implements IResetPasswordWithNewPasswordData {
	
	@NotNull
	private String password;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public ResetPasswordWithNewPasswordData(
		@JsonProperty("password") String password,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.password = password;
		this.token = token;
		this.userId = userId;
	}

	public ResetPasswordWithNewPasswordData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

/*       S.D.G.       */
