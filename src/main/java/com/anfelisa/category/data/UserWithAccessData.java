package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWithAccessData extends AbstractUserWithAccessData implements IUserWithAccessData {
	
	public UserWithAccessData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("username") String username, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			username,
			uuid
		);
	}

	public UserWithAccessData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
