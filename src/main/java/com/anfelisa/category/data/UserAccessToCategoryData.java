package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccessToCategoryData extends AbstractUserAccessToCategoryData implements IUserAccessToCategoryData {
	
	public UserAccessToCategoryData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			userId,
			uuid
		);
	}

	public UserAccessToCategoryData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
