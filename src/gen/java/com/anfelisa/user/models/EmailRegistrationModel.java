package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class EmailRegistrationModel implements IEmailRegistrationModel {

	private String host;
	
	private Integer port;
	
	private String email;
	
	private String emailConfirmationHash;
	
	private String locale;
	

	public EmailRegistrationModel(
		@JsonProperty("host") String host,
		@JsonProperty("port") Integer port,
		@JsonProperty("email") String email,
		@JsonProperty("emailConfirmationHash") String emailConfirmationHash,
		@JsonProperty("locale") String locale
	) {
		this.host = host;
		this.port = port;
		this.email = email;
		this.emailConfirmationHash = emailConfirmationHash;
		this.locale = locale;
	}

	@JsonProperty
	public String getHost() {
		return this.host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	@JsonProperty
	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public String getEmailConfirmationHash() {
		return this.emailConfirmationHash;
	}
	public void setEmailConfirmationHash(String emailConfirmationHash) {
		this.emailConfirmationHash = emailConfirmationHash;
	}
	
	@JsonProperty
	public String getLocale() {
		return this.locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	

}

/*       S.D.G.       */
