package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardTranslationData extends AbstractCardTranslationData implements ICardTranslationData {

	public CardTranslationData(
			@JsonProperty("sourceValue") String sourceValue,
			@JsonProperty("targetValue") String targetValue,
			@JsonProperty("sourceLanguage") String sourceLanguage,
			@JsonProperty("targetLanguage") String targetLanguage,
			@JsonProperty("uuid") String uuid) {
		super(
				sourceValue,
				targetValue,
				sourceLanguage,
				targetLanguage,
				uuid);
	}

	public CardTranslationData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
