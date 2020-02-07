package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserData extends AbstractDeleteUserData implements IDeleteUserData {

	public DeleteUserData(
			@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted,
			@JsonProperty("username") String username,
			@JsonProperty("role") String role,
			@JsonProperty("uuid") String uuid) {
		super(
				usernameToBeDeleted,
				username,
				role,
				uuid);
	}

	public DeleteUserData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
