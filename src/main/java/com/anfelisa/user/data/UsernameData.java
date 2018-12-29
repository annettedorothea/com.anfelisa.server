package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameData extends AbstractUsernameData implements IUsernameData {
	
	public UsernameData(
		@JsonProperty("username") String username, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			uuid
		);
	}

	public UsernameData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
