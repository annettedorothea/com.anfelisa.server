package com.anfelisa.box.data;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoveCardFromBoxData extends AbstractData implements IRemoveCardFromBoxData {
	
	private String scheduledCardId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	

	public RemoveCardFromBoxData(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.scheduledCardId = scheduledCardId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
	}

	public RemoveCardFromBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public RemoveCardFromBoxData withScheduledCardId(String scheduledCardId) {
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
	

	@Override
	public Object toPresentationalData() {
		return new RemoveCardFromBoxPresentationalData(
			this.scheduledCardId,
			this.credentialsUsername,
			this.credentialsRole
		);
	}

}

/*       S.D.G.       */
