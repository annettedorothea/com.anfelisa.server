package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FillBoxData extends AbstractData implements IFillBoxData {
	
	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public FillBoxData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("cardsToBeAdded") java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.cardsToBeAdded = cardsToBeAdded;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public FillBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public FillBoxData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	public FillBoxData withCardsToBeAdded(java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
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
	

	@Override
	public Object toPresentationalData() {
		return new FillBoxPresentationalData(
			this.boxId,
			this.cardsToBeAdded,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
