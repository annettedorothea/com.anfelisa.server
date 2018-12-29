package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReinforceCardData extends AbstractReinforceCardData implements IReinforceCardData {
	
	public ReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			reinforceCardId,
			scheduledCardId,
			boxId,
			changeDate,
			uuid
		);
	}

	public ReinforceCardData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
