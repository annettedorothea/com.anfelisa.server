package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostponeCardsData extends AbstractPostponeCardsData implements IPostponeCardsData {
	
	public PostponeCardsData(
		@JsonProperty("days") Integer days, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			days,
			boxId,
			userId,
			today,
			uuid
		);
	}

	public PostponeCardsData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IPostponeCardsData original = (IPostponeCardsData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IPostponeCardsData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
