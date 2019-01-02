package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmEmailData extends AbstractConfirmEmailData implements IConfirmEmailData {
	
	public ConfirmEmailData(
		@JsonProperty("username") String username, 
		@JsonProperty("token") String token, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			token,
			userId,
			uuid
		);
	}

	public ConfirmEmailData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		if (dataContainer != null) {
			try {
				IConfirmEmailData original = (IConfirmEmailData)dataContainer;
				this.setToken(original.getToken());
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to IConfirmEmailData for overwriting not replayable attributes", x);
			}
		}
	}

}

/*       S.D.G.       */
