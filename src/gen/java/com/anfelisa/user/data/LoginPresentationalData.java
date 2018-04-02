package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILoginLogModel;
import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("all")
public class LoginPresentationalData implements ILoginPresentationalData {
	
	@NotNull
	private String loginLogId;
	
	@NotNull
	private String username;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	
	public LoginPresentationalData(
		@JsonProperty("loginLogId") String loginLogId,
		@JsonProperty("username") String username,
		@JsonProperty("date") org.joda.time.DateTime date
	) {
		this.loginLogId = loginLogId;
		this.username = username;
		this.date = date;
		
	}

	@JsonProperty
	public String getLoginLogId() {
		return this.loginLogId;
	}
	public void setLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
	}
	public LoginPresentationalData withLoginLogId(String loginLogId) {
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
	public LoginPresentationalData withUsername(String username) {
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
	public LoginPresentationalData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	
}

/*       S.D.G.       */
