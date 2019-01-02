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
public abstract class AbstractRoleData extends AbstractData implements IRoleData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractRoleData.class);
	
	private String username;
	
	private String role;
	

	public AbstractRoleData(
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.role = role;
	}

	public AbstractRoleData( String uuid ) {
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
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}

/*       S.D.G.       */
