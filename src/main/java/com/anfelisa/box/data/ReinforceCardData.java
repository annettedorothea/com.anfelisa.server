package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IReinforceCardData original = (IReinforceCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IReinforceCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
