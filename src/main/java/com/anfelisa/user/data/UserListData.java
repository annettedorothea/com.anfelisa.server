package com.anfelisa.user.data;

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

}

/*       S.D.G.       */
