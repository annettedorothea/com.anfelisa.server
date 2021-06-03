/********************************************************************************
 * generated by de.acegen 1.2.1
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
import com.anfelisa.category.models.IUsernameSearchModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractUsernameSearchData extends AbstractData implements IUsernameSearchData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUsernameSearchData.class);
	
	private String usernameSearchString;
	
	private String userId;
	
	private String categoryId;
	
	private java.util.List<String> usernames;
	

	public AbstractUsernameSearchData(
		@JsonProperty("usernameSearchString") String usernameSearchString,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("usernames") java.util.List<String> usernames
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameSearchString = usernameSearchString;
		this.userId = userId;
		this.categoryId = categoryId;
		this.usernames = usernames;
	}

	public AbstractUsernameSearchData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsernameSearchString() {
		return this.usernameSearchString;
	}
	public void setUsernameSearchString(String usernameSearchString) {
		this.usernameSearchString = usernameSearchString;
	}
	public IUsernameSearchData withUsernameSearchString(String usernameSearchString) {
		this.usernameSearchString = usernameSearchString;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUsernameSearchData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IUsernameSearchData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getUsernames() {
		return this.usernames;
	}
	public void setUsernames(java.util.List<String> usernames) {
		this.usernames = usernames;
	}
	public IUsernameSearchData withUsernames(java.util.List<String> usernames) {
		this.usernames = usernames;
		return this;
	}
	
	
	
	public IUsernameSearchData deepCopy() {
		IUsernameSearchData copy = new UsernameSearchData(this.getUuid());
		copy.setUsernameSearchString(this.getUsernameSearchString());
		copy.setUserId(this.getUserId());
		copy.setCategoryId(this.getCategoryId());
		List<String> usernamesCopy = new ArrayList<String>();
		for(String item: this.getUsernames()) {
			usernamesCopy.add(item);
		}
		copy.setUsernames(usernamesCopy);
		return copy;
	}

}



/******* S.D.G. *******/



