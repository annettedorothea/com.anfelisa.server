package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordWithNewPasswordData extends AbstractResetPasswordWithNewPasswordData implements IResetPasswordWithNewPasswordData {
	
	public ResetPasswordWithNewPasswordData(
		@JsonProperty("password") String password, 
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			password,
			token,
			userId,
			uuid
		);
	}

	public ResetPasswordWithNewPasswordData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IResetPasswordWithNewPasswordData original = (IResetPasswordWithNewPasswordData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IResetPasswordWithNewPasswordData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
