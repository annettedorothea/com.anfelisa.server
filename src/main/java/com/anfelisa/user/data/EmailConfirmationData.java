package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailConfirmationData extends AbstractEmailConfirmationData implements IEmailConfirmationData {
	
	public EmailConfirmationData(
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			token,
			userId,
			uuid
		);
	}

	public EmailConfirmationData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
