/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class GetInvitedUsersResponse {
	
	private java.util.List<com.anfelisa.category.models.UsernameEditableModel> invitedUsers;
	
	public GetInvitedUsersResponse() {
	}
	
	public GetInvitedUsersResponse(com.anfelisa.category.models.AlreadyInvitedUsernamesModel model) {
		invitedUsers = model.getInvitedUsers();
	}
	
	public java.util.List<com.anfelisa.category.models.UsernameEditableModel> getInvitedUsers() {
		return this.invitedUsers;
	}
	
	
	
}



/******* S.D.G. *******/



