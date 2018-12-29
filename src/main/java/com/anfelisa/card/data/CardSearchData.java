package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardSearchData extends AbstractCardSearchData implements ICardSearchData {
	
	public CardSearchData(
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList, 
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

}

/*       S.D.G.       */
