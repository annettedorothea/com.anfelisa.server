package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardDeleteModel;

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
