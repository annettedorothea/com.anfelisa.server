/********************************************************************************
 * generated by de.acegen
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
public class GetTokenPayload implements IGetTokenPayload {
	
	private String username;
	
	private String password;
	
	public GetTokenPayload() {
	}
	
	public GetTokenPayload(com.anfelisa.user.models.ITokenModel data) {
		username = data.getUsername();
		password = data.getPassword();
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


