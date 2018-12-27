package com.anfelisa.category.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InviteUserData extends AbstractData implements IInviteUserData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	
	@NotNull
	private String invitedUserId;
	
	//@NotNull
	//private String username;
	
	@NotNull
	private String invitedUsername;
	
	@NotNull
	private String userId;
	

	public InviteUserData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.invitedUserId = invitedUserId;
		this.invitedUsername = invitedUsername;
		this.userId = userId;
	}

	public InviteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public InviteUserData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public InviteUserData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getInvitedUserId() {
		return this.invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	public InviteUserData withInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
		return this;
	}
	
	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public InviteUserData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

}

/*       S.D.G.       */
