package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameModel;

@SuppressWarnings("unused")
public class UsernameData implements IUsernameData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	@NotNull
	private String username;
	

	

	private org.joda.time.DateTime systemTime;
	
	private boolean replay;

	public UsernameData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.uuid = uuid;
		this.schema = schema;
	}

	public UsernameData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UsernameData withUsername(String username) {
		this.username = username;
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

	@JsonProperty
	public boolean isReplay() {
		return replay;
	}

	@JsonProperty
	public void setReplay(boolean replay) {
		this.replay = replay;
	}

}

/*       S.D.G.       */
