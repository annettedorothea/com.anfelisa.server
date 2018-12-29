package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordData extends AbstractPasswordData implements IPasswordData {
	
	public PasswordData(
		@JsonProperty("password") String password, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			password,
			uuid
		);
	}

	public PasswordData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
