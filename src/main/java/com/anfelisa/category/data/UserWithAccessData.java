package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWithAccessData extends AbstractUserWithAccessData implements IUserWithAccessData {
	
	public UserWithAccessData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("username") String username, 
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			username,
			editable,
			uuid
		);
	}

	public UserWithAccessData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUserWithAccessData original = (IUserWithAccessData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUserWithAccessData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
