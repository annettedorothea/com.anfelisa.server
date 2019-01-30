package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractEmailConfirmationData extends AbstractData implements IEmailConfirmationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractEmailConfirmationData.class);
	
	@NotNull
	private String token;
	
	@NotNull
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
	
	
}

/*       S.D.G.       */
