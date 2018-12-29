package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardUpdateData extends AbstractCardUpdateData implements ICardUpdateData {
	
	public CardUpdateData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			given,
			wanted,
			image,
			userId,
			uuid
		);
	}

	public CardUpdateData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
