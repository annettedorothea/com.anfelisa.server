package de.acegen;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.acegen.AppConfiguration;

public class CustomAppConfiguration extends AppConfiguration {

	@Valid
	@NotNull
	@JsonProperty
	private String translationApiKey;

	public String getTranslationApiKey() {
		return translationApiKey;
	}

	@Valid
	@NotNull
	@JsonProperty
	private EmailConfiguration email;
	
	public EmailConfiguration getEmail() {
		return email;
	}

}
