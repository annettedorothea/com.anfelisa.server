package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardDeletePresentationalData implements ICardDeletePresentationalData {
	
	@NotNull
	private String cardId;
	
	
	public CardDeletePresentationalData(
		@JsonProperty("cardId") String cardId
	) {
		this.cardId = cardId;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardDeletePresentationalData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
}

/*       S.D.G.       */
