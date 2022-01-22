/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UsernameEditableModel implements IUsernameEditableModel {

	private String invitedUsername;

	private Boolean editable = false;


	public UsernameEditableModel() {
	}

	public UsernameEditableModel(
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("editable") Boolean editable
	) {
		this.invitedUsername = invitedUsername;
		this.editable = editable;
	}

	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	

	public IUsernameEditableModel deepCopy() {
		IUsernameEditableModel copy = new UsernameEditableModel();
		copy.setInvitedUsername(this.getInvitedUsername());
		copy.setEditable(this.getEditable());
		return copy;
	}

}



/******* S.D.G. *******/



