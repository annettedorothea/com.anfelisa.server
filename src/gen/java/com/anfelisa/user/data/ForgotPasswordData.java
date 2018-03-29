package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;
import com.anfelisa.user.models.ILanguageModel;

@SuppressWarnings("all")
public class ForgotPasswordData implements IForgotPasswordData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String password;
	
	@NotNull
	private String language;
	

	private org.joda.time.DateTime systemTime;
	
	public ForgotPasswordData(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("password") String password,
		@JsonProperty("language") String language
,		@JsonProperty("uuid") String uuid
	) {
		this.username = username;
		this.email = email;
		this.name = name;
		this.prename = prename;
		this.password = password;
		this.language = language;
		this.uuid = uuid;
		
	}

	public ForgotPasswordData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ForgotPasswordData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ForgotPasswordData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ForgotPasswordData withName(String name) {
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
	public ForgotPasswordData withPrename(String prename) {
		this.prename = prename;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ForgotPasswordData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ForgotPasswordData withLanguage(String language) {
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
		return new ForgotPasswordPresentationalData(
			this.username,
			this.email,
			this.name,
			this.prename,
			this.password,
			this.language
		);
	}

}

/*       S.D.G.       */
