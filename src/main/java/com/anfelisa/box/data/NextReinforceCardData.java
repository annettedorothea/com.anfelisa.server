package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NextReinforceCardData extends AbstractNextReinforceCardData implements INextReinforceCardData {
	
	public NextReinforceCardData(
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxId,
			userId,
			reinforceCardId,
			changeDate,
			lastQuality,
			given,
			wanted,
			image,
			categoryId,
			uuid
		);
	}

	public NextReinforceCardData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				INextReinforceCardData original = (INextReinforceCardData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to INextReinforceCardData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
