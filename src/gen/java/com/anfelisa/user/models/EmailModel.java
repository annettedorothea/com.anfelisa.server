package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
