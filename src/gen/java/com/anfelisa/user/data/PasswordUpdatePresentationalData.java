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
public class PasswordUpdatePresentationalData implements IPasswordUpdatePresentationalData {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	
	public PasswordUpdatePresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password
	) {
		this.username = username;
		this.password = password;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public PasswordUpdatePresentationalData withUsername(String username) {
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
	public PasswordUpdatePresentationalData withPassword(String password) {
		this.password = password;
		return this;
	}
	
}

/*       S.D.G.       */
