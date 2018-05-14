package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

public class CardDeleteData extends AbstractData implements ICardDeleteData {
	
	@NotNull
	private String cardId;
	

	public CardDeleteData(
		@JsonProperty("cardId") String cardId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
	}

	public CardDeleteData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardDeleteData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardDeletePresentationalData(
			this.cardId
		);
	}

}

/*       S.D.G.       */
