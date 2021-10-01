/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IDeleteUserModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserData extends AbstractData implements IDeleteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserData.class);
	
	private String usernameToBeDeleted;
	
	private String username;
	
	private String userId;
	
	private String role;
	
	private java.util.List<String> boxIds;
	
	private java.util.List<String> rootCategoryIds;
	

	public AbstractDeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role,
		@JsonProperty("boxIds") java.util.List<String> boxIds,
		@JsonProperty("rootCategoryIds") java.util.List<String> rootCategoryIds
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.userId = userId;
		this.role = role;
		this.boxIds = boxIds;
		this.rootCategoryIds = rootCategoryIds;
	}

	public AbstractDeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsernameToBeDeleted() {
		return this.usernameToBeDeleted;
	}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	public IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IDeleteUserData withUsername(String username) {
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
	public IDeleteUserData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IDeleteUserData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<String> boxIds) {
		this.boxIds = boxIds;
	}
	public IDeleteUserData withBoxIds(java.util.List<String> boxIds) {
		this.boxIds = boxIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getRootCategoryIds() {
		return this.rootCategoryIds;
	}
	public void setRootCategoryIds(java.util.List<String> rootCategoryIds) {
		this.rootCategoryIds = rootCategoryIds;
	}
	public IDeleteUserData withRootCategoryIds(java.util.List<String> rootCategoryIds) {
		this.rootCategoryIds = rootCategoryIds;
		return this;
	}
	
	
	
	public IDeleteUserData deepCopy() {
		IDeleteUserData copy = new DeleteUserData(this.getUuid());
		copy.setUsernameToBeDeleted(this.getUsernameToBeDeleted());
		copy.setUsername(this.getUsername());
		copy.setUserId(this.getUserId());
		copy.setRole(this.getRole());
		List<String> boxIdsCopy = new ArrayList<String>();
		for(String item: this.getBoxIds()) {
			boxIdsCopy.add(item);
		}
		copy.setBoxIds(boxIdsCopy);
		List<String> rootCategoryIdsCopy = new ArrayList<String>();
		for(String item: this.getRootCategoryIds()) {
			rootCategoryIdsCopy.add(item);
		}
		copy.setRootCategoryIds(rootCategoryIdsCopy);
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



