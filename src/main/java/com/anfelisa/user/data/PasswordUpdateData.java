package com.anfelisa.user.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordUpdateData extends AbstractData implements IPasswordUpdateData {
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public PasswordUpdateData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public PasswordUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public PasswordUpdateData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public PasswordUpdateData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new PasswordUpdatePresentationalData(
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
