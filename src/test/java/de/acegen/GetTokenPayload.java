/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package de.acegen;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class GetTokenPayload {
	
	private String username;
	
	private String password;
	
	public GetTokenPayload(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
}



/******* S.D.G. *******/


