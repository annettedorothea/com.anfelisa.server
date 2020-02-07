package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleData extends AbstractRoleData implements IRoleData {

	public RoleData(
			@JsonProperty("username") String username,
			@JsonProperty("role") String role,
			@JsonProperty("uuid") String uuid) {
		super(
				username,
				role,
				uuid);
	}

	public RoleData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
