package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractUsernameData extends AbstractData implements IUsernameData {
	
	@NotNull
	private String username;
	

	public AbstractUsernameData(
		@JsonProperty("username") String username
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
	}

	public AbstractUsernameData( String uuid ) {
		super(uuid);
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
