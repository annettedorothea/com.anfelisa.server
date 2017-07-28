package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CredentialsModel implements ICredentialsModel {

	private String credentialsUsername;
	
	private String credentialsRole;
	
	private Boolean credentialsPremium;
	


	public CredentialsModel(
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("credentialsPremium") Boolean credentialsPremium
	) {
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.credentialsPremium = credentialsPremium;
	}

	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	
	@JsonProperty
	public Boolean getCredentialsPremium() {
		return this.credentialsPremium;
	}
	public void setCredentialsPremium(Boolean credentialsPremium) {
		this.credentialsPremium = credentialsPremium;
	}
	

		
}

/*       S.D.G.       */
