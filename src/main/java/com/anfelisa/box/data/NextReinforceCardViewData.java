package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NextReinforceCardViewData extends AbstractNextReinforceCardViewData implements INextReinforceCardViewData {
	
	public NextReinforceCardViewData(
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

	public NextReinforceCardViewData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				INextReinforceCardViewData original = (INextReinforceCardViewData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to INextReinforceCardViewData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
