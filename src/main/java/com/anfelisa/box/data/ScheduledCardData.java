package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IScheduledCardData original = (IScheduledCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IScheduledCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
