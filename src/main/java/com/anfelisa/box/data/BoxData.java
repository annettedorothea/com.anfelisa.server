package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxData extends AbstractBoxData implements IBoxData {
	
	public BoxData(
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxId,
			userId,
			categoryId,
			maxInterval,
			maxCardsPerDay,
			uuid
		);
	}

	public BoxData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IBoxData original = (IBoxData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IBoxData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
