/********************************************************************************
 * generated by de.acegen 1.0.2
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
public class ChangeUserRolePayload implements IChangeUserRolePayload {
	
	private String newRole;
	
	private String editedUserId;
	
	public ChangeUserRolePayload() {
	}
	
	public ChangeUserRolePayload(com.anfelisa.user.models.IChangeUserRoleModel data) {
		newRole = data.getNewRole();
		editedUserId = data.getEditedUserId();
	}
	
	@JsonProperty
	public String getNewRole() {
		return this.newRole;
	}
	
	@JsonProperty
	public String getEditedUserId() {
		return this.editedUserId;
	}
	
}



/******* S.D.G. *******/



