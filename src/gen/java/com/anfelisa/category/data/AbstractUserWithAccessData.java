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
import com.anfelisa.category.models.IUserWithAccessModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractUserWithAccessData extends AbstractData implements IUserWithAccessData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserWithAccessData.class);
	
	private String userId;
	
	private String username;
	
	private Boolean editable = false;
	

	public AbstractUserWithAccessData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("editable") Boolean editable
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.username = username;
		this.editable = editable;
	}

	public AbstractUserWithAccessData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUserWithAccessData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IUserWithAccessData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IUserWithAccessData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	
	
	public IUserWithAccessData deepCopy() {
		IUserWithAccessData copy = new UserWithAccessData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setUsername(this.getUsername());
		copy.setEditable(this.getEditable());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



