package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class RemoveCardFromBoxPresentationalData implements IRemoveCardFromBoxPresentationalData {
	
	private String scheduledCardId;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	
	public RemoveCardFromBoxPresentationalData(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole
	) {
		this.scheduledCardId = scheduledCardId;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public RemoveCardFromBoxPresentationalData withScheduledCardId(String scheduledCardId) {
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
	public RemoveCardFromBoxPresentationalData withCredentialsUsername(String credentialsUsername) {
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
	public RemoveCardFromBoxPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
}

/*       S.D.G.       */
