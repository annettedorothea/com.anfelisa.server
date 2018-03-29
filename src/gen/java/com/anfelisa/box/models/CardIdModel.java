package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardIdModel implements ICardIdModel {

	@NotNull
	private Integer cardId;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	

	public CardIdModel(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash
	) {
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
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
