package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreReinforceCardData extends AbstractScoreReinforceCardData implements IScoreReinforceCardData {
	
	public ScoreReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("quality") Integer quality, 
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			reinforceCardId,
			quality,
			changeDate,
			userId,
			uuid
		);
	}

	public ScoreReinforceCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
