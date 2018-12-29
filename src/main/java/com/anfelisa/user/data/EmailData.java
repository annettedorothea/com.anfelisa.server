package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailData extends AbstractEmailData implements IEmailData {
	
	public EmailData(
		@JsonProperty("email") String email, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			email,
			uuid
		);
	}

	public EmailData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
