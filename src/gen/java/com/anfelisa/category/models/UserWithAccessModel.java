package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserWithAccessModel implements IUserWithAccessModel {

	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	

	public UserWithAccessModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username
	) {
		this.userId = userId;
		this.username = username;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

/*       S.D.G.       */
