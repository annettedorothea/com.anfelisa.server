package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class UsernameModel implements IUsernameModel {

	@NotNull
	private String username;
	

	public UsernameModel(
		@JsonProperty("username") String username
	) {
		this.username = username;
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
