package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractEmailData extends AbstractData implements IEmailData {
	
	@NotNull
	private String email;
	

	public AbstractEmailData(
		@JsonProperty("email") String email
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.email = email;
	}

	public AbstractEmailData( String uuid ) {
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
