package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWithAccessListData extends AbstractUserWithAccessListData implements IUserWithAccessListData {

	public UserWithAccessListData(
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList,
			@JsonProperty("uuid") String uuid) {
		super(
				categoryId,
				userList,
				uuid);
	}

	public UserWithAccessListData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
