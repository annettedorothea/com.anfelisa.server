package com.anfelisa.user.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class UserIdModel implements IUserIdModel {

	@NotNull
	private String userId;
	

	public UserIdModel(
		@JsonProperty("userId") String userId
	) {
		this.userId = userId;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

/*       S.D.G.       */
