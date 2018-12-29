package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailableData extends AbstractAvailableData implements IAvailableData {
	
	public AvailableData(
		@JsonProperty("available") Boolean available, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			available,
			uuid
		);
	}

	public AvailableData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
