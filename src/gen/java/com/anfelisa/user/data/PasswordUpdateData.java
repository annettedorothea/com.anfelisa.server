package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IUserPasswordUpdateModel;

@SuppressWarnings("all")
public class PasswordUpdateData implements IPasswordUpdateData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String editedUsername;
	
	@NotNull
	private String newPassword;
	

	private org.joda.time.DateTime systemTime;
	
	public PasswordUpdateData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("editedUsername") String editedUsername,
		@JsonProperty("newPassword") String newPassword
,		@JsonProperty("uuid") String uuid
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.editedUsername = editedUsername;
		this.newPassword = newPassword;
		this.uuid = uuid;
		
	}

	public PasswordUpdateData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public PasswordUpdateData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public PasswordUpdateData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getEditedUsername() {
		return this.editedUsername;
	}
	public void setEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
	}
	public PasswordUpdateData withEditedUsername(String editedUsername) {
		this.editedUsername = editedUsername;
		return this;
	}
	
	@JsonProperty
	public String getNewPassword() {
		return this.newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public PasswordUpdateData withNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
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
		return new PasswordUpdatePresentationalData(
			this.credentialsUsername,
			this.credentialsRole,
			this.editedUsername,
			this.newPassword
		);
	}

}

/*       S.D.G.       */
