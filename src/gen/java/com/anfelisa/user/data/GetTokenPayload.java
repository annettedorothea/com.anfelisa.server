/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public class GetTokenPayload {
	
	private String username;
	
	private String password;
	
	public GetTokenPayload() {
	}
	
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	
}



/******* S.D.G. *******/



