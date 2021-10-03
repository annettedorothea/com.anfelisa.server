/********************************************************************************
 * generated by de.acegen 1.5.6
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
import com.anfelisa.user.models.IConfirmEmailModel;
import com.anfelisa.user.models.IEmailConfirmationModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractConfirmEmailData extends AbstractData implements IConfirmEmailData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailData.class);
	
	private String username;
	
	private String token;
	
	private String userId;
	

	public AbstractConfirmEmailData(
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.token = token;
		this.userId = userId;
	}

	public AbstractConfirmEmailData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IConfirmEmailData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IConfirmEmailData withToken(String token) {
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
	public IConfirmEmailData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IEmailConfirmationModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
	
	public IConfirmEmailData deepCopy() {
		IConfirmEmailData copy = new ConfirmEmailData(this.getUuid());
		copy.setUsername(this.getUsername());
		copy.setToken(this.getToken());
		copy.setUserId(this.getUserId());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



