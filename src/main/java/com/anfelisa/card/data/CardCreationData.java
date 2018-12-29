package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardCreationData extends AbstractCardCreationData implements ICardCreationData {
	
	public CardCreationData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("username") String username, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("cardAuthor") String cardAuthor, 
		@JsonProperty("cardIndex") Integer cardIndex, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("path") String path, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			username,
			cardId,
			given,
			wanted,
			image,
			cardAuthor,
			cardIndex,
			categoryId,
			rootCategoryId,
			path,
			uuid
		);
	}

	public CardCreationData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
