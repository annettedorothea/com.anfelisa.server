package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractUserWithAccessData extends AbstractData implements IUserWithAccessData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	

	public AbstractUserWithAccessData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.username = username;
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
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}

/*       S.D.G.       */
