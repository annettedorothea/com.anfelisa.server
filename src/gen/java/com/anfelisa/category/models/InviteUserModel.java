package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class InviteUserModel implements IInviteUserModel {

	@NotNull
	private String categoryId;
	
	@NotNull
	private String invitedUserId;
	
	@NotNull
	private String username;
	

	public InviteUserModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("username") String username
	) {
		this.categoryId = categoryId;
		this.invitedUserId = invitedUserId;
		this.username = username;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getInvitedUserId() {
		return this.invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

/*       S.D.G.       */
