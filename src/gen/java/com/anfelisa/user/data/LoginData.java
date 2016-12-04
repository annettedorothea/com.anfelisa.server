package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILoginLogModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("unused")
public class LoginData implements ILoginLogModel, ICredentialsModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer loginLogId;
	
	@NotNull
	private String username;
	
	@NotNull
	private org.joda.time.DateTime date;
	
	@NotNull
	private String role;
	

	
	

	public LoginData(
		@JsonProperty("loginLogId") Integer loginLogId,
		@JsonProperty("username") String username,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.loginLogId = loginLogId;
		this.username = username;
		this.date = date;
		this.role = role;
		this.uuid = uuid;
		this.schema = schema;
	}

	public LoginData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getLoginLogId() {
		return this.loginLogId;
	}
	public void setLoginLogId(Integer loginLogId) {
		this.loginLogId = loginLogId;
	}
	public LoginData withLoginLogId(Integer loginLogId) {
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
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LoginData withRole(String role) {
		this.role = role;
		return this;
	}
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
