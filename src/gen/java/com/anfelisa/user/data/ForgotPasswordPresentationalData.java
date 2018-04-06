package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;
import com.anfelisa.user.models.ILanguageModel;

@SuppressWarnings("all")
public class ForgotPasswordPresentationalData implements IForgotPasswordPresentationalData {
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String language;
	
	
	public ForgotPasswordPresentationalData(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("password") String password,
		@JsonProperty("language") String language
	) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.language = language;
		
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ForgotPasswordPresentationalData withUsername(String username) {
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
	public ForgotPasswordPresentationalData withEmail(String email) {
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
	public ForgotPasswordPresentationalData withPassword(String password) {
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
	public ForgotPasswordPresentationalData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
}

/*       S.D.G.       */