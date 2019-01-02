package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationData extends AbstractUserRegistrationData implements IUserRegistrationData {
	
	public UserRegistrationData(
		@JsonProperty("language") String language, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("username") String username, 
		@JsonProperty("password") String password, 
		@JsonProperty("email") String email, 
		@JsonProperty("role") String role, 
		@JsonProperty("emailConfirmed") Boolean emailConfirmed, 
		@JsonProperty("token") String token, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			language,
			userId,
			username,
			password,
			email,
			role,
			emailConfirmed,
			token,
			uuid
		);
	}

	public UserRegistrationData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUserRegistrationData original = (IUserRegistrationData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUserRegistrationData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
