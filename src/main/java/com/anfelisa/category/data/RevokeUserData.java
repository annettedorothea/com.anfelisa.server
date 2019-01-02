package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RevokeUserData extends AbstractRevokeUserData implements IRevokeUserData {
	
	public RevokeUserData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("revokedUserId") String revokedUserId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			rootCategoryId,
			revokedUserId,
			userId,
			uuid
		);
	}

	public RevokeUserData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IRevokeUserData original = (IRevokeUserData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IRevokeUserData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
