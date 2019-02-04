package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IInviteUserModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractInviteUserData extends AbstractData implements IInviteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractInviteUserData.class);
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	
	@NotNull
	private String invitedUserId;
	
	@NotNull
	private String invitedUsername;
	
	private String userId;
	

	public AbstractInviteUserData(
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

	public AbstractInviteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IInviteUserData withCategoryId(String categoryId) {
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
	public IInviteUserData withRootCategoryId(String rootCategoryId) {
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
	public IInviteUserData withInvitedUserId(String invitedUserId) {
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
	public IInviteUserData withInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IInviteUserData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IInviteUserModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		if (!(this.getInvitedUserId() == null && other.getInvitedUserId() == null) && !this.getInvitedUserId().equals(other.getInvitedUserId())) {
			differingAttributes.add("invitedUserId: " + this.getInvitedUserId() + " " + other.getInvitedUserId());
		}
		if (!(this.getInvitedUsername() == null && other.getInvitedUsername() == null) && !this.getInvitedUsername().equals(other.getInvitedUsername())) {
			differingAttributes.add("invitedUsername: " + this.getInvitedUsername() + " " + other.getInvitedUsername());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
