package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserData extends AbstractData implements IDeleteUserData {
	
	@NotNull
	private String usernameToBeDeleted;
	
	@NotNull
	private String username;
	
	@NotNull
	private String role;
	

	public AbstractDeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.role = role;
	}

	public AbstractDeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsernameToBeDeleted() {
		return this.usernameToBeDeleted;
	}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

/*       S.D.G.       */
