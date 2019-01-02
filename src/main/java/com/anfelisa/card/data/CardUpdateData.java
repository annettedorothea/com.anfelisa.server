package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardUpdateData original = (ICardUpdateData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardUpdateData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
