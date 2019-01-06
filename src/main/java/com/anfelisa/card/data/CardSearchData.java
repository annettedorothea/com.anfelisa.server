package com.anfelisa.card.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardSearchData extends AbstractCardSearchData implements ICardSearchData {
	
	public CardSearchData(
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList, 
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			given,
			wanted,
			categoryId,
			cardList,
			naturalInputOrder,
			uuid
		);
	}

	public CardSearchData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICardSearchData original = (ICardSearchData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICardSearchData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
