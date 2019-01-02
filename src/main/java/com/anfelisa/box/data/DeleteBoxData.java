package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBoxData extends AbstractDeleteBoxData implements IDeleteBoxData {
	
	public DeleteBoxData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			uuid
		);
	}

	public DeleteBoxData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IDeleteBoxData original = (IDeleteBoxData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IDeleteBoxData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
