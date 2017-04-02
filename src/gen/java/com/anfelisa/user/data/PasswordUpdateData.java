package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameAndPasswordModel;

@SuppressWarnings("all")
public class PasswordUpdateData implements IPasswordUpdateData {
	
	private String uuid;
	
	private String createdId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	

	
	private org.joda.time.DateTime systemTime;
	
	public PasswordUpdateData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.password = password;
		this.uuid = uuid;
	}

	public PasswordUpdateData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public PasswordUpdateData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PasswordUpdateData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

}

/*       S.D.G.       */
