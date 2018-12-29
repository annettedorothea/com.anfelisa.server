package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractPasswordData extends AbstractData implements IPasswordData {
	
	private String password;
	

	public AbstractPasswordData(
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.password = password;
	}

	public AbstractPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

/*       S.D.G.       */
