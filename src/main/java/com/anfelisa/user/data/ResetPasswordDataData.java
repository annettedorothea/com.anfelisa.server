package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordDataData extends AbstractData implements IResetPasswordWithNewPasswordData {
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String password;
	

	public ResetPasswordDataData(
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

	public ResetPasswordDataData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

/*       S.D.G.       */
