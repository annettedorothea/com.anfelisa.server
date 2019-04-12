package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccessToCategoryData extends AbstractUserAccessToCategoryData implements IUserAccessToCategoryData {
	
	public UserAccessToCategoryData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			userId,
			editable,
			uuid
		);
	}

	public UserAccessToCategoryData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUserAccessToCategoryData original = (IUserAccessToCategoryData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUserAccessToCategoryData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
