package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
