package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData extends AbstractUserData implements IUserData {
	
	public UserData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("username") String username, 
		@JsonProperty("password") String password, 
		@JsonProperty("email") String email, 
		@JsonProperty("role") String role, 
		@JsonProperty("emailConfirmed") Boolean emailConfirmed, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			username,
			password,
			email,
			role,
			emailConfirmed,
			uuid
		);
	}

	public UserData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
