package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxInfoData extends AbstractBoxInfoData implements IBoxInfoData {
	
	public BoxInfoData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("todaysCards") Integer todaysCards, 
		@JsonProperty("totalCards") Integer totalCards, 
		@JsonProperty("reinforceCards") Integer reinforceCards, 
		@JsonProperty("myCards") Integer myCards, 
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("quality0Count") Integer quality0Count, 
		@JsonProperty("quality1Count") Integer quality1Count, 
		@JsonProperty("quality2Count") Integer quality2Count, 
		@JsonProperty("quality3Count") Integer quality3Count, 
		@JsonProperty("quality4Count") Integer quality4Count, 
		@JsonProperty("quality5Count") Integer quality5Count, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			today,
			todaysCards,
			totalCards,
			reinforceCards,
			myCards,
			daysBehindSchedule,
			categoryName,
			maxInterval,
			maxCardsPerDay,
			quality0Count,
			quality1Count,
			quality2Count,
			quality3Count,
			quality4Count,
			quality5Count,
			boxId,
			uuid
		);
	}

	public BoxInfoData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IBoxInfoData original = (IBoxInfoData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IBoxInfoData for overwriting not replayable attributes", x);
			}
		}*/
	}


}

/*       S.D.G.       */
