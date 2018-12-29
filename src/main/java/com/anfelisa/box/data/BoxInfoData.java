package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxInfoData extends AbstractBoxInfoData implements IBoxInfoData {
	
	public BoxInfoData(
		@JsonProperty("todaysCards") Integer todaysCards, 
		@JsonProperty("totalCards") Integer totalCards, 
		@JsonProperty("reinforceCards") Integer reinforceCards, 
		@JsonProperty("myCards") Integer myCards, 
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("quality0Count") Integer quality0Count, 
		@JsonProperty("quality1Count") Integer quality1Count, 
		@JsonProperty("quality2Count") Integer quality2Count, 
		@JsonProperty("quality3Count") Integer quality3Count, 
		@JsonProperty("quality4Count") Integer quality4Count, 
		@JsonProperty("quality5Count") Integer quality5Count, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			todaysCards,
			totalCards,
			reinforceCards,
			myCards,
			daysBehindSchedule,
			categoryName,
			maxInterval,
			quality0Count,
			quality1Count,
			quality2Count,
			quality3Count,
			quality4Count,
			quality5Count,
			boxId,
			userId,
			today,
			uuid
		);
	}

	public BoxInfoData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
