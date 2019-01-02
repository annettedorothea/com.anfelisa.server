package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardTranslationData extends AbstractCardTranslationData implements ICardTranslationData {
	
	public CardTranslationData(
		@JsonProperty("sourceValue") String sourceValue, 
		@JsonProperty("targetValue") String targetValue, 
		@JsonProperty("sourceLanguage") String sourceLanguage, 
		@JsonProperty("targetLanguage") String targetLanguage, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			sourceValue,
			targetValue,
			sourceLanguage,
			targetLanguage,
			uuid
		);
	}

	public CardTranslationData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardTranslationData original = (ICardTranslationData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardTranslationData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
