package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameData extends AbstractData implements IUsernameData {
	
	@NotNull
	private String username;
	

	public UsernameData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
	}

	public UsernameData( String uuid ) {
		super(uuid);
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
	

}

/*       S.D.G.       */
