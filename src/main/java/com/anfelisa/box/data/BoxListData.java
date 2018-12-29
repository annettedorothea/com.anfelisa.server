package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxListData extends AbstractBoxListData implements IBoxListData {
	
	public BoxListData(
		@JsonProperty("boxList") java.util.List<com.anfelisa.box.models.IBoxInfoModel> boxList, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("today") org.joda.time.DateTime today, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			boxList,
			userId,
			today,
			uuid
		);
	}

	public BoxListData( String uuid ) {
		super(uuid);
	}

	
	public void migrateLegacyData(String json) {
	}

}

/*       S.D.G.       */
