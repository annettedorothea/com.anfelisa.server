package com.anfelisa.card.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardDeleteModel implements ICardDeleteModel {

	@NotNull
	private String cardId;
	

	public CardDeleteModel(
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
	

}

/*       S.D.G.       */
