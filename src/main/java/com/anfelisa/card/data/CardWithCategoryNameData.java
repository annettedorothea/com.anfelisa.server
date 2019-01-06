package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardWithCategoryNameData extends AbstractCardWithCategoryNameData implements ICardWithCategoryNameData {
	
	public CardWithCategoryNameData(
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("cardAuthor") String cardAuthor, 
		@JsonProperty("cardIndex") Integer cardIndex, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryName,
			cardId,
			given,
			wanted,
			image,
			cardAuthor,
			cardIndex,
			categoryId,
			rootCategoryId,
			uuid
		);
	}

	public CardWithCategoryNameData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardWithCategoryNameData original = (ICardWithCategoryNameData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardWithCategoryNameData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
