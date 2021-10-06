/********************************************************************************
 * generated by de.acegen 1.6.0
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
public class ConfirmEmailPayload implements IConfirmEmailPayload {
	
	private String token;
	
	private String username;
	
	public ConfirmEmailPayload() {
	}
	
	public ConfirmEmailPayload(com.anfelisa.user.models.IConfirmEmailModel data) {
		token = data.getToken();
		username = data.getUsername();
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
}



/******* S.D.G. *******/



