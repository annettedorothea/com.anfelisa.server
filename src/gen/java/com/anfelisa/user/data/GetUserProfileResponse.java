/********************************************************************************
 * generated by de.acegen 1.3.0
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
public class GetUserProfileResponse implements IGetUserProfileResponse {
	
	private String email;
	
	private String username;
	
	private String userId;
	
	public GetUserProfileResponse() {
	}
	
	public GetUserProfileResponse(com.anfelisa.user.models.IUserModel data) {
		email = data.getEmail();
		username = data.getUsername();
		userId = data.getUserId();
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	
}



/******* S.D.G. *******/



