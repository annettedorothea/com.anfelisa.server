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
public abstract class AbstractUserRegistrationData extends AbstractData implements IUserRegistrationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserRegistrationData.class);
	
	@NotNull
	private String language;
	
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
	
	@NotNull
	private String token;
	

	public AbstractUserRegistrationData(
		@JsonProperty("language") String language,
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("token") String token
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.language = language;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.token = token;
	}

	public AbstractUserRegistrationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public IUserRegistrationData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUserRegistrationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IUserRegistrationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IUserRegistrationData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public IUserRegistrationData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IUserRegistrationData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	public IUserRegistrationData withEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IUserRegistrationData withToken(String token) {
		this.token = token;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IUserModel model) {
		this.userId = model.getUserId();
		this.username = model.getUsername();
		this.password = model.getPassword();
		this.email = model.getEmail();
		this.role = model.getRole();
		this.emailConfirmed = model.getEmailConfirmed();
	}
	public void mapFrom(com.anfelisa.user.models.IEmailConfirmationModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
}

/*       S.D.G.       */
