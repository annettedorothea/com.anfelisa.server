package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleNextCardData extends AbstractScheduleNextCardData implements IScheduleNextCardData {
	
	public ScheduleNextCardData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("cardId") String cardId, 
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
			userId,
			boxId,
			scheduledCardId,
			cardId,
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

	public ScheduleNextCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
