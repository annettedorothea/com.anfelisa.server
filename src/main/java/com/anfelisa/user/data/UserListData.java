package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListData extends AbstractUserListData implements IUserListData {
	
	public UserListData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList, 
		@JsonProperty("role") String role, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userList,
			role,
			uuid
		);
	}

	public UserListData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUserListData original = (IUserListData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUserListData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
