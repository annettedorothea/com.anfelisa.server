package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		if (dataContainer != null) {
			try {
				IForgotPasswordData original = (IForgotPasswordData)dataContainer;
				this.setToken(original.getToken());
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IForgotPasswordData for overwriting not replayable attributes", x);
			}
		}
	}

}

/*       S.D.G.       */
