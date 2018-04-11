package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IDeleteUserModel;

@SuppressWarnings("all")
public class DeleteUserData implements IDeleteUserData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	@NotNull
	private String deletedUsername;
	

	private org.joda.time.DateTime systemTime;
	
	public DeleteUserData(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("deletedUsername") String deletedUsername
,		@JsonProperty("uuid") String uuid
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.deletedUsername = deletedUsername;
		this.uuid = uuid;
		
	}

	public DeleteUserData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public DeleteUserData withCredentialsUsername(String credentialsUsername) {
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
	public DeleteUserData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public String getDeletedUsername() {
		return this.deletedUsername;
	}
	public void setDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
	}
	public DeleteUserData withDeletedUsername(String deletedUsername) {
		this.deletedUsername = deletedUsername;
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
		return new DeleteUserPresentationalData(
			this.credentialsUsername,
			this.credentialsRole,
			this.deletedUsername
		);
	}

}

/*       S.D.G.       */
