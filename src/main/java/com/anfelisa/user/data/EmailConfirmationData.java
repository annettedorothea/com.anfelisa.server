package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
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

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				IEmailConfirmationData original = (IEmailConfirmationData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IEmailConfirmationData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
