package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserData extends AbstractDeleteUserData implements IDeleteUserData {
	
	public DeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted, 
		@JsonProperty("username") String username, 
		@JsonProperty("role") String role, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			usernameToBeDeleted,
			username,
			role,
			uuid
		);
	}

	public DeleteUserData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IDeleteUserData original = (IDeleteUserData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IDeleteUserData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
