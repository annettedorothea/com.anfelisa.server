package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractLanguageData extends AbstractData implements ILanguageData {
	
	@NotNull
	private String language;
	

	public AbstractLanguageData(
		@JsonProperty("language") String language
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.language = language;
	}

	public AbstractLanguageData( String uuid ) {
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
