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

@SuppressWarnings("unused")
public class FillBoxData implements IFillBoxData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	private Integer boxId;
	
	@NotNull
	private String credentialsUsername;
	
	@NotNull
	private String credentialsRole;
	
	private org.joda.time.DateTime now;
	

	private java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded;
	
	
	

	public FillBoxData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("now") org.joda.time.DateTime now
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxId = boxId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.now = now;
		this.uuid = uuid;
		this.schema = schema;
	}

	public FillBoxData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
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
	public java.util.List<com.anfelisa.box.models.ICardOfBoxModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

}

/*       S.D.G.       */
