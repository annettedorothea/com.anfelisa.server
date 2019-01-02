package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordData extends AbstractResetPasswordData implements IResetPasswordData {
	
	public ResetPasswordData(
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

	public ResetPasswordData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IResetPasswordData original = (IResetPasswordData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IResetPasswordData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
