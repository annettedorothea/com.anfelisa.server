package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBoxData extends AbstractDeleteBoxData implements IDeleteBoxData {
	
	public DeleteBoxData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			uuid
		);
	}

	public DeleteBoxData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
