package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgotPasswordData extends AbstractData implements IForgotPasswordData {
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String language;
	

	public ForgotPasswordData(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("password") String password,
		@JsonProperty("language") String language
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.email = email;
		this.password = password;
		this.language = language;
	}

	public ForgotPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ForgotPasswordData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ForgotPasswordData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ForgotPasswordData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ForgotPasswordData withLanguage(String language) {
		this.language = language;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ForgotPasswordPresentationalData(
			this.username,
			this.email,
			this.password,
			this.language
		);
	}

}

/*       S.D.G.       */
