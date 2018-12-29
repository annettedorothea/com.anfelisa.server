package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NextReinforceCardData extends AbstractNextReinforceCardData implements INextReinforceCardData {
	
	public NextReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			reinforceCardId,
			changeDate,
			lastQuality,
			given,
			wanted,
			image,
			categoryId,
			userId,
			boxId,
			uuid
		);
	}

	public NextReinforceCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
