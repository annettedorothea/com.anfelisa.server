package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardIdModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("all")
public class RemoveCardFromBoxData implements IRemoveCardFromBoxData {
	
	private String uuid;
	
	private String createdId;
	
	private Integer scheduledCardId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	private Boolean credentialsPremium;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public RemoveCardFromBoxData(
		@JsonProperty("scheduledCardId") Integer scheduledCardId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("credentialsPremium") Boolean credentialsPremium
,		@JsonProperty("uuid") String uuid
	) {
		this.scheduledCardId = scheduledCardId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.credentialsPremium = credentialsPremium;
		this.uuid = uuid;
	}

	public RemoveCardFromBoxData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public RemoveCardFromBoxData withScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public RemoveCardFromBoxData withCredentialsUsername(String credentialsUsername) {
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
	public RemoveCardFromBoxData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public Boolean getCredentialsPremium() {
		return this.credentialsPremium;
	}
	public void setCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
	}
	public RemoveCardFromBoxData withCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
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

}

/*       S.D.G.       */
