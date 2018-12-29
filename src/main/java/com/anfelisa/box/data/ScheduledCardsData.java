package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledCardsData extends AbstractScheduledCardsData implements IScheduledCardsData {
	
	public ScheduledCardsData(
		@JsonProperty("newScheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards, 
		@JsonProperty("existingScheduledCardIds") java.util.List<String> existingScheduledCardIds, 
		@JsonProperty("cardIds") java.util.List<String> cardIds, 
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			newScheduledCards,
			existingScheduledCardIds,
			cardIds,
			scheduledDate,
			userId,
			boxId,
			uuid
		);
	}

	public ScheduledCardsData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
