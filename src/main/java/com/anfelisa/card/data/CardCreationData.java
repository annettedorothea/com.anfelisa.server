package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardCreationData original = (ICardCreationData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardCreationData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
