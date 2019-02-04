package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IDeleteUserModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserData extends AbstractData implements IDeleteUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserData.class);
	
	@NotNull
	private String usernameToBeDeleted;
	
	@NotNull
	private String username;
	
	@NotNull
	private String role;
	

	public AbstractDeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.usernameToBeDeleted = usernameToBeDeleted;
		this.username = username;
		this.role = role;
	}

	public AbstractDeleteUserData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsernameToBeDeleted() {
		return this.usernameToBeDeleted;
	}
	public void setUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
	}
	public IDeleteUserData withUsernameToBeDeleted(String usernameToBeDeleted) {
		this.usernameToBeDeleted = usernameToBeDeleted;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IDeleteUserData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IDeleteUserData withRole(String role) {
		this.role = role;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IDeleteUserModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUsernameToBeDeleted() == null && other.getUsernameToBeDeleted() == null) && !this.getUsernameToBeDeleted().equals(other.getUsernameToBeDeleted())) {
			differingAttributes.add("usernameToBeDeleted: " + this.getUsernameToBeDeleted() + " " + other.getUsernameToBeDeleted());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		if (!(this.getRole() == null && other.getRole() == null) && !this.getRole().equals(other.getRole())) {
			differingAttributes.add("role: " + this.getRole() + " " + other.getRole());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
