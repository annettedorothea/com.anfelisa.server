package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardData extends AbstractCardData implements ICardData {

	public CardData(
			@JsonProperty("cardId") String cardId,
			@JsonProperty("given") String given,
			@JsonProperty("wanted") String wanted,
			@JsonProperty("image") String image,
			@JsonProperty("cardAuthor") String cardAuthor,
			@JsonProperty("cardIndex") Integer cardIndex,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("rootCategoryId") String rootCategoryId,
			@JsonProperty("uuid") String uuid) {
		super(
				cardId,
				given,
				wanted,
				image,
				cardAuthor,
				cardIndex,
				categoryId,
				rootCategoryId,
				uuid);
	}

	public CardData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
