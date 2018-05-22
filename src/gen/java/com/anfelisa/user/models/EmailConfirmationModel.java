package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class EmailConfirmationModel implements IEmailConfirmationModel {

	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public EmailConfirmationModel(
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.token = token;
		this.userId = userId;
	}

	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
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
