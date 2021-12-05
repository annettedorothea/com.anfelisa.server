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
public class UserToCategoryInvitationModel implements IUserToCategoryInvitationModel {

	private String categoryId;

	private String userId;

	private String invitedUsername;

	private String invitedUserId;

	private com.anfelisa.box.models.IBoxModel boxForInvitedUser;


	public UserToCategoryInvitationModel() {
	}

	public UserToCategoryInvitationModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("boxForInvitedUser") com.anfelisa.box.models.IBoxModel boxForInvitedUser
	) {
		this.categoryId = categoryId;
		this.userId = userId;
		this.invitedUsername = invitedUsername;
		this.invitedUserId = invitedUserId;
		this.boxForInvitedUser = boxForInvitedUser;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	
	@JsonProperty
	public String getInvitedUserId() {
		return this.invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.IBoxModel getBoxForInvitedUser() {
		return this.boxForInvitedUser;
	}
	public void setBoxForInvitedUser(com.anfelisa.box.models.IBoxModel boxForInvitedUser) {
		this.boxForInvitedUser = boxForInvitedUser;
	}
	

	public IUserToCategoryInvitationModel deepCopy() {
		IUserToCategoryInvitationModel copy = new UserToCategoryInvitationModel();
		copy.setCategoryId(this.getCategoryId());
		copy.setUserId(this.getUserId());
		copy.setInvitedUsername(this.getInvitedUsername());
		copy.setInvitedUserId(this.getInvitedUserId());
		if (this.getBoxForInvitedUser() != null) {
			copy.setBoxForInvitedUser(this.getBoxForInvitedUser().deepCopy());
		}
		return copy;
	}

}



/******* S.D.G. *******/



