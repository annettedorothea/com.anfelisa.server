/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.data;

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
public class InviteUserToCategoryPayload implements IInviteUserToCategoryPayload {
	
	private String categoryId;
	
	private String invitedUsername;
	
	public InviteUserToCategoryPayload() {
	}
	
	public InviteUserToCategoryPayload(com.anfelisa.category.models.IUserToCategoryInvitationModel data) {
		categoryId = data.getCategoryId();
		invitedUsername = data.getInvitedUsername();
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	
}



/******* S.D.G. *******/



