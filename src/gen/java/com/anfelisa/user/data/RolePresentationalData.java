package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class RolePresentationalData implements IRolePresentationalData {
	
	private String username;
	
	private String role;
	
	
	public RolePresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
	) {
		this.username = username;
		this.role = role;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RolePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RolePresentationalData withRole(String role) {
		this.role = role;
		return this;
	}
	
}

/*       S.D.G.       */
