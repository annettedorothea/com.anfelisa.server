package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordWithNewPasswordData extends AbstractResetPasswordWithNewPasswordData
		implements IResetPasswordWithNewPasswordData {

	public ResetPasswordWithNewPasswordData(
			@JsonProperty("password") String password,
			@JsonProperty("token") String token,
			@JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(
				password,
				token,
				userId,
				uuid);
	}

	public ResetPasswordWithNewPasswordData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}

/* S.D.G. */
