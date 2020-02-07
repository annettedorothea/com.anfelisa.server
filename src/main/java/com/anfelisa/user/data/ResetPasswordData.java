package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordData extends AbstractResetPasswordData implements IResetPasswordData {

	public ResetPasswordData(
			@JsonProperty("token") String token,
			@JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(
				token,
				userId,
				uuid);
	}

	public ResetPasswordData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
