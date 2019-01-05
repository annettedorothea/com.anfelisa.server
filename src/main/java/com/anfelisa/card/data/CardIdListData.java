package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardIdListData extends AbstractCardIdListData implements ICardIdListData {
	
	public CardIdListData(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardIdList,
			categoryId,
			userId,
			movedCards,
			uuid
		);
	}

	public CardIdListData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardIdListData original = (ICardIdListData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardIdListData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
