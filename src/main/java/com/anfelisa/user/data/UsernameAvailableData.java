package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameAvailableData extends AbstractUsernameAvailableData implements IUsernameAvailableData {

	public UsernameAvailableData(
			@JsonProperty("username") String username,
			@JsonProperty("available") Boolean available,
			@JsonProperty("uuid") String uuid) {
		super(
				username,
				available,
				uuid);
	}

	public UsernameAvailableData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
