/********************************************************************************
 * generated by de.acegen 1.3.0
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
import com.anfelisa.user.models.IEmailConfirmationModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractEmailConfirmationData extends AbstractData implements IEmailConfirmationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractEmailConfirmationData.class);
	
	private String token;
	
	private String userId;
	

	public AbstractEmailConfirmationData(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.token = token;
		this.userId = userId;
	}

	public AbstractEmailConfirmationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IEmailConfirmationData withToken(String token) {
		this.token = token;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IEmailConfirmationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public IEmailConfirmationData deepCopy() {
		IEmailConfirmationData copy = new EmailConfirmationData(this.getUuid());
		copy.setToken(this.getToken());
		copy.setUserId(this.getUserId());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



