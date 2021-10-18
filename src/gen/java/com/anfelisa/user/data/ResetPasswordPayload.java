/********************************************************************************
 * generated by de.acegen 1.6.4
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
public class ResetPasswordPayload implements IResetPasswordPayload {
	
	private String password;
	
	private String token;
	
	public ResetPasswordPayload() {
	}
	
	public ResetPasswordPayload(com.anfelisa.user.models.IResetPasswordWithNewPasswordModel data) {
		password = data.getPassword();
		token = data.getToken();
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	
}



/******* S.D.G. *******/



