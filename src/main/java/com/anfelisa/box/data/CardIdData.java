package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardIdData extends AbstractData implements ICardIdData {
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	

	public CardIdData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
	}

	public CardIdData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardIdData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public CardIdData withTestId(String testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	public CardIdData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardIdPresentationalData(
			this.cardId,
			this.testId,
			this.contentHash
		);
	}

}

/*       S.D.G.       */
