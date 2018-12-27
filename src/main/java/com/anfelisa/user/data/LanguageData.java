package com.anfelisa.user.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageData extends AbstractData implements ILanguageData {
	
	@NotNull
	private String language;
	

	public LanguageData(
		@JsonProperty("language") String language
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.language = language;
	}

	public LanguageData( String uuid ) {
		super(uuid);
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
