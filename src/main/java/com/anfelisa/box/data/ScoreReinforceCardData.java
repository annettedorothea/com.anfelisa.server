package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IScoreReinforceCardData original = (IScoreReinforceCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IScoreReinforceCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
