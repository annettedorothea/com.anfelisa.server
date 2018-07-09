package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IInviteUserModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class InviteUserPresentationalData implements IInviteUserPresentationalData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String invitedUserId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String userId;
	
	
	public InviteUserPresentationalData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("username") String username,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.invitedUserId = invitedUserId;
		this.username = username;
		this.userId = userId;
		
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public InviteUserPresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getInvitedUserId() {
		return this.invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	public InviteUserPresentationalData withInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public InviteUserPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public InviteUserPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
