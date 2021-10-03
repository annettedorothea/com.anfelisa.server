/********************************************************************************
 * generated by de.acegen 1.5.4
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
import com.anfelisa.user.models.ITokenModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractTokenData extends AbstractData implements ITokenData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractTokenData.class);
	
	private String username;
	
	private String password;
	
	private String token;
	

	public AbstractTokenData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("token") String token
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public AbstractTokenData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ITokenData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ITokenData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ITokenData withToken(String token) {
		this.token = token;
		return this;
	}
	
	
	
	public ITokenData deepCopy() {
		ITokenData copy = new TokenData(this.getUuid());
		copy.setUsername(this.getUsername());
		copy.setPassword(this.getPassword());
		copy.setToken(this.getToken());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



