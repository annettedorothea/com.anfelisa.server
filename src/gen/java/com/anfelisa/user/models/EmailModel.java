package com.anfelisa.user.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class EmailModel implements IEmailModel {

	@NotNull
	private String email;
	

	public EmailModel(
		@JsonProperty("email") String email
	) {
		this.email = email;
	}

	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

/*       S.D.G.       */
