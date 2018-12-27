package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordData extends AbstractData implements IPasswordData {
	
	private String password;
	

	public PasswordData(
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.password = password;
	}

	public PasswordData( String uuid ) {
		super(uuid);
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
