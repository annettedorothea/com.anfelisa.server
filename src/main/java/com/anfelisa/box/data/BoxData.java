package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxData extends AbstractBoxData implements IBoxData {

	public BoxData(
			@JsonProperty("boxId") String boxId,
			@JsonProperty("userId") String userId,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("maxInterval") Integer maxInterval,
			@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
			@JsonProperty("uuid") String uuid) {
		super(
				boxId,
				userId,
				categoryId,
				maxInterval,
				maxCardsPerDay,
				uuid);
	}

	public BoxData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
