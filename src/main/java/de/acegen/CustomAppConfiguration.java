package de.acegen;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomAppConfiguration extends AppConfiguration {

	@Valid
	@NotNull
	@JsonProperty
	private EmailConfiguration email;
	
	public EmailConfiguration getEmail() {
		return email;
	}
	
	private String secretString;
	
	@JsonProperty("secretString")
	public String getSecretString() {
		return secretString;
	}

	@Valid
	@NotNull
	@JsonProperty
	private String translationApiKey;

	public String getTranslationApiKey() {
		return translationApiKey;
	}


}
