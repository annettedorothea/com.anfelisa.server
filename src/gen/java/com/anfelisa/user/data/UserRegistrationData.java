package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.ILanguageModel;

@SuppressWarnings("all")
public class UserRegistrationData implements IUserRegistrationData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed;
	
	@NotNull
	private String language;
	

	private org.joda.time.DateTime systemTime;
	
	public UserRegistrationData(
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("language") String language
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.language = language;
		this.uuid = uuid;
		
	}

	public UserRegistrationData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserRegistrationData withUsername(String username) {
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
	public UserRegistrationData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRegistrationData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getPrename() {
		return this.prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public UserRegistrationData withPrename(String prename) {
		this.prename = prename;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRegistrationData withEmail(String email) {
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
	public UserRegistrationData withRole(String role) {
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
	public UserRegistrationData withEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public UserRegistrationData withLanguage(String language) {
		this.language = language;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new UserRegistrationPresentationalData(
			this.username,
			this.password,
			this.name,
			this.prename,
			this.email,
			this.role,
			this.emailConfirmed,
			this.language
		);
	}

}

/*       S.D.G.       */
