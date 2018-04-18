package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginData extends AbstractData implements ILoginData {
	
	@NotNull
	private String loginLogId;
	
	@NotNull
	private String username;
	
	@NotNull
	private org.joda.time.DateTime date;
	

	public LoginData(
		@JsonProperty("loginLogId") String loginLogId,
		@JsonProperty("username") String username,
		@JsonProperty("date") org.joda.time.DateTime date
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.loginLogId = loginLogId;
		this.username = username;
		this.date = date;
	}

	public LoginData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getLoginLogId() {
		return this.loginLogId;
	}
	public void setLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
	}
	public LoginData withLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LoginData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	public LoginData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new LoginPresentationalData(
			this.loginLogId,
			this.username,
			this.date
		);
	}

}

/*       S.D.G.       */
