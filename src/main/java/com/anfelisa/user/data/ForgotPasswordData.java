package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgotPasswordData extends AbstractForgotPasswordData implements IForgotPasswordData {
	
	public ForgotPasswordData(
		@JsonProperty("language") String language, 
		@JsonProperty("email") String email, 
		@JsonProperty("username") String username, 
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			language,
			email,
			username,
			token,
			userId,
			uuid
		);
	}

	public ForgotPasswordData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
