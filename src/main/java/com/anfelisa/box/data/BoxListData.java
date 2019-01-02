package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxListData extends AbstractBoxListData implements IBoxListData {
	
	public BoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxViewModel> boxList, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxList,
			userId,
			today,
			uuid
		);
	}

	public BoxListData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IBoxListData original = (IBoxListData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IBoxListData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
