package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxUpdateData extends AbstractBoxUpdateData implements IBoxUpdateData {
	
	public BoxUpdateData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			maxInterval,
			maxCardsPerDay,
			uuid
		);
	}

	public BoxUpdateData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IBoxUpdateData original = (IBoxUpdateData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IBoxUpdateData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
