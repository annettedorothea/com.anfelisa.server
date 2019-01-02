package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleData extends AbstractRoleData implements IRoleData {
	
	public RoleData(
		@JsonProperty("username") String username, 
		@JsonProperty("role") String role, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			role,
			uuid
		);
	}

	public RoleData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IRoleData original = (IRoleData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IRoleData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
