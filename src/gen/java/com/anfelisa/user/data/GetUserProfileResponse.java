package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetUserProfileResponse implements IGetUserProfileResponse {
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	@NotNull
	private String userId;
	
	public GetUserProfileResponse(com.anfelisa.user.models.IUserModel data) {
		email = data.getEmail();
		username = data.getUsername();
		userId = data.getUserId();
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	
}

/*       S.D.G.       */
