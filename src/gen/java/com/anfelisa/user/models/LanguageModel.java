package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LanguageModel implements ILanguageModel {

	@NotNull
	private String language;
	


	public LanguageModel(
		@JsonProperty("language") String language
	) {
		this.language = language;
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	


}

/*       S.D.G.       */
