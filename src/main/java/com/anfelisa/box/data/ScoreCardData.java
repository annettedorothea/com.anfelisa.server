package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreCardData extends AbstractScoreCardData implements IScoreCardData {
	
	public ScoreCardData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("nextScheduledCardScheduledCardId") String nextScheduledCardScheduledCardId, 
		@JsonProperty("nextScheduledCardCreatedDate") org.joda.time.DateTime nextScheduledCardCreatedDate, 
		@JsonProperty("nextScheduledCardEf") Float nextScheduledCardEf, 
		@JsonProperty("nextScheduledCardInterval") Integer nextScheduledCardInterval, 
		@JsonProperty("nextScheduledCardN") Integer nextScheduledCardN, 
		@JsonProperty("nextScheduledCardCount") Integer nextScheduledCardCount, 
		@JsonProperty("nextScheduledCardScheduledDate") org.joda.time.DateTime nextScheduledCardScheduledDate, 
		@JsonProperty("nextScheduledCardLastQuality") Integer nextScheduledCardLastQuality, 
		@JsonProperty("scoredCardScheduledCardId") String scoredCardScheduledCardId, 
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality, 
		@JsonProperty("scoredCardScoredDate") org.joda.time.DateTime scoredCardScoredDate, 
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("reinforceCardCreatedDate") org.joda.time.DateTime reinforceCardCreatedDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			nextScheduledCardScheduledCardId,
			nextScheduledCardCreatedDate,
			nextScheduledCardEf,
			nextScheduledCardInterval,
			nextScheduledCardN,
			nextScheduledCardCount,
			nextScheduledCardScheduledDate,
			nextScheduledCardLastQuality,
			scoredCardScheduledCardId,
			scoredCardQuality,
			scoredCardScoredDate,
			reinforceCardId,
			reinforceCardCreatedDate,
			userId,
			boxId,
			uuid
		);
	}

	public ScoreCardData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IScoreCardData original = (IScoreCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IScoreCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
