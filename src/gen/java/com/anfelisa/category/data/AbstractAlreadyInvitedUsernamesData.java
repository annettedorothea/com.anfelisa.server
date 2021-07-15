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
import com.anfelisa.category.models.IAlreadyInvitedUsernamesModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractAlreadyInvitedUsernamesData extends AbstractData implements IAlreadyInvitedUsernamesData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractAlreadyInvitedUsernamesData.class);
	
	private String categoryId;
	
	private String userId;
	
	private java.util.List<String> invitedUsernames;
	

	public AbstractAlreadyInvitedUsernamesData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("invitedUsernames") java.util.List<String> invitedUsernames
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.userId = userId;
		this.invitedUsernames = invitedUsernames;
	}

	public AbstractAlreadyInvitedUsernamesData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IAlreadyInvitedUsernamesData withCategoryId(String categoryId) {
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
	public IAlreadyInvitedUsernamesData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getInvitedUsernames() {
		return this.invitedUsernames;
	}
	public void setInvitedUsernames(java.util.List<String> invitedUsernames) {
		this.invitedUsernames = invitedUsernames;
	}
	public IAlreadyInvitedUsernamesData withInvitedUsernames(java.util.List<String> invitedUsernames) {
		this.invitedUsernames = invitedUsernames;
		return this;
	}
	
	
	
	public IAlreadyInvitedUsernamesData deepCopy() {
		IAlreadyInvitedUsernamesData copy = new AlreadyInvitedUsernamesData(this.getUuid());
		copy.setCategoryId(this.getCategoryId());
		copy.setUserId(this.getUserId());
		List<String> invitedUsernamesCopy = new ArrayList<String>();
		for(String item: this.getInvitedUsernames()) {
			invitedUsernamesCopy.add(item);
		}
		copy.setInvitedUsernames(invitedUsernamesCopy);
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



