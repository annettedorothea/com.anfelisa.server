package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameAvailableData extends AbstractUsernameAvailableData implements IUsernameAvailableData {
	
	public UsernameAvailableData(
		@JsonProperty("username") String username, 
		@JsonProperty("available") Boolean available, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			available,
			uuid
		);
	}

	public UsernameAvailableData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUsernameAvailableData original = (IUsernameAvailableData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUsernameAvailableData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
