package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduledCardData extends AbstractScheduledCardData implements IScheduledCardData {
	
	public ScheduledCardData(
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("createdDate") org.joda.time.DateTime createdDate, 
		@JsonProperty("ef") Float ef, 
		@JsonProperty("interval") Integer interval, 
		@JsonProperty("n") Integer n, 
		@JsonProperty("count") Integer count, 
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("quality") Integer quality, 
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			scheduledCardId,
			cardId,
			boxId,
			createdDate,
			ef,
			interval,
			n,
			count,
			scheduledDate,
			lastQuality,
			quality,
			scoredDate,
			uuid
		);
	}

	public ScheduledCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
