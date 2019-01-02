package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangeUserRoleData extends AbstractChangeUserRoleData implements IChangeUserRoleData {
	
	public ChangeUserRoleData(
		@JsonProperty("editedUserId") String editedUserId, 
		@JsonProperty("newRole") String newRole, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("role") String role, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			editedUserId,
			newRole,
			userId,
			role,
			uuid
		);
	}

	public ChangeUserRoleData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IChangeUserRoleData original = (IChangeUserRoleData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IChangeUserRoleData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
