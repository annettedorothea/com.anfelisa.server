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
public class LoginData implements ILoginData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String loginLogId;
	
	@NotNull
	private String username;
	
	@NotNull
	private org.joda.time.DateTime date;
	

	private org.joda.time.DateTime systemTime;
	
	public LoginData(
		@JsonProperty("loginLogId") String loginLogId,
		@JsonProperty("username") String username,
		@JsonProperty("date") org.joda.time.DateTime date
,		@JsonProperty("uuid") String uuid
	) {
		this.loginLogId = loginLogId;
		this.username = username;
		this.date = date;
		this.uuid = uuid;
		
	}

	public LoginData( String uuid ) {
		this.uuid = uuid;
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
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
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
