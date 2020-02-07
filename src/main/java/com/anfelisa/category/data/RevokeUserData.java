package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevokeUserData extends AbstractRevokeUserData implements IRevokeUserData {

	public RevokeUserData(
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("rootCategoryId") String rootCategoryId,
			@JsonProperty("revokedUserId") String revokedUserId,
			@JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(
				categoryId,
				rootCategoryId,
				revokedUserId,
				userId,
				uuid);
	}

	public RevokeUserData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
