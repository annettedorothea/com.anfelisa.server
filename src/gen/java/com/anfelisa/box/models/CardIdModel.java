package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardIdModel implements ICardIdModel {

	@NotNull
	private String cardId;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	

	public CardIdModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash
	) {
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	

}

/*       S.D.G.       */
