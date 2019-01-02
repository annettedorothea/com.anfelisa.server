package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardDeleteData extends AbstractCardDeleteData implements ICardDeleteData {
	
	public CardDeleteData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("cardIndex") Integer cardIndex, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			cardIndex,
			categoryId,
			userId,
			uuid
		);
	}

	public CardDeleteData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardDeleteData original = (ICardDeleteData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardDeleteData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
