package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmEmailData extends AbstractConfirmEmailData implements IConfirmEmailData {
	
	public ConfirmEmailData(
		@JsonProperty("username") String username, 
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			token,
			userId,
			uuid
		);
	}

	public ConfirmEmailData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
