package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDeleteData extends AbstractCardDeleteData implements ICardDeleteData {

	public CardDeleteData(
			@JsonProperty("cardId") String cardId,
			@JsonProperty("cardIndex") Integer cardIndex,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(
				cardId,
				cardIndex,
				categoryId,
				userId,
				uuid);
	}

	public CardDeleteData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
