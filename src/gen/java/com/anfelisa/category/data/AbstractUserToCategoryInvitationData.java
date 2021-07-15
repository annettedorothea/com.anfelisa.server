/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IUserToCategoryInvitationModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractUserToCategoryInvitationData extends AbstractData implements IUserToCategoryInvitationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserToCategoryInvitationData.class);
	
	private String categoryId;
	
	private String userId;
	
	private String invitedUsername;
	
	private String invitedUserId;
	
	private com.anfelisa.box.models.IBoxModel boxForInvitedUser;
	

	public AbstractUserToCategoryInvitationData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("invitedUserId") String invitedUserId,
		@JsonProperty("boxForInvitedUser") com.anfelisa.box.models.IBoxModel boxForInvitedUser
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.userId = userId;
		this.invitedUsername = invitedUsername;
		this.invitedUserId = invitedUserId;
		this.boxForInvitedUser = boxForInvitedUser;
	}

	public AbstractUserToCategoryInvitationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IUserToCategoryInvitationData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUserToCategoryInvitationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	public void setInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
	}
	public IUserToCategoryInvitationData withInvitedUsername(String invitedUsername) {
		this.invitedUsername = invitedUsername;
		return this;
	}
	
	@JsonProperty
	public String getInvitedUserId() {
		return this.invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	public IUserToCategoryInvitationData withInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
		return this;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.IBoxModel getBoxForInvitedUser() {
		return this.boxForInvitedUser;
	}
	public void setBoxForInvitedUser(com.anfelisa.box.models.IBoxModel boxForInvitedUser) {
		this.boxForInvitedUser = boxForInvitedUser;
	}
	public IUserToCategoryInvitationData withBoxForInvitedUser(com.anfelisa.box.models.IBoxModel boxForInvitedUser) {
		this.boxForInvitedUser = boxForInvitedUser;
		return this;
	}
	
	
	
	public IUserToCategoryInvitationData deepCopy() {
		IUserToCategoryInvitationData copy = new UserToCategoryInvitationData(this.getUuid());
		copy.setCategoryId(this.getCategoryId());
		copy.setUserId(this.getUserId());
		copy.setInvitedUsername(this.getInvitedUsername());
		copy.setInvitedUserId(this.getInvitedUserId());
		copy.setBoxForInvitedUser(this.getBoxForInvitedUser().deepCopy());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



