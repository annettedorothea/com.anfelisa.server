package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardListData extends AbstractCardListData implements ICardListData {
	
	public CardListData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			cardList,
			categoryId,
			uuid
		);
	}

	public CardListData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardListData original = (ICardListData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardListData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
