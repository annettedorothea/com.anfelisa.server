package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.box.models.INowModel;

@SuppressWarnings("all")
public class FillBoxData implements IFillBoxData {
	
	private String uuid;
	
	private String createdId;
	
	private Integer boxId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	private Boolean credentialsPremium;
	
	private org.joda.time.DateTime now;
	

	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded;
	
	
	
	private org.joda.time.DateTime systemTime;
	
	public FillBoxData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("credentialsPremium") Boolean credentialsPremium,
		@JsonProperty("now") org.joda.time.DateTime now
,		@JsonProperty("uuid") String uuid
	) {
		this.boxId = boxId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.credentialsPremium = credentialsPremium;
		this.now = now;
		this.uuid = uuid;
	}

	public FillBoxData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public FillBoxData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public FillBoxData withCredentialsUsername(String credentialsUsername) {
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
	public FillBoxData withCredentialsRole(String credentialsRole) {
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
	public FillBoxData withCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNow() {
		return this.now;
	}
	public void setNow(org.joda.time.DateTime now) {
		this.now = now;
	}
	public FillBoxData withNow(org.joda.time.DateTime now) {
		this.now = now;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
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
