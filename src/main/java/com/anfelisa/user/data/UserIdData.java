package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserIdData extends AbstractUserIdData implements IUserIdData {
	
	public UserIdData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			uuid
		);
	}

	public UserIdData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
