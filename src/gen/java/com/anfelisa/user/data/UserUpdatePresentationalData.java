package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserUpdateModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class UserUpdatePresentationalData implements IUserUpdatePresentationalData {
	
	@NotNull
	private String username;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String email;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public UserUpdatePresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.username = username;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserUpdatePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserUpdatePresentationalData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getPrename() {
		return this.prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public UserUpdatePresentationalData withPrename(String prename) {
		this.prename = prename;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserUpdatePresentationalData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public UserUpdatePresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public UserUpdatePresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
