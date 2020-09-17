/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class RegisterUserPayload implements IRegisterUserPayload {
	
	private String password;
	
	private String username;
	
	private String email;
	
	private String language;
	
	public RegisterUserPayload() {
	}
	
	public RegisterUserPayload(com.anfelisa.user.models.IUserRegistrationModel data) {
		password = data.getPassword();
		username = data.getUsername();
		email = data.getEmail();
		language = data.getLanguage();
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	
}



/******* S.D.G. *******/



