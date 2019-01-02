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
public abstract class AbstractUserData extends AbstractData implements IUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserData.class);
	
	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed = false;
	

	public AbstractUserData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
	}

	public AbstractUserData( String uuid ) {
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
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@JsonProperty
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	
}

/*       S.D.G.       */
