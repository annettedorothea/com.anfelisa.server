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
public abstract class AbstractUsernameAvailableData extends AbstractData implements IUsernameAvailableData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUsernameAvailableData.class);
	
	@NotNull
	private String username;
	
	private Boolean available = false;
	

	public AbstractUsernameAvailableData(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.available = available;
	}

	public AbstractUsernameAvailableData( String uuid ) {
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
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	public void overwriteNotReplayableData(IDataContainer dataContainer) {
	}

}

/*       S.D.G.       */
