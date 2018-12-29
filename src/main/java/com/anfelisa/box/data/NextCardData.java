package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NextCardData extends AbstractNextCardData implements INextCardData {
	
	public NextCardData(
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
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("uuid") String uuid
	) {
		super(
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
			userId,
			today,
			uuid
		);
	}

	public NextCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
