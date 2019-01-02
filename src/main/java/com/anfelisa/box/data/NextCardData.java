package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NextCardData extends AbstractNextCardData implements INextCardData {
	
	public NextCardData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("count") Integer count, 
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			today,
			scheduledCardId,
			cardId,
			scheduledDate,
			lastQuality,
			given,
			wanted,
			image,
			categoryId,
			rootCategoryId,
			count,
			scoredDate,
			boxId,
			uuid
		);
	}

	public NextCardData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				INextCardData original = (INextCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to INextCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
