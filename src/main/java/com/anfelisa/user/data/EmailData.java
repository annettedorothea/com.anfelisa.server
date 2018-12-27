package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailData extends AbstractData implements IEmailData {
	
	@NotNull
	private String email;
	

	public EmailData(
		@JsonProperty("email") String email
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.email = email;
	}

	public EmailData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

/*       S.D.G.       */
