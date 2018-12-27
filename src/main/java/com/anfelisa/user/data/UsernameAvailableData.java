package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameAvailableData extends AbstractData implements IUsernameAvailableData {
	
	@NotNull
	private String username;
	
	private Boolean available = false;
	

	public UsernameAvailableData(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.available = available;
	}

	public UsernameAvailableData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UsernameAvailableData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public UsernameAvailableData withAvailable(Boolean available) {
		this.available = available;
		return this;
	}
	

}

/*       S.D.G.       */
