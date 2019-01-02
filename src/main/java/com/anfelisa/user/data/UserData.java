package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IUserData original = (IUserData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IUserData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
