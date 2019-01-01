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
public abstract class AbstractConfirmEmailData extends AbstractData implements IConfirmEmailData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailData.class);
	
	private String username;
	
	@NotNull
	private String token;
	
	@NotNull
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
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		if (dataContainer != null) {
			try {
				IConfirmEmailData original = (IConfirmEmailData)dataContainer;
				token = original.getToken();
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IConfirmEmailData for overwriting not replayable attributes", x);
			}
		}
	}

}

/*       S.D.G.       */
